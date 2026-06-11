package com.self.FileAndIo.File.API;

import java.io.File;

public class CreatFileAndDeleteFileDemo {
    public static void main(String[] args) throws Exception{
        File f1 = new File("day17-file io\\src\\com\\self\\FileAndIo\\File\\API\\new.java");
        File f2 = new File("day17-file io\\src\\com\\self\\FileAndIo\\File\\API\\aaa");
        File f3 = new File("day17-file io\\src\\com\\self\\FileAndIo\\File\\API\\aaa\\bbb\\ccc\\ddd");
        //1.创建一个新的文件
        System.out.println(f1.createNewFile());
        System.out.println("-----------------------------------");
        //2.创建一个文件夹，只能是一级文件夹
        System.out.println(f2.mkdir());
        System.out.println("-----------------------------------");
        //3.创建一个文件夹，可以是多级
        System.out.println(f3.mkdirs());
        System.out.println("-----------------------------------");
        //4.删除文件与空文件夹，不能删除非空文件夹
        File f4 = new File("day17-file io\\src\\com\\self\\FileAndIo\\File\\API\\aaa\\bbb\\ccc");
        File f5 = new File("day17-file io\\src\\com\\self\\FileAndIo\\File\\API\\aaa\\bbb");
        System.out.println(f1.delete());
        System.out.println(f3.delete());
        System.out.println(f4.delete());
        System.out.println(f5.delete());
        System.out.println(f2.delete());
        System.out.println("-----------------------------------");


    }
}
