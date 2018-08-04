package com.example.helloworld.service;/*
 * Created by ZHANG on 2018/7/26
 */

import com.example.helloworld.Person.Person;
import com.example.helloworld.mapper.PersonMapper;
import com.sun.xml.internal.xsom.impl.scd.Iterators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonMapper personMapper;

    public List<Person> selete(){
        List<Person> list = new ArrayList<>();
        list = personMapper.seleteAll();
        return list;
    }

    //通过ID查找
    public Person ServicefindById(@RequestParam("id") Integer id) {
        Person person = personMapper.seleteperson(id);
        if (null != person) {
            return person;
        }
        return null;
    }

    //通过name查找
    public List<Person> ServicefindByName(@RequestParam("name") Integer name) {
        List<Person> list = new ArrayList<>();
        list = personMapper.seletepername(name);
        return list;
    }
    //通过ID删除
    public void deletePerson(@RequestParam("id") Integer id){
        personMapper.dele(id);
    }

    //通过ID修改name
    public void update(@RequestParam("Person") Person person){
         personMapper.modify(person);
    }
    //修改id+name
    public void updateall(@RequestParam("Person") Person person){
        personMapper.modifyall(person);
    }
    //通过ID增加
    public int save(Person person){
        personMapper.saveUser(person);
        if(personMapper.seleteperson(person.getId())!= null)
            return 1;
        return 0;
    }
}
