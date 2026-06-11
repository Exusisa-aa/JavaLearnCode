package com.self.API.String;

public class StringMethodDemo {
    public static void main(String[] args) {
//        1.获取字母串的长度
        String rs1 = "wdfwcis";
        System.out.println(rs1.length());
        System.out.println("---------------------------");

//        2.获取某位置的字母，返回char
        System.out.println(rs1.charAt(3));
        System.out.println("---------------------------");

//        3.转化为字符数组，返回char[]
        char[] chars = rs1.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }
        System.out.println("---------------------------");

//        4.判断内容是否相等（分大小写），返回布尔值
        String s1 = new String("和我一样");
        String s2 = new String("和我一样");
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
        System.out.println("---------------------------");

//        5.判断内容师是否相等（不分大小写）,返回布尔值
        String c1 = new String("AL6OF");
        String c2 = new String("al6of");
        System.out.println(c1.equalsIgnoreCase(c2));
        System.out.println("---------------------------");

//        6.截取字符串，返回字符串,包前不包后
        System.out.println(rs1.substring(0, 3));
        System.out.println("---------------------------");

//        7.截取字符串，返回字符串，包前至末尾
        System.out.println(rs1.substring(3));
        System.out.println("---------------------------");

//        8.替换字符串，返回字符串
        String rs2 = "这什么垃圾玩意,滚！！！";
        System.out.println(rs2);
        rs2 = rs2.replace("垃圾玩意" , "****");
        System.out.println(rs2.replace("滚", "*"));
        System.out.println("---------------------------");

//        9.判断是否包含字符串,返回布尔值
        System.out.println(rs1.contains("fwc"));
        System.out.println("---------------------------");

//        10.判断是否以某字符串开头，返回布尔值
        System.out.println(rs1.startsWith("wdf"));
        System.out.println(rs1.startsWith("ww"));
        System.out.println("---------------------------");

//        11.以某个字符串为界线,拆分字符串并返回给字符串数组
        String rs3 = "6 4 5 2 3 8 7 0";
        String[] rs4 = rs3.split(" ");
        for (int i = 0; i < rs4.length; i++) {
            System.out.println(rs4[i]);
        }
    }
}
