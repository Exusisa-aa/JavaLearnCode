package com.self.processcontroller;
import java.util.Scanner;
public class PracticeDemo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您的绩效分：");
        int score = sc.nextInt();
        if (score >= 0 && score <60){
            System.out.println("您的绩效分为D");
        }else if (score >= 60 && score <70){
            System.out.println("您的绩效分为C");
        }else if (score >= 70 && score <80) {
            System.out.println("您的绩效分为B");
        }else if (score >= 80 && score <90) {
            System.out.println("您的绩效分为A");
        }else if (score >= 90 && score <100) {
            System.out.println("您的绩效分为S");
        }else {
            System.out.println("您输入的信息有误");
        }
        System.out.println("祝您考核愉快");
        System.out.println("-------------------------------");
        String week = sc.next();
        System.out.println("请输入您的星期信息：");
        switch (week) {
            case "周一":
                System.out.println("111");
                break;
            case "周二":
                System.out.println("222");
                break;
            case "周三":
                System.out.println("333");
                break;
            case "周四":
                System.out.println("444");
                break;
            case "周五":
                System.out.println("555");
                break;
            case "周六":
                System.out.println("666");
                break;
            case "周日":
            case "周天":
                System.out.println("777");
                break;
            default:
                System.out.println("您输入的信息有误");
        }
        System.out.println("祝您一周愉快");
        System.out.println("=====================================================================");
        for (int i= 1 ; i <= 5 ; i +=1 ){
            System.out.println("5次");
        }
        double peak = 8848880.0;
        double paper = 0.1;
        int time = 0;
        while (paper <= peak) {
            time +=1;
            paper *=2;
        }
        System.out.println("需要折叠的次数：" + time);
        System.out.println("折叠后的高度：" + paper);
        int i = 0;
        do {
            System.out.println("5次");
            i += 1;
        }while (i <= 5);
        System.out.println("==========================================");
        int sum = 0;
        for (int a = 1; a <= 100; a++){
            sum +=a;
        }
        int sum1 = 0;
        for (int b = 1;b <= 100;b +=2){
            sum1 +=b;
        }
        int sum2 = 0;
        for (int c = 1;c <= 100;c +=2){
            if (c % 2 == 1){
                sum2 += c;
            }
        }
        System.out.println(sum2);
        System.out.println(sum1);
        System.out.println(sum);
        System.out.println("=======================================================================");
//        for ( ; ; ){
//            System.out.println("循环后不接循环，所以改成备注了");
//        }
//        while (true){
//            System.out.println("循环后不接循环，所以改成备注了");
//        }
//        do{
//            System.out.println("循环后不接循环");
//        }while (true);
        System.out.println("..........................................");

    }
}
