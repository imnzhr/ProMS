/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project;

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
public class clientDB {
    private client clsClient;

    public clientDB() {
    }

    public clientDB(client clsClient) {
        this.clsClient = clsClient;
    }

    public client getClsClient() {
        return clsClient;
    }

    public void setClsClient(client clsClient) {
        this.clsClient = clsClient;
    }


    public String addClient(client Client){
        
        String name = Client.getClientName();
        String Cont = Client.getClientContact();
        String Address = Client.getClientAddress();
        
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try{
            
            con = DBconnection.createConnection();
            String query = "INSERT INTO CLIENT(NAME,CONTACT,ADDRESS) VALUES(?,?,?)";
            pstmt = con.prepareStatement(query);
      
            pstmt.setString(1, name);
            pstmt.setString(2, Cont);
            pstmt.setString(3, Address);
             
            int R = pstmt.executeUpdate();
            if(R!=0) {
                return "SUCCESS";
            }
            return "Invalid user credentials"; // Return appropriate message in case of failure
        } catch (SQLException ex) {
            Logger.getLogger(clientDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Oops.. Something Happen";
    }
    
    public void deleteClient(){
        
    }
    
    public ArrayList<client> selectClient(){
        ArrayList<client> clientList = new ArrayList<client>();
        
        try
         {
             Connection con = DBconnection.createConnection(); //Fetch database connection object
             Statement statement = con.createStatement(); //Statement is used to write queries. Read more about it.
             ResultSet resultSet = statement.executeQuery("select * from client"); //the table name is users and userName,password are columns. Fetching all the records and storing in a resultSet.
 
             while(resultSet.next()) // Until next row is present otherwise it return false
             {  
                 client client=new client();
             
                String clientname = resultSet.getString("name");//fetch the values present in database
                String clientid = resultSet.getString("id"); 
                String contact = resultSet.getString("contact");
                String address = resultSet.getString("address"); 

                client.setClientID(Integer.parseInt(clientid));
                client.setClientName(clientname);
                client.setClientContact(contact);
                client.setClientAddress(address);
                System.out.println(client.toString());
                 ////If the user entered values are already present in the database, which means user has already registered so return a SUCCESS message.
                clientList.add(client);
                client.toString();
            }
            return clientList;
            } catch (SQLException ex) {
               Logger.getLogger(LoginDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        return clientList;  
    }
    
    public int getClientID(String Cname){
        
         ArrayList<client> clientList = new ArrayList<client>();
         
         clientList = selectClient();
         
         for(int i=0; i<clientList.size(); i++){
             client temp= (client) clientList.get(i);
             temp.toString();
             
             if(temp.getClientName().equals(Cname)){
                 int id = temp.getClientID();
                 return id;
             }
         }
         
         return 0;
    }
    
    public void updateClient(){
        
    }
}
