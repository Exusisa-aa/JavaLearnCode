package com.self.oop_pro.API.API_StringBuilder_StringBuffer;

public class StringBufferDemo {
    public static void main(String[] args) {
        StringBuffer a = new StringBuffer("123");
//        相比于StringBuilder，StringBuffer更具有安全性，bug也更少

//        1.拼接
        a.append("abc").append("小明").append(true);
        System.out.println(a);


//        2.翻转
        System.out.println(a.reverse());


//        3.内容长度
        System.out.println(a.length());


//        4.转String
        String abc = a.toString();
        System.out.println(abc);
    }
}
