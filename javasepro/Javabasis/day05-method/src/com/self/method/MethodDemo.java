package com.self.method;

public class MethodDemo {
    //方法的使用


    public static void main(String[] args) {
        //普通求和
        int d = 10;
        int e = 20;
        int f = d + e;
        System.out.println(f);


        //方法的调用求和
        int result = sum(10,20);
        System.out.println("和是：" + result);






        //方法调用求积
        int ss = rs(10,20,30);
        System.out.println("积是：" + ss);


        //方法商的调用
        int h =rsss(30,2);
        System.out.println(h);

    }



    public static int sum(int a,int b){
        int c = a + b;
        return c;
    }


    public static int rs(int a,int b,int c){
        int d = a * b * c;
        return d;
    }


    public static int rsss(int a,int b){
        int c = a / b;
        return c;
    }
}
