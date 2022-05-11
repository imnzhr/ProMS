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
public class loginManager {
    
    private login clsLogin;
    private boolean checklogin;
    private boolean forgotPass;

    public loginManager() {
    }

    public login getClsLogin() {
        return clsLogin;
    }

    public void setClsLogin(login clsLogin) {
        this.clsLogin = clsLogin;
    }

    public boolean isChecklogin() {
        return checklogin;
    }

    public void setChecklogin(boolean checklogin) {
        this.checklogin = checklogin;
    }

    public boolean isForgotPass() {
        return forgotPass;
    }

    public void setForgotPass(boolean forgotPass) {
        this.forgotPass = forgotPass;
    }
    
    public void checkLogin(){
     
        

    }
    
    public void forgotPassword(){
        if(forgotPass==true)
        {
            //get staff email
            //send email
        }
    }
}
