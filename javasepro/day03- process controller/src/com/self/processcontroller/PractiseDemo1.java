package com.self.processcontroller;
import java.util.Scanner;

public class PractiseDemo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您的绩效分：");
        double score = sc.nextDouble();
        if (score >= 0 && score < 60){
            System.out.println("您的成绩为D");
        }else if (score >= 60 && score < 80){
            System.out.println("您的成绩为C");
        }else if (score >= 80 && score < 90){
            System.out.println("您的成绩为B");
        }else if (score >= 90 && score < 100){
            System.out.println("您的成绩为A");
        }else{
            System.out.println("您输入的绩效成绩有误");
        }


        System.out.println("==============================================");
        System.out.println("请输入星期信息：");
        String week = sc.next();
        switch (week){
            case "周一" :
                System.out.println(111);
                break ;
            case "周二" :
                System.out.println(222);
                break;
            case "周三" :
                System.out.println(333);
                break;
            case "周四" :
                System.out.println(444);
                break;
            case "周五" :
                System.out.println(555);
                break;
            case "周六" :
                System.out.println(666);
                break;
            case "周天" :
            case "周日" :
                System.out.println(333);
                break;
            default:{
                System.out.println("您输入的信息有误");
            }
        }
        System.out.println("祝您一周愉快");
        System.out.println("------------------------------------------------");
        for (int b = 0; b < 3; b++){
            System.out.println("b1");
        }
        double peak = 8840880;
        double paper = 0.1;
        int fold = 0;
        while (paper < peak){
            fold += 1;
            paper *= 2;
        }
        System.out.println("需要折叠的次数：" + fold);
        System.out.println("此时纸的高度为：" + paper);
        System.out.println("=======================================");
        int c = 0;
        do{
            System.out.println("ccc");
            c++;
        }while(c < 3);
        System.out.println("=============================");
        int sum = 0;
        for (int g = 1;g <= 100 ; g +=2 ){
            sum += g;
        }
        System.out.println(sum);
        int wum1 = 0;
        for (int k = 1;k < 100; k += 2){
            if (k % 2 == 1){
                wum1 += k;
            }
        }
        System.out.println(wum1);
    }
}
