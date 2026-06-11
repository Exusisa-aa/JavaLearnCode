package com.learnSpringMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("bookController")
@RequestMapping("/book")
public class BookController {
    @RequestMapping("/save")
    @ResponseBody
    public String save(String name,int age){
        System.out.println("save book...");
        System.out.println("name:"+name);
        System.out.println("age:"+age);
        return "{" +
                "'message':'book save send'" +
                "}";
    }
}
