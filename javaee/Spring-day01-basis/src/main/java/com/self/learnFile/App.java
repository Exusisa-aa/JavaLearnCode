package com.self.learnFile;

import com.self.learnFile.service.WorkServiceFramework;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        WorkServiceFramework workService = (WorkServiceFramework) applicationContext.getBean("workService2");
        WorkServiceFramework workService2 = (WorkServiceFramework) applicationContext.getBean("workService2");
        System.out.println(workService);
        System.out.println(workService2);
        workService.work();
    }
}