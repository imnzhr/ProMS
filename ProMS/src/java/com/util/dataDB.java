/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util;

import com.util.DBconnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author apitz
 */
public class dataDB {
    public int getSize(String tableName){
        
        int size=0;
        
        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            con = DBconnection.createConnection();
            statement = con.createStatement();
            resultSet = statement.executeQuery("Select count(*) AS count from "+tableName);
            resultSet.next();
            size=resultSet.getInt("count");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return size;
    }
    
    public int nextID(String tableName){
    
        return (getSize(tableName)+1);
    }
    
    
    
}
