package com.example.helloworld.mapper;/*
 * Created by ZHANG on 2018/7/27
 */

import com.example.helloworld.Person.Person;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface PersonMapper {
    public List<Person> seleteAll();
    public Person seleteperson(Integer id);
    public List<Person> seletepername(Integer name);
    public void saveUser(Person person);
    public void modify(Person person);
    public void modifyall(Person person);
    public void dele(Integer id);
}
