package com.self.learnFile;

import com.self.learnFile.service.WorkServiceFramework;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class App {
    public static void main(String[] args) {
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("K:\\study\\java+JDBC\\java code\\javaee\\Spring-day01-container\\src\\main\\resources\\applicationContext.xml");

        WorkServiceFramework workService = (WorkServiceFramework) applicationContext.getBean("workService");
        WorkServiceFramework workService2 = applicationContext.getBean("workService",WorkServiceFramework.class);
        System.out.println(workService);
        System.out.println(workService2);
        workService.work();
    }
}