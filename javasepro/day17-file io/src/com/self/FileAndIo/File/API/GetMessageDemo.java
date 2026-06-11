package com.self.FileAndIo.File.API;

import java.io.File;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;


public class GetMessageDemo {
    public static void main(String[] args) {
        File f1 = new File("D:\\Wuthering Waves\\Wuthering Waves Game\\Wuthering Waves.exe");
        File f2 = new File("day17-file io\\src\\com\\self\\FileAndIo\\File\\API\\GetMessageDemo.java");
        //1.判断文件对象对应的文件路径是否存在
        System.out.println(f1.exists());
        System.out.println("--------------------------------");
        //2.判断文件对象指代的是否是文件
        System.out.println(f1.isFile());
        System.out.println("--------------------------------");
        //3.判断文件对象指代的是否是文件夹
        System.out.println(f1.isDirectory());
        System.out.println("--------------------------------");
        //4.获取文件的名称
        System.out.println(f1.getName());
        System.out.println("--------------------------------");
        //5.获取文件的大小
        System.out.println(f1.length()/1024+ "KB");
        System.out.println("--------------------------------");
        //6.获取文件的最后修改时间
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(formatter.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(f1.lastModified()),ZoneId.systemDefault())));
        System.out.println("--------------------------------");
        //7.获取创建文件对象时所用的路径
        System.out.println(f1.getPath());//绝对
        System.out.println(f2.getPath());//相对
        System.out.println("--------------------------------");
        //8.获取文件对象的绝对路径
        System.out.println(f1.getAbsolutePath());//绝对
        System.out.println(f2.getAbsolutePath());//绝对


    }
}
