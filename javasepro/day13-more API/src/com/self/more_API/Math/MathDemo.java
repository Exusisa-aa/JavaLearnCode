package com.self.more_API.Math;

public class MathDemo {
    public static void main(String[] args) {
//        1.取绝对值
        System.out.println(Math.abs(-50));//50
        System.out.println(Math.abs(-3.14));//3.14
        System.out.println(Math.abs(50));//50
        System.out.println("=====================");

//        2.向上取整
        System.out.println(Math.ceil(4.000001));//5
        System.out.println(Math.ceil(4));//4
        System.out.println("=====================");

//        3.向下取整
        System.out.println(Math.floor(4.999999));//4
        System.out.println(Math.floor(4));//4
        System.out.println("=====================");

//        4.四舍五入
        System.out.println(Math.round(4.4999999));//4
        System.out.println(Math.round(4.5000001));//5
        System.out.println("=====================");

//        5.取较大值或取较小值
        System.out.println(Math.max(40, 60));//60
        System.out.println(Math.min(40, 60));//40
        System.out.println("=====================");

//        6.取a的b次方的值
        System.out.println(Math.pow(2, 5));//32
        System.out.println(Math.pow(5, 2));//25
        System.out.println("=====================");

//        7.取[0.0,1.0)的随机小数
        System.out.println(Math.random());
    }
}
