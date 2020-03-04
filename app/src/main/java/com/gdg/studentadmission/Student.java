package com.gdg.studentadmission;

import java.io.Serializable;

public class Student implements Serializable {

    String name, email, dob, gender, branch, number;
    float perc12, perc10;


    public Student(String name, String email, String dob, String gender, String branch, String number, float perc12, float perc10) {
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.gender = gender;
        this.branch = branch;
        this.number = number;
        this.perc12 = perc12;
        this.perc10 = perc10;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public float getPerc12() {
        return perc12;
    }

    public void setPerc12(float perc12) {
        this.perc12 = perc12;
    }

    public float getPerc10() {
        return perc10;
    }

    public void setPerc10(float perc10) {
        this.perc10 = perc10;
    }
}
