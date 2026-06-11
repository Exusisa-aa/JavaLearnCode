package com.self.learnFile;

import com.self.learnFile.service.WorkServiceFramework;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        applicationContext.registerShutdownHook();
        WorkServiceFramework workService = (WorkServiceFramework) applicationContext.getBean("workService");
        workService.work();
    }
}