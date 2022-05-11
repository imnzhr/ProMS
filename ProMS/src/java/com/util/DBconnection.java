package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author apitz
 */
public class DBconnection {

    public static Connection createConnection(){
        
        Connection conn=null;
        
        try{
            
            
            String driver = "org.apache.derby.jdbc.ClientDriver";
            String connectionString = "jdbc:derby://localhost:1527/ProMS;create=true;user=app;password=app";
            
            Class.forName(driver);
            
            conn = DriverManager.getConnection(connectionString);
            
            }catch(Exception ex){
                ex.printStackTrace();
        }
        
        return conn;
    }
}
