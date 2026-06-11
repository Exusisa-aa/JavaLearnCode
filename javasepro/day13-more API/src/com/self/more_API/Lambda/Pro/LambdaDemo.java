package com.self.more_API.Lambda.Pro;


import java.util.Arrays;


public class LambdaDemo {
    public static void main(String[] args) {
        Swimming s = () -> System.out.println("开游");
        s.swim(); //Lambda只可用于函数式接口，也就是面对对象的接口有且只有一个抽象方法
        //(被重写方法的形参列表) -> {
        // 方法体
        // }

        Double[] array = {70.0,50.0,30.0,40.0,80.0};
        Arrays.setAll(array, value -> array[value] * 0.8);

        Arrays.sort(array, (o1,o2) -> Double.compare(o2,o1));
        System.out.println(Arrays.toString(array));

        //1.形参列表中的参数类型可以省略不写
        //2.如果只有一个参数，形参列表的（）也可以省略
        //3.如果方法体只有一行代码，可以省略大括号和方法体的分号，如果此时用的是return语句，return也要省略
    }

}
