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
public class projectManager {
    private project clsProject;
    private supplier clsSup; 
    private client clsClient;

    public projectManager() {
    }

    public projectManager(project clsProject, supplier clsSup, client clsClient) {
        this.clsProject = clsProject;
        this.clsSup = clsSup;
        this.clsClient = clsClient;
    }

    public project getClsProject() {
        return clsProject;
    }

    public void setClsProject(project clsProject) {
        this.clsProject = clsProject;
    }

    public supplier getClsSup() {
        return clsSup;
    }

    public void setClsSup(supplier clsSup) {
        this.clsSup = clsSup;
    }

    public client getClsClient() {
        return clsClient;
    }

    public void setClsClient(client clsClient) {
        this.clsClient = clsClient;
    }
    
    public void changeSup(){
        
    }
    
    public void updateProg(){
        
    }
}
