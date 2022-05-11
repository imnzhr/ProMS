/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.security;

import com.util.DBconnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aidie
 */
public class LoginDB {
    public String authenticateUser(login Login)
     {
         String userName = Login.getUsername(); //Assign user entered values to temporary variables.
         String password = Login.getPassword();
 
         Connection con = null;
         Statement statement = null;
         ResultSet resultSet = null;
 
         String userDB = "";
         String passDB = "";
 
         try
         {
             con = DBconnection.createConnection(); //Fetch database connection object
             statement = con.createStatement(); //Statement is used to write queries. Read more about it.
             resultSet = statement.executeQuery("select username,password from employee"); //the table name is users and userName,password are columns. Fetching all the records and storing in a resultSet.
 
             while(resultSet.next()) // Until next row is present otherwise it return false
             {
              userDB = resultSet.getString("username"); //fetch the values present in database
              passDB = resultSet.getString("password");
 
               if(userName.equals(userDB) && password.equals(passDB))
               {
                  return "SUCCESS"; ////If the user entered values are already present in the database, which means user has already registered so return a SUCCESS message.
               }
             }
             return "Invalid user credentials"; // Return appropriate message in case of failure
         } catch (SQLException ex) {
             Logger.getLogger(LoginDB.class.getName()).log(Level.SEVERE, null, ex);
         }
         return null;
     }
    
}
