/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project;

/**
 *
 * @author apitz
 */
public class supplier implements java.io.Serializable{
    private int supID;
    private String supName;
    private String supContact;
    private String supAddress;

    public supplier() {
    }

    public supplier(int supID, String supName, String supContact, String supAddress) {
        this.supID = supID;
        this.supName = supName;
        this.supContact = supContact;
        this.supAddress = supAddress;
    }

    public int getSupID() {
        return supID;
    }

    public void setSupID(int supID) {
        this.supID = supID;
    }

    public String getSupName() {
        return supName;
    }

    public void setSupName(String supName) {
        this.supName = supName;
    }

    public String getSupContact() {
        return supContact;
    }

    public void setSupContact(String supContact) {
        this.supContact = supContact;
    }

    public String getSupAddress() {
        return supAddress;
    }

    public void setSupAddress(String supAddress) {
        this.supAddress = supAddress;
    }
    
    
}
