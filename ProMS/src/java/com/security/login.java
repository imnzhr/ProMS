/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.security;

/**
 *
 * @author apitz
 */
public class login implements java.io.Serializable{
    
    private int empID;
    private String username;
    private String password;

    public login() {
    }

    public login(int empID, String username, String password) {
        this.empID = empID;
        this.username = username;
        this.password = password;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
