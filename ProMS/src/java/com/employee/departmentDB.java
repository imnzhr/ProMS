/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.employee;

import com.security.LoginDB;
import com.util.DBconnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author apitz
 */
public class departmentDB {
    private department clsDep;

    public departmentDB() {
    }

    public departmentDB(department clsDep) {
        this.clsDep = clsDep;
    }

    public department getClsDep() {
        return clsDep;
    }

    public void setClsDep(department clsDep) {
        this.clsDep = clsDep;
    }
    
    public void addDep(){
        
    }
    
    public void deleteDep(){
        
    }
    
    public void selectDep(){
        
    }
    
    public void updateDep(){
        
    }
    
    public String getDepName(int Depid){
        
        try
         {
             Connection con = DBconnection.createConnection(); //Fetch database connection object
             Statement statement = con.createStatement(); //Statement is used to write queries. Read more about it.
             ResultSet resultSet = statement.executeQuery("select depname from department where depid ="+ Depid); //the table name is users and userName,password are columns. Fetching all the records and storing in a resultSet.
 
             while(resultSet.next()) // get the last project id
             {
                String name = resultSet.getString("depname");
                
                return name;
            }
            } catch (SQLException ex) {
               Logger.getLogger(LoginDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        return null;
    }
}
