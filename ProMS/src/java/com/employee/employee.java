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
public class employee {
    private int id;
    private String name;
    private String phoneNum;
    private String email;
    private int age;
    private String gender;
    private int depID;
    private String username;
    private String password;
    private String img;

    private String depname;
    
    public employee() {
    }

    public employee(int id, String name, String phoneNum, String email, int age, String gender, int depID) {
        this.id = id;
        this.name = name;
        this.phoneNum = phoneNum;
        this.email = email;
        this.age = age;
        this.gender = gender;
        this.depID = depID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getDepID() {
        return depID;
    }

    public void setDepID(int depID) {
        this.depID = depID;
    }

    public String getDepname() {
        return depname;
    }

    public void setDepname(String depname) {
        this.depname = depname;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "employee{" + "id=" + id + ", name=" + name + ", phoneNum=" + phoneNum + ", email=" + email + ", age=" + age + ", gender=" + gender + ", depID=" + depID + ", username=" + username + ", password=" + password + ", img=" + img + ", depname=" + depname + '}';
    }
       
}
