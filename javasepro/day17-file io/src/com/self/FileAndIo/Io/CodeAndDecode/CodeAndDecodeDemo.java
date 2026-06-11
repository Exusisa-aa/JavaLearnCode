package com.self.FileAndIo.Io.CodeAndDecode;

import java.util.Arrays;

public class CodeAndDecodeDemo {
    public static void main(String[] args) throws Exception{
        String s1 = "今年的top1是donk";

        //使用平台当前的编码方式编码，UTF-8之中中文占三个字节，都是1开头，故一个中文对应三个负数
        byte[] bytes = s1.getBytes();
        //使用指定的编码方式编码，GBK之中汉字占两个字节，前一个字节是1开头
        byte[] bytes1 = s1.getBytes("GBk");
        System.out.println(Arrays.toString(bytes));
        System.out.println(Arrays.toString(bytes1));


        //使用平台当前的编码方式解码
        String s2 = new String(bytes);
        System.out.println(s2);
        //使用指定的编码方式解码
        String s3 = new String(bytes1,"GBK");
        System.out.println(s3);

        //若使用两种不同的方式编码和解码，会出现乱码符号�，一般数字与英文不会乱码，大部分字符集兼容ASC LL码
        String s4 = new String(bytes1, "UTF-8");
        System.out.println(s4);
    }
}
