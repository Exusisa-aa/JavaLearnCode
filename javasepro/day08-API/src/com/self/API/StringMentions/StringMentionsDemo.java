package com.self.API.StringMentions;

public class StringMentionsDemo {
    public static void main(String[] args) {
//        1.String对象不可改变内容，成为不可变字符串对象
        String name = "陈";//在堆内存的字符串常量池中新存储
        name += "明";//在堆内存的字符串常量池中新存储
        name += "辉";//在堆内存的字符串常量池中新存储
        System.out.println(name);//通过堆内存的字符串常量池中存储相加得到一个新地址存储在堆内存中。

//        2.字符串常量池中相同的String只有一个
        String s1 = "和我一样";
        String s2 = "和我一样";
        System.out.println(s1 == s2);//指向同一个地址

//        3.new出来的字符串对象会在堆内存中开辟一个新空间,并在字符串常量池中开辟一个新空间，但还是指向堆内存中的地址
        String c1 = new String("和我一样");
        String c2 = new String("和我一样");
        System.out.println(c1 == c2);//指向不同地址
        System.out.println(c1.equalsIgnoreCase(c2));
    }
}
