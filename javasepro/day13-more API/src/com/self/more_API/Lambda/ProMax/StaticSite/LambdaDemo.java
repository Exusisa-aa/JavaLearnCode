package com.self.more_API.Lambda.ProMax.StaticSite;


import java.util.Arrays;


public class LambdaDemo {
    public static void main(String[] args) {

        Double[] array = {70.0,50.0,30.0,40.0,80.0};
        Arrays.setAll(array, value -> array[value] * 0.8);

//        Arrays.sort(array,(a,b) -> Method.CompareUp(b,a));
        Arrays.sort(array, Method::CompareUp);
        System.out.println(Arrays.toString(array));
        Arrays.sort(array, Method::CompareDown);
        System.out.println(Arrays.toString(array));

        //在匿名内部类，用lambda简化的基础上调用静态方法继续简化，用静态类名::静态方法名即可

    }

}
