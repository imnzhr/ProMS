/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.employee;

import java.util.*;

/**
 *
 * @author apitz
 */
public class department {
    private int id;
    private String depName;
    private List<employee> empList;
    
    public department() {
    }
    
    public department(int id, String depName, List<employee> empList) {
        this.id = id;
        this.depName = depName;
        this.empList = empList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public List<employee> getEmpList() {
        return empList;
    }

    public void setEmpList(List<employee> empList) {
        this.empList = empList;
    }

    public void addEmpList(){
        
    }
    
    public void deleteEmpList(){
        
    }
}
