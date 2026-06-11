package com.self.more_API.Lambda.basis;


import java.util.Arrays;


public class LambdaDemo {
    public static void main(String[] args) {
        Swimming s = () -> {
            System.out.println("开游");
        };
        s.swim(); //Lambda只可用于函数式接口，也就是面对对象的接口有且只有一个抽象方法
        //(被重写方法的形参列表) -> {
        // 方法体
        // }

        Double[] array = {70.0,50.0,30.0,40.0,80.0};
        Arrays.setAll(array, (int value) -> {
            return array[value] * 0.8;
        });

        Arrays.sort(array, (Double o1, Double o2) -> {
            return Double.compare(o1,o2);
        });
    }
}
