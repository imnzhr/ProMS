/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project;

import com.security.LoginDB;
import com.task.taskDB;
import com.util.DBconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author apitz
 */
public class projectDB {
    private project clsProject;

    public projectDB() {
    }

    public projectDB(project clsProject) {
        this.clsProject = clsProject;
    }

    public project getClsProject() {
        return clsProject;
    }

    public void setClsProject(project clsProject) {
        this.clsProject = clsProject;
    }

    public String addProject(project Project){
        
        String title = Project.getTitle();
        String Address = Project.getAddress();
        String stDate = Project.getStartDate();
        String estEndDate = Project.getEstEndDate();
        int clieID = Project.getClientID();
        int SupID = Project.getSupplierID();
        String img = Project.getQuotFile();
        int status = Project.getStatus();
        String warr = Project.getWarranty();
        
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try
         {
            con = DBconnection.createConnection(); //Fetch database connection object
            String query = "INSERT INTO PROJECT(TITLE,ADDRESS,STARTDATE,ESTENDDATE,CLIENTID,SUPPLIERID,QUOFILE,STATUS,WARRANTY) VALUES(?,?,?,?,?,?,?,?,?)";
            pstmt = con.prepareStatement(query);
            
            pstmt.setString(1, title);
            pstmt.setString(2, Address);
            pstmt.setString(3, stDate);
            pstmt.setString(4, estEndDate);
            pstmt.setInt(5, clieID);
            pstmt.setInt(6, SupID);
            pstmt.setString(7, img);
            pstmt.setInt(8, status);
            pstmt.setString(9, warr);
            
            int R = pstmt.executeUpdate();
            if(R!=0) {
                return "SUCCESS";
            }
            return "Invalid user credentials"; // Return appropriate message in case of failure
        } catch (SQLException ex) {
            Logger.getLogger(projectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "oops";
        
    }
    
    public void deleteProject(){
        
    }
    
    public project selectProject(int id){
        project pro = new project();
        supplier supp = new supplier();
        client clie = new client();
        
        try
         {
             Connection con = DBconnection.createConnection(); //Fetch database connection object
             Statement statement = con.createStatement(); //Statement is used to write queries. Read more about it.
             ResultSet resultSet = statement.executeQuery("select "+
                     "project.\"proID\", project.title, project.address, project.startdate, project.estenddate, project.clientid, project.supplierid, project.status, project.warranty, "+
                     "client.id, client.name AS clientName, client.contact AS clientCont, supplier.id, supplier.name AS suppName, supplier.contact AS suppCont "+
                     "from project JOIN client ON project.clientid = client.id JOIN supplier ON project.supplierid = supplier.id"); //the table name is users and userName,password are columns. Fetching all the records and storing in a resultSet.
 
             while(resultSet.next()) // Until next row is present otherwise it return false
             {
                String title = resultSet.getString("title");//fetch the values present in database
                String proID = resultSet.getString("proID");
                String warranty = resultSet.getString("warranty");
                String clientName = resultSet.getString("clientname");
                String clientCont = resultSet.getString("clientcont");
                String suppName = resultSet.getString("suppname");
                String suppCont = resultSet.getString("suppcont");
                String address = resultSet.getString("address");
                String status = resultSet.getString("status");
                String startDate = resultSet.getString("startdate"); 
                String estEndDate = resultSet.getString("estenddate");
                

                if(id == Integer.parseInt(proID))
                {
                    pro.setTitle(title);
                    pro.setId(Integer.parseInt(proID));
                    pro.setAddress(address);
                    pro.setWarranty(warranty);
                    clie.setClientName(clientName);
                    clie.setClientContact(clientCont);
                    supp.setSupName(suppName);
                    supp.setSupContact(suppCont);
                    pro.setStartDate(startDate);
                    pro.setEstEndDate(estEndDate);
                    pro.setStatus(Integer.parseInt(status));
                    
                    pro.setSupplier(supp);
                    pro.setClient(clie);
                    
                    return pro; ////If the user entered values are already present in the database, which means user has already registered so return a SUCCESS message.
                }
            }
            } catch (SQLException ex) {
               Logger.getLogger(LoginDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return pro;
        
    }
    
    public int selectLatestProj(){
        
        try
         {
             Connection con = DBconnection.createConnection(); //Fetch database connection object
             Statement statement = con.createStatement(); //Statement is used to write queries. Read more about it.
             ResultSet resultSet = statement.executeQuery("select MAX(\"proID\") AS proID from project"); //the table name is users and userName,password are columns. Fetching all the records and storing in a resultSet.
 
             while(resultSet.next()) // get the last project id
             {
                String proID = resultSet.getString("proID");
                System.out.print("ID last" + proID);
                return Integer.parseInt(proID);
            }
            } catch (SQLException ex) {
               Logger.getLogger(LoginDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        return 0;
    }
    
    public String updateProject(project Project){
        
        int proID = Project.getId();
        String enddate = Project.getEndDate();
        int Status = Project.getStatus();
        String prog = Project.getProgress();
        boolean Comp = Project.isIsCOmplete();
        boolean late = Project.isLateProject();
        
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try
         {
            con = DBconnection.createConnection(); //Fetch database connection object
            String query = "UPDATE PROJECT SET ENDDATE=?, STATUS = ?, PROGRESS = ?, ISCOMPLETE = ?, LATEPROJECT = ? WHERE \"proID\" = ?";
            pstmt = con.prepareStatement(query);
            
            pstmt.setString(1, enddate);
            pstmt.setInt(2, Status);
            pstmt.setString(3, prog);
            pstmt.setBoolean(4, Comp);
            pstmt.setBoolean(5, late);
            pstmt.setInt(6, proID);
            
          int R = pstmt.executeUpdate();
            if(R!=0) {
                return "SUCCESS";
            }
            return "Invalid user credentials"; // Return appropriate message in case of failure
        } catch (SQLException ex) {
            Logger.getLogger(taskDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "oops.. ";
    }
}
