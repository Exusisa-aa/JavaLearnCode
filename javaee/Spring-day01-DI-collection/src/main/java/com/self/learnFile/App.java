package com.self.learnFile;

import com.self.learnFile.pojo.Collection;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        Collection collectionImp = (Collection)applicationContext.getBean("collectionImp");
        System.out.println(collectionImp);
    }
}