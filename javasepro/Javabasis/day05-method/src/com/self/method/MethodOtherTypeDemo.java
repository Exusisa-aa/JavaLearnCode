package com.self.method;

public class MethodOtherTypeDemo {
    public static void main(String[] args) {
        printDemo1();
        System.out.println("===========================================================");
        printDemo2(5);
    }
    //无形参无返回值的方法
    public  static void printDemo1(){
        for (int i = 0; i < 3; i++) {
            System.out.println("HelloWorld");
        }
    }

    //有形参无返回值的方法
    public static void printDemo2(int n){
        for (int i = 0; i < n; i++) {
            System.out.println("HelloWorld");
        }
    }
}
