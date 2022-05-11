/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.notification;

import com.project.project;
import com.task.task;

/**
 *
 * @author apitz
 */
public class notificationManager {
    private task clsTask;
    private message clsMessage;
    private project clsProject;

    public notificationManager() {
    }

    public notificationManager(task clsTask, message clsMessage, project clsProject) {
        this.clsTask = clsTask;
        this.clsMessage = clsMessage;
        this.clsProject = clsProject;
    }

    public task getClsTask() {
        return clsTask;
    }

    public void setClsTask(task clsTask) {
        this.clsTask = clsTask;
    }

    public message getClsMessage() {
        return clsMessage;
    }

    public void setClsMessage(message clsMessage) {
        this.clsMessage = clsMessage;
    }

    public project getClsProject() {
        return clsProject;
    }

    public void setClsProject(project clsProject) {
        this.clsProject = clsProject;
    }
    
    public void displayNoti(){
        
    }
    
    public void sortNoti(){
        
    }
    
}
