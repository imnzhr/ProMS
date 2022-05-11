/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.task;

/**
 *
 * @author apitz
 */
public class task implements java.io.Serializable{
    private int id;
    private int type;
    private String status;
    private int depid;
    private String title;
    private String file;
    private String remarks;
    private String startDate;
    private String dueDate;
    private String completedDate;
    private boolean isComplete;
    private boolean lateTask;
    private int projectID;
    private int empID;

    public task() {
    }

    public task(int id, int type, String status, int department, String title, String file, String remarks, String startDate, String dueDate, String completedDate, boolean isComplete, boolean lateTask, int projectID, int empID) {
        this.id = id;
        this.type = type;
        this.status = status;
        this.depid = depid;
        this.title = title;
        this.file = file;
        this.remarks = remarks;
        this.startDate = startDate;
        this.dueDate = dueDate;
        this.completedDate = completedDate;
        this.isComplete = isComplete;
        this.lateTask = lateTask;
        this.projectID = projectID;
        this.empID = empID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getDepid() {
        return depid;
    }

    public void setDepid(int depid) {
        this.depid = depid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getCompletedDate() {
        return completedDate;
    }

    public void setCompletedDate(String completedDate) {
        this.completedDate = completedDate;
    }

    public boolean isIsComplete() {
        return isComplete;
    }

    public void setIsComplete(boolean isComplete) {
        this.isComplete = isComplete;
    }

    public boolean isLateTask() {
        return lateTask;
    }

    public void setLateTask(boolean lateTask) {
        this.lateTask = lateTask;
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }
    
    public void checkDue(){
        return;
    }

    @Override
    public String toString() {
        return "task{" + "id=" + id + ", type=" + type + ", status=" + status + ", depid=" + depid + ", title=" + title + ", file=" + file + ", remarks=" + remarks + ", startDate=" + startDate + ", dueDate=" + dueDate + ", completedDate=" + completedDate + ", isComplete=" + isComplete + ", lateTask=" + lateTask + ", projectID=" + projectID + ", empID=" + empID + '}';
    }
    
}
