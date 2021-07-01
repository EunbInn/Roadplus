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
	justify-contents: center;
	text-align: center;
	align-items: center;
  }
  
  #header {
    width: 1200px;
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
  }
  
  #btn {
    border: 2px solid #222831;
    color: #FFE194;
    width: 200px;
    font-size: 15px;
    padding: 7px 10px;
    border-radius: 3px;
    background-color: #222831;
    cursor: pointer;
    font-weight: bolder;
  }
  
  #road-info {
    margin: 0;
    width: 430px;
    background-color: #222831;
  }

  li {
    list-style:none;
    text-align: left;
    font-family: san-serif;
    width: 330px;
    display: inline-block;
    position: relative;
    padding: 5px 0px 10px 50px;
    left: -20px;
    border-bottom: 1px solid #3e4146;
    font-size: 18px;
    color: #E8F6EF;
  }
  
  li>*{
    position:relative;
  }
  
  li::before {
    position: absolute;
    bottom: 0;
    top: 0;
    left:2px;
    width: 13px;
    background: #ddd;
    z-index: 2; 
    border-radius: 50px;
    content: "";
  }
  
  li:first-child::before {
    top: 10px;
  }
  
  li::after {
    position: absolute;
    top: 108px;
    left: 0px;
    width: 9.5px;
    height: 9.5px;
    background-image: url('./arrow.png') center center no-repeat; 
    content: ""; 
    z-index: 3;
    border-left: 7px solid #F8EDE3;
    border-bottom: 7px solid #F8EDE3;
    border-radius: 50px;
    transform: rotate(-45deg);
  }
  
  li:last-child::after {
    display: none;
  }
  
  li.green::before {
    background-color: #01937C;
  }
  
  li.yellow::before {
    background-color: #D89216;
  }
  
  li.red::before {
    background-color: #C70039;
  }
  
  li.green dd {
    color: #01937C;
  }
  
  li.yellow dd {
    color: #D89216;
  }
  
  li.red dd {
    color: #C70039;
  }
  
  dl {
    list-style: none;
  }
  
  dl dd {
    margin-top: 5px;
    font-size: 16px;
    display: block;
    font-weight: bold;
    margin-left: 0;
  }
  
  .roadBtn {
    display: inline-block;
    border: 2px solid #FFE194;
    color: #282846;
    width: 150px;
    font-size: 15px;
    font-weight: bolder;
    padding: 7px 10px;
    border-radius: 3px;
    background-color: #FFE194;
    cursor: pointer;
    margin: 10px;
  }
  
  .roadBtn:hover {
    color: #FFE194;
    background-color: #222831;
  }
  
  #btn-box {
    padding-top: 10px;
    padding-bottom: 10px;
    border-bottom: 1px solid #3e4146;
  }
  
  .dif {
    margin-top: 0;
    color: ligthgray;
    font-size: 13px;
    font-weight: normal;
  }
</style>
</head>
<body>
  <div id="content-wrap">
      <%
      request.setCharacterEncoding("UTF-8");
      int roadNumber = Integer.parseInt(request.getParameter("roadNumber"));
      String upDown = request.getParameter("upDown");
      
      RoadplusDao roadDao = RoadplusDao.getInstance();
      List<Roadplus> roadShow = null;
      List<Roadplus> roadList = roadDao.selectOneRoad(roadNumber, 1);
      List<Roadplus> roadList2 = roadDao.selectOneRoad(roadNumber, 2);
      List<Roadplus> roadPrevious = null;
      if (upDown != null && !upDown.equals("")) {
        if(upDown.equals("1")) {
          roadShow = roadList;
          roadPrevious = roadDao.selectPreviousData(roadNumber, 1);
        } else {
          roadShow = roadList2;
          roadPrevious = roadDao.selectPreviousData(roadNumber, 2);
        }
      } else {
          roadShow = roadList;
          roadPrevious = roadDao.selectPreviousData(roadNumber, 1);
      }
      %>
    <div id="header"><i class="fas fa-road"></i> <%=roadList.get(0).getRoad() %></div>
      <br>
      <button onclick="location.href='./index.jsp'" id="btn">뒤로 가기</button>
      <br>
      
      
      <div id="road-info">
      <div id="btn-box">
        <button onclick="location.href='./oneRoad.jsp?roadNumber=<%=roadNumber %>&upDown=1'" class="roadBtn"><%=roadList.get(0).getFromTo() %></button>
        <button onclick="location.href='./oneRoad.jsp?roadNumber=<%=roadNumber %>&upDown=2'" class="roadBtn"><%=roadList2.get(0).getFromTo() %></button>
      </div>
      <br>
      <ul>
      <%
      for (int i = 0; i < roadShow.size(); i++) {
          Roadplus road = roadShow.get(i);
          Roadplus previous = roadPrevious.get(i);
          double difference = road.getSpeed() - previous.getSpeed();
          String difStr = "";
          if (difference < 0) {
              difStr = "정체";
              difference *= (-1);
          } else if (difference == 0) {
              difStr = "동일";
          } else {
              difStr = "원활";
          }
      %>
        <li class="<%=road.getColor()%>">
          <div>
            <dl>
              <dt>
                <%=road.getRoadName()%><span>(<%=road.getDistance()%>km)</span>
              </dt>
              <%if (road.getSpeed() != 0) { %>
              <dd><%=road.getSpeed() %> km/h</dd>
              <dd class="dif">(<%=previous.getDate().substring(0, (previous.getDate().length())-3) %> 대비  <%=String.format("%.1f", difference) %> km/h <%=difStr %>)</dd>
              <%} else {%>
              <dd>-</dd>
              <dd class="dif" style="color: #282846;">-</dd>
              <%} %>
            </dl>
          </div>
        </li>
      <%
      }
     
      %>
      </ul>
    </div>
  </div>
</body>
</html>