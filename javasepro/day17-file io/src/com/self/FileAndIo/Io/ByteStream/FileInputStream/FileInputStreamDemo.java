package com.self.FileAndIo.Io.ByteStream.FileInputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;


public class FileInputStreamDemo {
    public static void main(String[] args) throws Exception {
//        File f = new File("day17-file io\\src\\com\\self\\FileAndIo\\Io\\ByteStream\\FileInputStream\\111.txt");
//        FileInputStream is = new FileInputStream(f);
        InputStream is1 = new FileInputStream("day17-file io\\src\\com\\self\\FileAndIo\\Io\\ByteStream\\FileInputStream\\111.txt");
        int b;
        while ((b = is1.read()) != -1) {
            System.out.print((char)b);
        }

        //这种读取方式性能极差  且无法读取汉字  不推荐使用
        is1.close();
        //读取完后关闭释放系统资源
        System.out.println("==============");



        InputStream is2 = new FileInputStream("day17-file io\\src\\com\\self\\FileAndIo\\Io\\ByteStream\\FileInputStream\\111.txt");
        int len;
        byte[] buffer = new byte[3];//可更改
        while ((len = is2.read(buffer)) != -1) {
            String rs = new String(buffer,0,len);
            System.out.print(rs);
        }
        is2.close();
        //性能优化了  但是还是不能完全显示出中文  在UTF-8中  中文由三个字节构成  解码过程中有可能导致代表中文的字节被截断
        System.out.println("--------------");


        File file = new File("day17-file io\\src\\com\\self\\FileAndIo\\Io\\ByteStream\\FileInputStream\\111.txt");
        InputStream is3 = new FileInputStream(file);
        long size = file.length();
        byte[] buffer2 = new byte[(int)size];
        System.out.println(new String(buffer2, 0, is3.read(buffer2)));
        is3.close();
        System.out.println("--------------");

        File file2 = new File("day17-file io\\src\\com\\self\\FileAndIo\\Io\\ByteStream\\FileInputStream\\111.txt");
        InputStream is4 = new FileInputStream(file2);
        byte[] bytes = is4.readAllBytes();
        System.out.println(new String(bytes));
        is4.close();

    }
}
