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
public class client implements java.io.Serializable{
    private int clientID;
    private String clientName;
    private String clientContact;
    private String clientAddress;

    public client() {
    }

    public client(int clientID, String clientName, String clientContact, String clientAddress) {
        this.clientID = clientID;
        this.clientName = clientName;
        this.clientContact = clientContact;
        this.clientAddress = clientAddress;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientContact() {
        return clientContact;
    }

    public void setClientContact(String clientContact) {
        this.clientContact = clientContact;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    @Override
    public String toString() {
        return "client{" + "clientID=" + clientID + ", clientName=" + clientName + ", clientContact=" + clientContact + ", clientAddress=" + clientAddress + '}';
    }
    
    
}
