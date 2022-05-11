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
public class forgotPassword {
    private login clsLogin;
    private String email;

    public forgotPassword() {
    }

    public forgotPassword(login clsLogin, String email) {
        this.clsLogin = clsLogin;
        this.email = email;
    }

    public login getClsLogin() {
        return clsLogin;
    }

    public void setClsLogin(login clsLogin) {
        this.clsLogin = clsLogin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void getStaffEmail(){
        
    }
    
    public void sendEmail(){
        
    }
}
