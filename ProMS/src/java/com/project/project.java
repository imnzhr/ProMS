/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project;

import java.sql.Blob;


/**
 *
 * @author apitz
 */
public class project implements java.io.Serializable{
    private int id;
    private String title;
    private supplier supplier;
    private client client;
    private String address;
    private String startDate;
    private String endDate;
    private String estEndDate;
    private int status;
    private String progress;
    private String quotFile;
    private String thumbnail;
    private boolean isComplete;
    private boolean lateProject;
    private String warranty;
    private int clientID;
    private int supplierID;

    public project() {
    }

    public project(int id, String title, supplier supplier, client client, String address, String startDate, 
            String endDate, String estEndDate, int status, String progress, String quotFile, String thumbnail, 
            boolean isComplete, boolean lateProject, String warranty, int clientID, int supplierID) {
        
        this.id = id;
        this.title = title;
        this.supplier = supplier;
        this.client = client;
        this.address = address;
        this.startDate = startDate;
        this.endDate = endDate;
        this.estEndDate = estEndDate;
        this.status = status;
        this.progress = progress;
        this.quotFile = quotFile;
        this.thumbnail = thumbnail;
        this.isComplete = isComplete;
        this.lateProject = lateProject;
        this.warranty = warranty;
        this.clientID = clientID;
        this.supplierID = supplierID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(supplier supplier) {
        this.supplier = supplier;
    }

    public client getClient() {
        return client;
    }

    public void setClient(client client) {
        this.client = client;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getEstEndDate() {
        return estEndDate;
    }

    public void setEstEndDate(String estEndDate) {
        this.estEndDate = estEndDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public String getQuotFile() {
        return quotFile;
    }

    public void setQuotFile(String quotFile) {
        this.quotFile = quotFile;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public boolean isIsCOmplete() {
        return isComplete;
    }

    public void setIsCOmplete(boolean isCOmplete) {
        this.isComplete = isCOmplete;
    }

    public boolean isLateProject() {
        return lateProject;
    }

    public void setLateProject(boolean lateProject) {
        this.lateProject = lateProject;
    }

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public int getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }
    
    public void checkDue(){
        
    }
    
    public void checkWarranty(){
        
    }

    @Override
    public String toString() {
        return "project{" + "id=" + id + ", title=" + title + ", supplier=" + supplier + ", client=" + client + ", address=" + address + ", startDate=" + startDate + ", endDate=" + endDate + ", estEndDate=" + estEndDate + ", status=" + status + ", progress=" + progress + ", quotFile=" + quotFile + ", thumbnail=" + thumbnail + ", isComplete=" + isComplete + ", lateProject=" + lateProject + ", warranty=" + warranty + ", clientID=" + clientID + ", supplierID=" + supplierID + '}';
    }
    
}
