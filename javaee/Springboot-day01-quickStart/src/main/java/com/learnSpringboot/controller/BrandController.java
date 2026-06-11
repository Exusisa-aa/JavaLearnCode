package com.learnSpringboot.controller;

import com.learnSpringboot.pojo.JDBCBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/brands")
public class BrandController {

//    @Value("${server.port}")
//    private String port;

//    @Autowired
//    private Environment environment;

    @Autowired
    private JDBCBase jdbcBase;

    @GetMapping("/{id}")
    public String getById(@PathVariable Integer id){
        System.out.println("brand controller return " + id);
//        System.out.println("port:" + port);
//        System.out.println("port:" + environment.getProperty("server.port"));
//        System.out.println("jdbcBase:" + jdbcBase.getDriverClassName());
//        System.out.println("jdbcBase:" + jdbcBase.getUrl());
//        System.out.println("jdbcBase:" + jdbcBase.getUsername());
//        System.out.println("jdbcBase:" + jdbcBase.getPassword());
        return "controller return " + id;
    }
}
