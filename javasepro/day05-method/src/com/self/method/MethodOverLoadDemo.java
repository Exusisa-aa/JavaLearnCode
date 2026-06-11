package com.self.method;

public class MethodOverLoadDemo {
    public static void main(String[] args) {
        double a =method(5.2,2);
        System.out.println(a);

        fire("老米",5);
        fire("xiao ri zi");
        fire();

    }

    public static int method(){
        return 5;
    }

    public static int method(int a){
        return 5;
    }

    public static double method(int a, double b){
        return (double)(a+b);
    }

    public static double method(double a,int b){
        return (double)(a+b);
    }


    public static void fire(){
        System.out.println("发射导弹");
    }

    public static void fire(String country){
        System.out.println("向着"+ country +"发射导弹");
    }

    public static void fire(String country,int number){
        System.out.println("向着"+ country + "发射" + number +"枚导弹");
    }
}
