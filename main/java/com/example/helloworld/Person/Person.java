package com.example.helloworld.Person;/*
 * Created by ZHANG on 2018/7/21
 */


public class Person {
    private int id;
    private int oid;
    private int name;

    public Person(){

    }
    public Person(int id,int name){
        this.id = id;
        this.name = name;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public Person(int oid, int id, int name){
        this.oid = oid;

        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }
}
