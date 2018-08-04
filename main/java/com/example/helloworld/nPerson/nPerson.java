package com.example.helloworld.nPerson;/*
 * Created by ZHANG on 2018/7/30
 */


public class nPerson {

    private String name;
    private String university;

    public nPerson(){}
    public nPerson(String name,String university){
        this.name = name;
        this.university = university;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }
}


