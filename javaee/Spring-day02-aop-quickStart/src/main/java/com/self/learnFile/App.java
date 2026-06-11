package com.self.learnFile;

import com.self.learnFile.config.SpringConfig;
import com.self.learnFile.service.WorkServiceFramework;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        applicationContext.registerShutdownHook();
        WorkServiceFramework workService = (WorkServiceFramework) applicationContext.getBean("workServiceImpl");
//        workService.save();
//        workService.delete();
//        workService.update();
//        workService.select();
        workService.selectCount();
        workService.selectByIdAndName(1, "张三");
    }
}