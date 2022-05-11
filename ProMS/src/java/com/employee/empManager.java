/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.employee;

/**
 *
 * @author apitz
 */
public class empManager {
    private department clsDep;
    private employee clsEmp;

    public empManager() {
    }

    public empManager(department clsDep, employee clsEmp) {
        this.clsDep = clsDep;
        this.clsEmp = clsEmp;
    }

    public department getClsDep() {
        return clsDep;
    }

    public void setClsDep(department clsDep) {
        this.clsDep = clsDep;
    }

    public employee getClsEmp() {
        return clsEmp;
    }

    public void setClsEmp(employee clsEmp) {
        this.clsEmp = clsEmp;
    }
    
    public void changeDep(){
        
    }
}
