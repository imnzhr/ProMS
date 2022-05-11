/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.notification;

/**
 *
 * @author apitz
 */
public class message implements java.io.Serializable{
    private int id;
    private String title;
    private String type;
    private String remarks;
    private String createDate;
    private String dueDate;
    private int empFrom;
    private int empTo;
    private boolean isComplete;

    public message() {
    }

    public boolean isIsComplete() {
        return isComplete;
    }

    public void setIsComplete(boolean isComplete) {
        this.isComplete = isComplete;
    }

    public message(int id, String title, String type, String remarks, String createDate,String dueDate) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.remarks = remarks;
        this.createDate = createDate;
        this.dueDate = dueDate;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public int getEmpFrom() {
        return empFrom;
    }

    public void setEmpFrom(int empFrom) {
        this.empFrom = empFrom;
    }

    public int getEmpTo() {
        return empTo;
    }

    public void setEmpTo(int empTo) {
        this.empTo = empTo;
    }
    
}
