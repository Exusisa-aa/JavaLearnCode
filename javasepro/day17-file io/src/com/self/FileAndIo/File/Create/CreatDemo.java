package com.self.FileAndIo.File.Create;

import java.io.File;


public class CreatDemo {
    public static void main(String[] args) {
        //绝对路径：
        File f1 = new File("D:\\Wuthering Waves\\Wuthering Waves Game\\Wuthering Waves.exe");
        File f2 = new File("D:/Wuthering Waves/Wuthering Waves Game/Wuthering Waves.exe");
        File f3 = new File("D:"+File.separator+"Wuthering Waves"+File.separator+"Wuthering Waves Game"+File.separator+"Wuthering Waves.exe");
        System.out.println(f1.length());
        System.out.println(f2.length());
        System.out.println(f3.length());

        //相对路径：
        File f4 = new File("day17-file io\\src\\com\\self\\FileAndIo\\File\\Create\\CreatDemo.java");
        File f5 = new File("day17-file io\\src\\com\\self\\FileAndIo\\File\\Create\\Demo");//文件路径可不存在
        System.out.println(f4.length());




    }
}
