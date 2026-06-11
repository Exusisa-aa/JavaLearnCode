package com.self.oop_pro.StaticMethodExample;

import java.util.Random;

public class MyUtil {
    private MyUtil(){

    }//封装构造器，以防被用来创建对象

    public static String code(int n) {
        Random r = new Random();
        String codes = "";
        String a = "123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        for (int i = 1; i <= n; i++) {
            codes += a.charAt(r.nextInt(a.length()));
        }
        return codes;
    }
}
