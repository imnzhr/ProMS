/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.task;

import com.security.LoginDB;
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
public class taskDB {
    private task clsTask;

    public taskDB() {
    }

    public taskDB(task clsTask) {
        this.clsTask = clsTask;
    }

    public task getClsTask() {
        return clsTask;
    }

    public void setClsTask(task clsTask) {
        this.clsTask = clsTask;
    }
    
    public ArrayList<task> selectTaskProject(String projId){
        
        ArrayList<task> taskList=new ArrayList<task>();
        try
         {
             Connection con = DBconnection.createConnection(); //Fetch database connection object
             Statement statement = con.createStatement(); //Statement is used to write queries. Read more about it.
             ResultSet resultSet = statement.executeQuery("select * from task"); //the table name is users and userName,password are columns. Fetching all the records and storing in a resultSet.
 
             while(resultSet.next()) // Until next row is present otherwise it return false
             {
                task task = new task();
                String id= resultSet.getString("id");
                String type= resultSet.getString("typeid");
                String department= resultSet.getString("depaid");
                String file= resultSet.getString("file");
                String remarks= resultSet.getString("remarks");
                String startDate= resultSet.getString("startDate");
                String dueDate= resultSet.getString("dueDate");
                String completedDate= resultSet.getString("completedDate");
                String isComplete= resultSet.getString("isComplete");
                String lateTask= resultSet.getString("lateTask");
                String projectID= resultSet.getString("projectId");
                

                if(projId.equals(projectID))
                {
                    task.setCompletedDate(completedDate);
                    task.setDepid(Integer.parseInt(department));
                    task.setDueDate(dueDate);
                    task.setFile(file);
                    task.setId(Integer.parseInt(id));
                    task.setIsComplete(Boolean.parseBoolean(isComplete));
                    task.setLateTask(Boolean.parseBoolean(lateTask));
                    task.setProjectID(Integer.parseInt(projectID));
                    task.setRemarks(remarks);
                    task.setStartDate(startDate);
                    task.setType(Integer.parseInt(type));

                    System.out.println(task.toString());
                    
                    taskList.add(task);
                    ////If the user entered values are already present in the database, which means user has already registered so return a SUCCESS message.
                }
                
            }
        return taskList;
            } catch (SQLException ex) {
               Logger.getLogger(LoginDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return taskList;
    }
    
    public ArrayList<task> selectTaskDepartment(int DepID){
       
        ArrayList<task> taskList=new ArrayList<task>();
        try
         {
             Connection con = DBconnection.createConnection(); //Fetch database connection object
             Statement statement = con.createStatement(); //Statement is used to write queries. Read more about it.
             ResultSet resultSet = statement.executeQuery("select * from task"); //the table name is users and userName,password are columns. Fetching all the records and storing in a resultSet.
 
             while(resultSet.next()) // Until next row is present otherwise it return false
             {  task Task = new task();
             
                String id= resultSet.getString("id");
                String type= resultSet.getString("typeid");
                String department= resultSet.getString("depaid");
                String file= resultSet.getString("file");
                String remarks= resultSet.getString("remarks");
                String startDate= resultSet.getString("startDate");
                String dueDate= resultSet.getString("dueDate");
                String completedDate= resultSet.getString("completedDate");
                String isComplete= resultSet.getString("isComplete");
                String lateTask= resultSet.getString("lateTask");
                String projectID= resultSet.getString("projectId");
                

                if(DepID == (Integer.parseInt(department)))
                {
                    Task.setCompletedDate(completedDate);
                    Task.setDepid(Integer.parseInt(department));
                    Task.setDueDate(dueDate);
                    Task.setFile(file);
                    Task.setId(Integer.parseInt(id));
                    Task.setIsComplete(Boolean.parseBoolean(isComplete));
                    Task.setLateTask(Boolean.parseBoolean(lateTask));
                    Task.setProjectID(Integer.parseInt(projectID));
                    Task.setRemarks(remarks);
                    Task.setStartDate(startDate);
                    Task.setType(Integer.parseInt(type));

                    System.out.println(Task.toString());
                    
                    taskList.add(Task);
                    ////If the user entered values are already present in the database, which means user has already registered so return a SUCCESS message.
                }
                
            }
            return taskList;
            } catch (SQLException ex) {
               Logger.getLogger(LoginDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return taskList;
    }
    
    public void deleteTask(){
        
    }
    
    public String addTask(task Task){
       
        int type = Task.getType();
        String stDate = Task.getStartDate();
        String DueDate = Task.getDueDate();
        boolean IsComp = Task.isIsComplete();
        boolean lateTask = Task.isLateTask();
        int DepID = Task.getDepid();
        int ProID = Task.getProjectID();
        String remarks = Task.getRemarks();
        
        Connection con = null;
        PreparedStatement pstmt = null;
        
        
        try
         {
            con = DBconnection.createConnection(); //Fetch database connection object
            String query = "INSERT INTO TASK(TYPEID,STARTDATE,DUEDATE,ISCOMPLETE,LATETASK,DEPAID,PROJECTID,REMARKS) VALUES(?,?,?,?,?,?,?,?)";
            pstmt = con.prepareStatement(query);
            
            pstmt.setInt(1, type);
            pstmt.setString(2, stDate);
            pstmt.setString(3, DueDate);
            pstmt.setBoolean(4, IsComp);
            pstmt.setBoolean(5, lateTask);
            pstmt.setInt(6, DepID);
            pstmt.setInt(7, ProID);
            pstmt.setString(8, remarks);
            
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
    
    public String getTaskName(int TTid){
        
        try
         {
             Connection con = DBconnection.createConnection(); //Fetch database connection object
             Statement statement = con.createStatement(); //Statement is used to write queries. Read more about it.
             ResultSet resultSet = statement.executeQuery("select name from tasktype where id ="+ TTid); //the table name is users and userName,password are columns. Fetching all the records and storing in a resultSet.
 
             while(resultSet.next()) // get the last project id
             {
                String name = resultSet.getString("name");
                
                return name;
            }
            } catch (SQLException ex) {
               Logger.getLogger(LoginDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        return null;
    }
    
    public String getTaskDesc(int TTid){
        
        try
         {
             Connection con = DBconnection.createConnection(); //Fetch database connection object
             Statement statement = con.createStatement(); //Statement is used to write queries. Read more about it.
             ResultSet resultSet = statement.executeQuery("select description from tasktype where id ="+ TTid); //the table name is users and userName,password are columns. Fetching all the records and storing in a resultSet.
 
             while(resultSet.next()) // get the last project id
             {
                String Desc = resultSet.getString("description");
                
                return Desc;
            }
            } catch (SQLException ex) {
               Logger.getLogger(LoginDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        return null;
    }
    
    public String updateTask(task Task){
        
        taskDB TaskDB = new taskDB();
        
        int taskId = Task.getId();
        int empId = Task.getEmpID();
        int proID = Task.getProjectID();
        int TypeID = Task.getType();
        boolean IsComp = Task.isIsComplete();
        boolean lateTask = Task.isLateTask();
        String CompDate = Task.getCompletedDate();
        String remarks = Task.getRemarks();
        String File = Task.getFile();
        
        
        int NextdepId = 0;
        task nextTask = new task();
        
        nextTask.setStartDate(java.time.LocalDate.now().toString());
        nextTask.setDueDate(java.time.LocalDate.now().plusDays(5).toString());
        nextTask.setIsComplete(false);
        nextTask.setLateTask(false);
        nextTask.setProjectID(proID);
        nextTask.setRemarks(" ");
        
        if(IsComp){
            
            if(TypeID==1 || TypeID==4)
            {
                NextdepId=4;//financial
                nextTask.setType(TypeID+1);
                nextTask.setDepid(NextdepId);
                String addTask = TaskDB.addTask(nextTask);
            }
        }

        Connection con = null;
        PreparedStatement pstmt = null;
        
        
        try
         {
            con = DBconnection.createConnection(); //Fetch database connection object
            String query = "UPDATE TASK SET EMPID=?, ISCOMPLETE = ?,LATETASK = ?, COMPLETEDDATE = ?, REMARKS = ?, FILE = ? WHERE ID = ?";
            pstmt = con.prepareStatement(query);
            
            
            pstmt.setInt(1, empId);
            pstmt.setBoolean(2, IsComp);
            pstmt.setBoolean(3, lateTask);
            pstmt.setString(4, CompDate);
            pstmt.setString(5, remarks);
            pstmt.setString(6, File);
            pstmt.setInt(7, taskId);
            
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
