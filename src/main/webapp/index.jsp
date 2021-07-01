<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="domain.Roadplus, dao.RoadplusDao" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<style>
  body {
    margin: 0;
    display: flex;
    justify-content: center;
  }
  
  #content-wrap {
    width: 1200px;
    display: flex;
    flex-direction: column;
    justify-content: center;
    items-align: center;
    text-align: center;
  }
  
  #header {
    padding: 20px;
    border-bottom: 2px solid #4C4C6D;
    color: #4C4C6D;
    font-family: san-serif;
    font-size: 30px;
    font-weight: bolder;
  }
  
  #search {
    width: 270px;
    height: 25px;
    padding: 5px 7px;
    font-size: 15px;
    border: 1px solid #282846;
    border-radius: 2px;
  }
  
  #btn {
    border: 2px solid #FFE194;
    color: #282846;
    font-size: 15px;
    padding: 6px 20px;
    border-radius: 3px;
    background-color: #FFE194;
    cursor: pointer;
  }
  
  #btn:hover {
    color: #FFE194;
    background-color: #4C4C6D;
  }
  
  .road {
    font-family: san-serif;
    display: inline-block;
    line-height: 50px;
    width: 400px;
    height: 50px;
    margin: 2px 100px;
    border-radius: 3px;
    border: 3px solid #4C4C6D;
    background-color: #4C4C6D;
    text-decoration: none;
    font-size: 20px;
    color: #E8F6EF;
  }
  
  .road:hover {
    font-weight: bolder;
    background-color: #EFEFEF;
    color: #4C4C6D;
  }
</style>
</head>
<body>
  <div id="content-wrap">
    <div id="header"><i class="fas fa-car"></i> 노선별 교통정보</div>
    <br>
    <div id="search-box">
      <form method="POST">
        <input type="text" id="search" name="search" placeholder="노선번호 혹은 노선명을 입력해주세요">
        <input type="submit" formaction="./index.jsp" value="검색" id="btn">
      </form>
    </div>
    <br>
    <div id="road-info">
      <%
      request.setCharacterEncoding("UTF-8");
      String search = request.getParameter("search");
      int iSearch = 0;
      
      RoadplusDao roadDao = RoadplusDao.getInstance();
      List<Roadplus> roadList = null;
      if (search != null) {
        try {
          iSearch = Integer.parseInt(search);
          roadList = roadDao.selectFind(search, iSearch);
        } catch (NumberFormatException e) {
          roadList = roadDao.selectFind(search, iSearch);
        }
      } else {
        roadList = roadDao.selectMainList();
      }
      for (int i = 0; i < roadList.size(); i++) {
          Roadplus road = roadList.get(i);
      %>
      <a href="oneRoad.jsp?roadNumber=<%=road.getRoadNumber()%>">
        <div class="road">
         <%=road.getRoadNumber()%> | <%=road.getRoad()%>
        </div>
      </a>
      <%
      }
     
      %>
    </div>
    <div></div>
  </div>
</body>
</html>
