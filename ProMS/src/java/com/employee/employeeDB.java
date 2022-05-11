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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author apitz
 */
public class employeeDB {
    private employee clsEmp;

    public employeeDB() {
    }

    public employeeDB(employee clsEmp) {
        this.clsEmp = clsEmp;
    }

    public employee getClsEmp() {
        return clsEmp;
    }

    public void setClsEmp(employee clsEmp) {
        this.clsEmp = clsEmp;
    }
    
    public void addEmp(){
        
    }
    
    public void deleteEmp(){
        
    }
    
    public employee selectEmp(String user){
        employee emp = new employee();
        
        try
         {
             Connection con = DBconnection.createConnection(); //Fetch database connection object
             Statement statement = con.createStatement(); //Statement is used to write queries. Read more about it.
             ResultSet resultSet = statement.executeQuery("select employee.USERNAME, employee.EMPNAME, employee.\"empID\", employee.image, employee.depID, department.depname from employee INNER JOIN department ON employee.depid = department.depid"); //the table name is users and userName,password are columns. Fetching all the records and storing in a resultSet.
 
             while(resultSet.next()) // Until next row is present otherwise it return false
             {
                String empname = resultSet.getString("empname");//fetch the values present in database
                String empid = resultSet.getString("empid"); 
                String depname = resultSet.getString("depname");
                String userDB = resultSet.getString("username"); 
                String img = resultSet.getString("image");
                String depid = resultSet.getString("depid");

                if(user.equals(userDB))
                {
                    emp.setName(empname);
                    emp.setId(Integer.parseInt(empid));
                    emp.setDepname(depname);
                    emp.setImg(img);
                    emp.setUsername(userDB);
                    emp.setDepID(Integer.parseInt(depid));
                    System.out.println(emp.toString());
                    return emp; ////If the user entered values are already present in the database, which means user has already registered so return a SUCCESS message.
                }
            }
            } catch (SQLException ex) {
               Logger.getLogger(LoginDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return emp;
    }
    
    public ArrayList<employee> selectEmp(){
        ArrayList<employee> empList = new ArrayList<employee>();
        
        
        try
         {
             Connection con = DBconnection.createConnection(); //Fetch database connection object
             Statement statement = con.createStatement(); //Statement is used to write queries. Read more about it.
             ResultSet resultSet = statement.executeQuery("select employee.USERNAME, employee.EMPNAME, employee.\"empID\", employee.image, employee.depID, department.depname from employee INNER JOIN department ON employee.depid = department.depid"); //the table name is users and userName,password are columns. Fetching all the records and storing in a resultSet.
 
             while(resultSet.next()) // Until next row is present otherwise it return false
             {
                employee emp=new employee();
                String empname = resultSet.getString("empname");//fetch the values present in database
                String empid = resultSet.getString("empid"); 
                String depname = resultSet.getString("depname");
                String userDB = resultSet.getString("username"); 
                String img = resultSet.getString("image");
                String depid = resultSet.getString("depid");

                
                    emp.setName(empname);
                    emp.setId(Integer.parseInt(empid));
                    emp.setDepname(depname);
                    emp.setImg(img);
                    emp.setUsername(userDB);
                    emp.setDepID(Integer.parseInt(depid));
                    System.out.println(emp.toString());
                      
                    empList.add(emp);
            }
             
             return empList; ////If the user entered values are already present in the database, which means user has already registered so return a SUCCESS message.
             
            } catch (SQLException ex) {
               Logger.getLogger(LoginDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return empList;
    }
    
    public void updateEmp(){
        
    }
}
