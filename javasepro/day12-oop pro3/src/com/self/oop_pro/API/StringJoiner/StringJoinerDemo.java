package com.self.oop_pro.API.StringJoiner;

import java.util.StringJoiner;

public class StringJoinerDemo {
    public static void main(String[] args) {
        StringJoiner a = new StringJoiner(",");
        a.add("123").add("abc").add("true");
        System.out.println(a);


        StringJoiner b = new StringJoiner(",","[","]");
        b.add("11").add("22").add("33");
        System.out.println(b);

        System.out.println(getArrayDate(new int[]{44, 55, 66, 77, 88, 99, 11}));
    }

    public static String getArrayDate(int[] array){
        if(array == null){
            return null;
        }
        StringJoiner a = new StringJoiner(",","[","]");
        for (int i = 0; i < array.length; i++) {
            a.add(Integer.toString(array[i]));
        }
        return a.toString();
    }
}
