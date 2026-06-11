package com.self.SpecialFileAndLog.SpecialFile.Properties;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class PropertiesDemo {
    public static void main(String[] args) {
        //创建对象并存入数据到Properties对象
        Properties prop = new Properties();
        prop.setProperty("ex1","123456");
        prop.setProperty("ex2","1dwadwdwa");
        prop.setProperty("ex3","5wa1f5");


        //创建io流通入properties对象
        try {
            prop.store(new FileWriter("day18-special file and log\\src\\com\\self\\SpecialFileAndLog\\SpecialFile\\Properties\\save.properties"),"saved");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //读取Properties文件
        try {
            prop.load(new FileReader("day18-special file and log\\src\\com\\self\\SpecialFileAndLog\\SpecialFile\\Properties\\save.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(prop.getProperty("ex1"));
        Set<String> set = prop.stringPropertyNames();
        for (String key : set) {
            System.out.println(key + "=" + prop.getProperty(key));
        }

        prop.forEach((k,v) -> System.out.println(k + "--->" + v));
    }
}
