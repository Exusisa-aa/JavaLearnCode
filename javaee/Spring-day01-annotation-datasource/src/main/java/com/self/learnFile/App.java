package com.self.learnFile;

import com.alibaba.druid.pool.DruidDataSource;
import com.self.learnFile.config.SpringConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        DruidDataSource dataSource = (DruidDataSource) applicationContext.getBean("druid");
        System.out.println(dataSource);
    }
}
