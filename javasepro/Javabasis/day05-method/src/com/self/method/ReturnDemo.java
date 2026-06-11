package com.self.method;

public class ReturnDemo {
    public static void main(String[] args) {

        device(100,0);
    }


    public static void device(double a,double b){
        if(b == 0){
            System.out.println("您不能在分母输入0，请重新输入");
            return;
        }

        double c = a/b;
        System.out.println("结果为" + c);
    }
}
