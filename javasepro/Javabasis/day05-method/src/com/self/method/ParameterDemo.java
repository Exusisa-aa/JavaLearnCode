package com.self.method;

public class ParameterDemo {
    public static void main(String[] args) {
        //基本类型的值传递
        int a = 10;
        change(a);
        System.out.println(a);



        //引用类型的值传递
        int[] array={10,20,30};
        ss(array);
        System.out.println(array[1]);
    }
    public static void change(int a){
        System.out.println(a);
        a = 20;
        System.out.println(a);
    }
    public static void ss(int[] array){
        System.out.println(array[1]);
        array[1] = 222;
        System.out.println(array[1]);
    }
}

