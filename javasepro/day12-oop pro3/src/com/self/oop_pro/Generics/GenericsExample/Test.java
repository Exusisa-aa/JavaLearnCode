package com.self.oop_pro.Generics.GenericsExample;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new BC());
        cars.add(new BM());
        go(cars);

        ArrayList<BC> cars1 = new ArrayList<>();
        cars1.add(new BC());
        cars1.add(new BC());
        go(cars1);

        ArrayList<BM> cars2 = new ArrayList<>();
        cars2.add(new BM());
        cars2.add(new BM());
        go(cars2);
    }

    public static <T> void go(ArrayList<T> cars){  //进来的可以是所有类，但无法限定

    }

    public static <T extends Car> void go1(ArrayList<T> cars){ //进来的只能是Car与其子类，arraylist本就有泛型，没必要再次定义

    }

    public static void go2(ArrayList<?> cars){  //与第一个类似  ？代表所有类且不用被定义  ？为通配符

    }

    public static void go3(ArrayList<? extends Car> cars){//上限  只能输入car及其子类

    }

    public static void go4(ArrayList<? super Car> cars){//下限  只能输入car及其父类

    }

    //只有通配符能使用上下限
}
