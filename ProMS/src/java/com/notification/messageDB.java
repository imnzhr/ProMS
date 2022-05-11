/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.notification;


import com.employee.employee;
import com.security.LoginDB;
import com.task.*;
import com.util.DBconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author apitz
 */
public class messageDB {
    private message clsMessage;

    public messageDB() {
    }

    public messageDB(message clsMessage) {
        this.clsMessage = clsMessage;
    }

    public message getClsMessage() {
        return clsMessage;
    }

    public void setClsMessage(message clsMessage) {
        this.clsMessage = clsMessage;
    }
    
    public String addMessage(message Message){
        
        String title=Message.getTitle();
        String remarks=Message.getRemarks();
        String createDate=Message.getCreateDate();
        int empFrom = Message.getEmpFrom();
        int empTo = Message.getEmpTo();
        String Type = Message.getType();
        boolean isComp = Message.isIsComplete();
       
        Connection con = null;
        PreparedStatement pstmt = null;
        
        
        try
         {
            con = DBconnection.createConnection(); //Fetch database connection object
            String query = "INSERT INTO MESSAGE(TITLE,REMARKS,CREATEDATE,EMPFROM,EMPTO,TYPE) VALUES(?,?,?,?,?,?)";
            pstmt = con.prepareStatement(query);
            
            pstmt.setString(1, title);
            pstmt.setString(2, remarks);
            pstmt.setString(3, createDate);
            pstmt.setInt(4, empFrom);
            pstmt.setInt(5, empTo);
            pstmt.setString(6, Type);
            
            int R = pstmt.executeUpdate();
            if(R!=0) {
                return "SUCCESS";
            }
            return "Invalid user credentials"; // Return appropriate message in case of failure
        } catch (SQLException ex) {
            Logger.getLogger(taskDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "Oops...";
    
    }
    
    
    public ArrayList<message> selectMessageEmployee(employee emp){
       
        ArrayList<message> messageList=new ArrayList<message>();
        try
         {
             Connection con = DBconnection.createConnection(); //Fetch database connection object
             Statement statement = con.createStatement(); //Statement is used to write queries. Read more about it.
             ResultSet resultSet = statement.executeQuery("select * from message order by id desc"); //the table name is users and userName,password are columns. Fetching all the records and storing in a resultSet.
 
             while(resultSet.next()) // Until next row is present otherwise it return false
             { 
             
                message Message=new message();
             
                String id= resultSet.getString("id");
                String title= resultSet.getString("title");
                String remarks= resultSet.getString("remarks");
                String createdate= resultSet.getString("createdate");
                String empFrom= resultSet.getString("empfrom");
                String empTo= resultSet.getString("empto");
                String type= resultSet.getString("type");
                String isComp= resultSet.getString("iscomplete");
               
                if(type.equals("Message")){
                    if(emp.getId() == (Integer.parseInt(empTo)))
                    {
                        Message.setId(Integer.parseInt(id));
                        Message.setTitle(title);
                        Message.setType(type);
                        Message.setRemarks(remarks);
                        Message.setCreateDate(createdate);
                        Message.setEmpFrom(Integer.parseInt(empFrom));
                        Message.setEmpTo(Integer.parseInt(empTo));
                        Message.setIsComplete(Boolean.parseBoolean(isComp));

                        messageList.add(Message);
                        ////If the user entered values are already present in the database, which means user has already registered so return a SUCCESS message.
                    }
                }
                else if(type.equals("Task")){
                    if(emp.getDepID() == (Integer.parseInt(empTo))){
                        
                    Message.setId(Integer.parseInt(id));
                    Message.setTitle(title);
                    Message.setType(type);
                    Message.setRemarks(remarks);
                    Message.setCreateDate(createdate);
                    Message.setEmpFrom(Integer.parseInt(empFrom));
                    Message.setEmpTo(Integer.parseInt(empTo));
                    Message.setIsComplete(Boolean.parseBoolean(isComp));

                    messageList.add(Message);
                    ////If the user entered values are already present in the database, which means user has already registered so return a SUCCESS message.
                    }
                }
                
            }
            return messageList;
            } catch (SQLException ex) {
               Logger.getLogger(LoginDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return messageList;
    }
    public String updateMessage(message Message){
        
        int messageId = Message.getId();
        boolean IsComp = Message.isIsComplete();
        
        IsComp = true;
        
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try
         {
            con = DBconnection.createConnection(); //Fetch database connection object
            String query = "UPDATE MESSAGE SET ISCOMPLETE = ? WHERE ID = ?";
            pstmt = con.prepareStatement(query);
            
            
            pstmt.setBoolean(1, IsComp);
            pstmt.setInt(2, messageId);
            
            int R = pstmt.executeUpdate();
            if(R!=0) {
                return "SUCCESS";
            }
            return "Invalid user credentials"; // Return appropriate message in case of failure
        } catch (SQLException ex) {
            Logger.getLogger(taskDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "Oops...";
    }
    
    
}
