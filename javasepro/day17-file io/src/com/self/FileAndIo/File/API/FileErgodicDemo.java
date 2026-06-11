package com.self.FileAndIo.File.API;

import java.io.File;

public class FileErgodicDemo {
    public static void main(String[] args) {
        File f1 = new File("D:");
        //list遍历
        String[] names = f1.list();
        for (String name : names) {
            System.out.println(name);
        }
        System.out.println("---------------------------");
        //listFiles遍历
        File[] files = f1.listFiles();
        for (File file : files) {
            System.out.println(file.getAbsolutePath());
        }


        //1.调的是文件或路径不存在时返回null
        //2.当调的是空文件夹时，返回一个长度为0的数组
        //3.存储的是路径
        //4.隐藏文件也会被选中
        //5.当没有权限访问文件时，则返回null


    }
}
