package com.example.helloworld.other;/*
 * Created by ZHANG on 2018/7/21
 */

import com.example.helloworld.Person.Person;
import com.example.helloworld.service.PersonService;
import com.example.helloworld.service.PersonServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PersonController {

    private ModelAndView mv;
    @Autowired
    private PersonService personService;

    //主页
    @RequestMapping("/findAll")
    public String ALL(Map<String,Object> res) {
        List<Person> list = personService.selete();
        List<Map<String,Integer>> listres = new ArrayList<>();

        for(Person p:list){
            Map<String,Integer> map = new HashMap<String,Integer>();
            map.put("id",p.getId());
            map.put("name",p.getName());
            listres.add(map);
        }
        res.put("listres",listres);

        return "a";
    }

   //@ResponseBody
   @GetMapping(value = "/findid")
   public String find(@RequestParam("id") Integer id,Map<String,Object> res) {
      Person person = personService.ServicefindById(id);
      List<Map<String,Integer>> listres = new ArrayList<>();
        if(null == person) {
            res.put("error","提交方式错误");
            return "a";
        }
          Map<String,Integer> map = new HashMap<String,Integer>();
          map.put("id", person.getId());
          map.put("name", person.getName());
          listres.add(map);
          res.put("listres",listres);
          return "a";

   }/*if(null!=person){
          Map<String, Object> friend = new HashMap<String, Object>();
          friend.put("id", person.getId());
          friend.put("name",person.getName());
          return "id是"+person.getId()+"的name是..."+person.getName();
      }*/

    @RequestMapping(value = "/findname")
    public String findname(@RequestParam("name") Integer name,Map<String,Object> res) {
        if(name == null)
            res.put("error","提交方式错误");
        List<Person> list =  personService.ServicefindByName(name);
        res.put("findn",name);
        List<Map<String,Integer>> listres = new ArrayList<>();

        for(Person p:list){
            Map<String,Integer> map = new HashMap<String,Integer>();
            map.put("id",p.getId());
            map.put("name",p.getName());
            listres.add(map);
        }
        res.put("listres",listres);

        return "a";
    }
    @ResponseBody
    @RequestMapping(value = "/del")
    public String del(@RequestParam("delname") Integer id) {
        if(id == null)
            return "请输入数据";
        if(personService.ServicefindById(id) == null)
            return "id not found";
        personService.deletePerson(id);
        return "success delete";
    }

    @ResponseBody
    @RequestMapping(value = "/saveone")
    public String saveone(@RequestParam("id")Integer id,
                          @RequestParam("name")Integer name,
                          Map<String,Object> res) {
       if(id == null || name == null) {
           //res.put("error","提交方式错误");
           return "提交方式错误";
       }
        if(personService.ServicefindById(id) != null)
            return "id cannot build";
        Person person = new Person(id,name);
        personService.save(person);
        return "success";
    }

    @ResponseBody
    @RequestMapping(value = "/updateone")
    public String update(@RequestParam("id")Integer id,
                       @RequestParam("name")Integer name){
        if(id == null || name == null)
            return "请输入数据";
        if(personService.ServicefindById(id) == null)
            return "id not found";
        Person person = new Person(id,name);
        personService.update(person);
        return "success update";
    }
    //原主页
    @RequestMapping("/aaa")
    public ModelAndView insert(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("a");
        return mv;
   }
    //修改页面
    @RequestMapping("/updpage")
    public ModelAndView updpage(@RequestParam("updid") Integer id,Map<String,Object> res){
        ModelAndView mv = new ModelAndView();
        res.put("id",id);
        mv.setViewName("upd");
        return mv;
    }

   //@ResponseBody
    @RequestMapping("/tabledel")
    public String deletemany(@RequestParam("delid") Integer id){
        personService.deletePerson(id);
        //return "delete this id success";
        return "a";
    }

    @ResponseBody
    @RequestMapping(value = "/updateall")
    public String updateall(@RequestParam("id")Integer id,
                            @RequestParam("oldid")Integer oldid,
                         @RequestParam("name")Integer name){
        if(id == null || name == null)
            return "请输入数据";
        List<Person> list = personService.selete();
        List<Integer> idlist = new ArrayList<>();
        for(Person p:list)
            if(p.getId() != oldid)
                idlist.add(p.getId());
        Person person = new Person(id,name);
        if(idlist.contains(id))
            return "这个id已经使用了";
        Person person1 = new Person(oldid,id,name);
        personService.updateall(person1);
        return "success update";
    }


}
