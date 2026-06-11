package com.self.more_API.Lambda.ProMax.RealSite;


import java.util.Arrays;


public class LambdaDemo {
    public static void main(String[] args) {

        Double[] array = {70.0,50.0,30.0,40.0,80.0};
        Arrays.setAll(array, value -> array[value] * 0.8);

        Method m = new Method();
//        Arrays.sort(array,(a,b) -> m.CompareDown(a,b));
        Arrays.sort(array, m::CompareUp);
        System.out.println(Arrays.toString(array));
        Arrays.sort(array, m::CompareDown);
        System.out.println(Arrays.toString(array));

        //在匿名内部类，用lambda简化的基础上调用实例方法继续简化，用实例类的对象::实例方法名即可

    }

}
