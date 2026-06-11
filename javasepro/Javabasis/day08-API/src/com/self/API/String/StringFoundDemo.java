package com.self.API.String;

public class StringFoundDemo {
    public static void main(String[] args) {
//        1.直接创建
        String rs1 = "sb";
        System.out.println(rs1);

//        2.new String()
        String rs2 = new String();
        System.out.println(rs2);
        String rs3 = new String("sb");
        System.out.println(rs3);

//        3.根据字符数组来创建字符串对象
        char[] chars = {'大','s','b'};
        String rs4 = new String(chars);
        System.out.println(rs4);

//        4.根据字节数组来创建字符串对象
        byte[] bytes = {97,98,99};
        String rs5 = new String(bytes);
        System.out.println(rs5);
    }
}
