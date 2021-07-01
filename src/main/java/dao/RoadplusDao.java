package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import domain.Roadplus;

public class RoadplusDao {
    private static RoadplusDao instance = new RoadplusDao();
    
    private RoadplusDao() {
        
    }
    
    public static RoadplusDao getInstance() {
        return instance;
    }
    public List<Roadplus> selectOneRoad(int roadNumber, int fromToNumber) {
        List<Roadplus> roadList = new ArrayList<Roadplus>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDB", ConstValue.id, ConstValue.pw);
            Statement stmt = con.createStatement();
            ResultSet rset = null;
            
            String query = "select * from (select * from roadplus order by id desc limit 1470) as a where roadNumber=" + roadNumber + " and fromToNumber=" + fromToNumber + " order by roadNameOrder;";
            
            rset = stmt.executeQuery(query);
            while (rset.next()) {
                Roadplus roadplus = new Roadplus();
                roadplus.setDate(rset.getString(2));
                roadplus.setRoadNumber(rset.getInt(3));
                roadplus.setRoad(rset.getString(4));
                roadplus.setFromTo(rset.getString(5));
                roadplus.setFromToNumber(rset.getInt(6));
                roadplus.setRoadName(rset.getString(7));
                roadplus.setRoadNameNumber(rset.getInt(8));
                roadplus.setDistance(rset.getDouble(9));
                roadplus.setSpeed(rset.getDouble(10));
                roadplus.setColor(rset.getString(11));
                roadplus.setStatus(rset.getString(12));
                roadList.add(roadplus);
            }
            
            stmt.close();
            con.close();
        } catch (Exception e) {
            String err = e.getMessage();
            System.out.println(err);
            e.printStackTrace();
        } finally {}
        return roadList;
    }
    
    public List<Roadplus> selectFind(String road, int roadNumber) {
        List<Roadplus> roadList = new ArrayList<Roadplus>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDB", ConstValue.id, ConstValue.pw);
            Statement stmt = con.createStatement();
            ResultSet rset = null;
            String query = "";
            if (roadNumber != 0) {
                query = "select * from (select * from roadplus order by id desc limit 1470) as a where roadNumber=" + roadNumber + " and fromToNumber=1 and roadNameOrder=1 order by road;";
            } else {
                query = "select * from (select * from roadplus order by id desc limit 1470) as a where road like '%" + road + "%' and fromToNumber=1 and roadNameOrder=1 order by road;";
            }
            rset = stmt.executeQuery(query);
            while (rset.next()) {
                Roadplus roadplus = new Roadplus();
                roadplus.setDate(rset.getString(2));
                roadplus.setRoadNumber(rset.getInt(3));
                roadplus.setRoad(rset.getString(4));
                roadplus.setFromTo(rset.getString(5));
                roadplus.setFromToNumber(rset.getInt(6));
                roadplus.setRoadName(rset.getString(7));
                roadplus.setRoadNameNumber(rset.getInt(8));
                roadplus.setDistance(rset.getDouble(9));
                roadplus.setSpeed(rset.getDouble(10));
                roadplus.setColor(rset.getString(11));
                roadplus.setStatus(rset.getString(12));
                roadList.add(roadplus);
            }
            
            stmt.close();
            con.close();
        } catch (Exception e) {
            String err = e.getMessage();
            System.out.println(err);
            e.printStackTrace();
        } finally {}
        return roadList;
    }
    
    public List<Roadplus> selectMainList() {
        List<Roadplus> roadList = new ArrayList<Roadplus>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDB", ConstValue.id, ConstValue.pw);
            Statement stmt = con.createStatement();
            ResultSet rset = null;
            
            String query = "select * from (select * from roadplus order by id desc limit 1470) as a where fromToNumber=1 and roadNameOrder=1 order by road;";
            
            rset = stmt.executeQuery(query);
            while (rset.next()) {
                Roadplus roadplus = new Roadplus();
                roadplus.setDate(rset.getString(2));
                roadplus.setRoadNumber(rset.getInt(3));
                roadplus.setRoad(rset.getString(4));
                roadplus.setFromTo(rset.getString(5));
                roadplus.setFromToNumber(rset.getInt(6));
                roadplus.setRoadName(rset.getString(7));
                roadplus.setRoadNameNumber(rset.getInt(8));
                roadplus.setDistance(rset.getDouble(9));
                roadplus.setSpeed(rset.getDouble(10));
                roadplus.setColor(rset.getString(11));
                roadplus.setStatus(rset.getString(12));
                roadList.add(roadplus);
            }
            
            stmt.close();
            con.close();
        } catch (Exception e) {
            String err = e.getMessage();
            System.out.println(err);
            e.printStackTrace();
        } finally {}
        return roadList;
    }
    
    public List<Roadplus> selectPreviousData(int roadNumber, int fromToNumber) {
        List<Roadplus> roadList = new ArrayList<Roadplus>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDB", ConstValue.id, ConstValue.pw);
            Statement stmt = con.createStatement();
            ResultSet rset = null;
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH");
            cal.add(cal.DATE, -1);
            
            String query = "select * from (select * from roadplus where date like '" + sdf.format(cal.getTime()) + "%' order by id desc limit 1470) as a where roadNumber=" + roadNumber + " and fromToNumber=" + fromToNumber + " order by roadNameOrder;";
            
            rset = stmt.executeQuery(query);
            while (rset.next()) {
                Roadplus roadplus = new Roadplus();
                roadplus.setDate(rset.getString(2));
                roadplus.setRoadNumber(rset.getInt(3));
                roadplus.setRoad(rset.getString(4));
                roadplus.setFromTo(rset.getString(5));
                roadplus.setFromToNumber(rset.getInt(6));
                roadplus.setRoadName(rset.getString(7));
                roadplus.setRoadNameNumber(rset.getInt(8));
                roadplus.setDistance(rset.getDouble(9));
                roadplus.setSpeed(rset.getDouble(10));
                roadplus.setColor(rset.getString(11));
                roadplus.setStatus(rset.getString(12));
                roadList.add(roadplus);
            }
            
            if (roadList.size() == 0) {
                query = "select a.* from (select * from roadplus order by id desc limit 1470, 1470) as a where roadNumber=" + roadNumber + " and fromToNumber=" + fromToNumber + " order by roadNameOrder;";
                
                rset = stmt.executeQuery(query);
                while (rset.next()) {
                    Roadplus roadplus = new Roadplus();
                    roadplus.setDate(rset.getString(2));
                    roadplus.setRoadNumber(rset.getInt(3));
                    roadplus.setRoad(rset.getString(4));
                    roadplus.setFromTo(rset.getString(5));
                    roadplus.setFromToNumber(rset.getInt(6));
                    roadplus.setRoadName(rset.getString(7));
                    roadplus.setRoadNameNumber(rset.getInt(8));
                    roadplus.setDistance(rset.getDouble(9));
                    roadplus.setSpeed(rset.getDouble(10));
                    roadplus.setColor(rset.getString(11));
                    roadplus.setStatus(rset.getString(12));
                    roadList.add(roadplus);
                }
            }
            
            stmt.close();
            con.close();
        } catch (Exception e) {
            String err = e.getMessage();
            System.out.println(err);
            e.printStackTrace();
        } finally {}
        return roadList;
    }
    
}
