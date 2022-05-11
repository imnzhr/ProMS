/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.report;

import com.employee.employee;
import com.project.project;
import com.task.task;

/**
 *
 * @author apitz
 */
public class reportManager {
    private employee clsEmp;
    private project clsProject;
    private task clsTask;

    public reportManager() {
    }

    public reportManager(employee clsEmp, project clsProject, task clsTask) {
        this.clsEmp = clsEmp;
        this.clsProject = clsProject;
        this.clsTask = clsTask;
    }

    public employee getClsEmp() {
        return clsEmp;
    }

    public void setClsEmp(employee clsEmp) {
        this.clsEmp = clsEmp;
    }

    public project getClsProject() {
        return clsProject;
    }

    public void setClsProject(project clsProject) {
        this.clsProject = clsProject;
    }

    public task getClsTask() {
        return clsTask;
    }

    public void setClsTask(task clsTask) {
        this.clsTask = clsTask;
    }
    
    public void genReport(){
        
    }
    
    public void displayReport(){
        
    }
}
