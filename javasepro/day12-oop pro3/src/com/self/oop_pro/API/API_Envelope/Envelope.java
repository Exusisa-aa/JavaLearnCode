package com.self.oop_pro.API.API_Envelope;

import java.util.ArrayList;

public class Envelope {
    public static void main(String[] args) {
        //包装的基本使用
        Integer a1 = Integer.valueOf(12);
        //自动包装
        Integer a2 = 12;
        //自动拆箱
        int a3 = a2;


        ArrayList<Integer> list = new ArrayList<>();
        //自动包装
        list.add(12);
        list.add(13);
        //自动拆箱
        int a4 = list.get(1);
        //toString转字符串
        System.out.println((a2.toString() + 1));//121
        System.out.println((Integer.toString(a2) + 1));//121
        System.out.println(a2 + "" + 1);//121
        //字符串转基本数据类型
        String a = "29";
        String b = "99.5";
        System.out.println((Integer.parseInt(a) + 1));
        System.out.println((Integer.valueOf(a) + 1));
        System.out.println((Double.parseDouble(b) + 0.5));
        System.out.println((Double.valueOf(b) + 0.5));
    }
}
