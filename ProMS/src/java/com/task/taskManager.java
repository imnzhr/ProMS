/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.task;

import com.employee.employee;
import com.project.project;

/**
 *
 * @author apitz
 */
public class taskManager {
    private task clsTask;
    private project clsProject;
    private employee clsEmp;

    public taskManager() {
    }

    public taskManager(task clsTask, project clsProject, employee clsEmp) {
        this.clsTask = clsTask;
        this.clsProject = clsProject;
        this.clsEmp = clsEmp;
    }

    public task getClsTask() {
        return clsTask;
    }

    public void setClsTask(task clsTask) {
        this.clsTask = clsTask;
    }

    public project getClsProject() {
        return clsProject;
    }

    public void setClsProject(project clsProject) {
        this.clsProject = clsProject;
    }

    public employee getClsEmp() {
        return clsEmp;
    }

    public void setClsEmp(employee clsEmp) {
        this.clsEmp = clsEmp;
    }
    
    public void assignTask(){
        
    }
    
    public void sortUrgentTask(){
        
    }
    
    public void sortCompletedTask(){
        
    }
    
}
