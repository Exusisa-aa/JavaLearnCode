package com.learnSpringMVC.controller;

import com.learnSpringMVC.pojo.Address;
import com.learnSpringMVC.pojo.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller("userController")
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/save")
    @ResponseBody
    public String save(String name,int age){
        System.out.println("save use    r...");
        System.out.println("name:"+name);
        System.out.println("age:"+age);
        return "{" +
                "'message':'user save send'" +
                "}";
    }

    @RequestMapping("/differentName")
    @ResponseBody
    public String differentName(@RequestParam(value = "name",required = false,defaultValue = "defaultName") String userName, int age){
        System.out.println("differentName...");
        System.out.println("userName:"+userName);
        System.out.println("age:"+age);
        return "{" +
                "'message':'differentName'" +
                "}";
    }

    @RequestMapping("/pojoTest")
    @ResponseBody
    public String pojoTest(User user){
        System.out.println("pojoTest...");
        System.out.println("user:"+user);
        return "{" +
                "'message':'pojoTest'" +
                "}";
    }

    @RequestMapping("/arrayTest")
    @ResponseBody
    public String arrayTest(String[] likes){
        System.out.println("arrayTest...");
        System.out.println("likes:"+ Arrays.toString(likes));
        return "{" +
                "'message':'arrayTest'" +
                "}";
    }

    @RequestMapping("/listTest")
    @ResponseBody
    public String listTest(@RequestParam List<String> likes){
        System.out.println("listTest...");
        System.out.println("likes:"+ likes);
        return "{" +
                "'message':'listTest'" +
                "}";
    }

    @RequestMapping("/jsonArrayTest")
    @ResponseBody
    public String jsonArrayTest(@RequestBody String[] likes){
        System.out.println("jsonArrayTest...");
        System.out.println("likes:"+ Arrays.toString(likes));
        return "{" +
                "'message':'jsonArrayTest'" +
                "}";
    }

    @RequestMapping("/jsonPojoTest")
    @ResponseBody
    public String jsonPojoTest(@RequestBody User user){
        System.out.println("jsonPojoTest...");
        System.out.println("user:"+user);
        return "{" +
                "'message':'jsonPojoTest'" +
                "}";
    }

    @RequestMapping("/jsonListTest")
    @ResponseBody
    public String jsonListTest(@RequestBody List<User> users){
        System.out.println("jsonListTest...");
        System.out.println("likes:"+ users);
        return "{" +
                "'message':'jsonListTest'" +
                "}";
    }

    @RequestMapping("/timeTest")
    @ResponseBody
    public String timeTest(@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate time1,
                           @DateTimeFormat(pattern = "yyyy/MM/dd") LocalDate time2,
                           @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime time3){
        System.out.println("timeTest...");
        System.out.println("time1:"+time1);
        System.out.println("time2:"+time2);
        System.out.println("time3:"+time3);
        return "{" +
                "'message':'timeTest'" +
                "}";
    }

    @RequestMapping("/returnJsonTest")
    @ResponseBody
    public List<User> returnJsonTest(){
        User user1 = new User();
        user1.setName("user1");
        user1.setAge(18);
        Address address = new Address();
        address.setCity("city1");
        address.setProvince("province1");
        user1.setAddress(address);
        User user2 = new User();
        user2.setName("user2");
        user2.setAge(19);
        Address address2 = new Address();
        address2.setCity("city2");
        address2.setProvince("province2");
        user2.setAddress(address2);
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        return users;
    }







}
