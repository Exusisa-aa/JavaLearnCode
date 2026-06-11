package com.self.processcontroller;
import java.util.Scanner;
public class IfBranchDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //if分支单条件：测体温时，若体温超过37.5则触发警报，若体温未超过则为通过
        double temperature1 = 39.0;
        if (temperature1 > 37.5){
            System.out.println("温度异常，带走");
        double temperature2 = 37.1;
        if (temperature2 > 37.5){
            System.out.println("温度异常，带走");
            }else {
            System.out.println("通过");
        }
        }
        System.out.println("-------------------------------------------------------------------");
        //if条件双分支；发红包90元时，若红包内有>=90元，则发出红包，若<90元，则提示余额不足
        double money1 = 100.0;
        if (money1 >= 90){
            System.out.println("红包已发出");
        }else{
            System.out.println("余额不足");
        }
        double money2 = 89.0;
        if (money2 >= 90){
            System.out.println("红包已发出");
        }else{
            System.out.println("余额不足");
        }
        System.out.println("---------------------------------------------------------------------------------------");
        /*
        if条件多分支：某公司有一绩效系统：当绩效在（0,60]则评分为D  当绩效在(60,80]则评分为C  当绩效在(80,90]则评分为B  当绩效在(90,100]则
        评分为A  若输入0至100以外的数则提示输入有误
         */
        int score = 91;
        if (score > 0 && score <= 60){
            System.out.println("您的绩效评分为D");
        }else if (score > 60 && score <=80){
            System.out.println("您的绩效评分为C");
        }else if (score > 80 && score <=90){
            System.out.println("您的绩效评分为B");
        }else if (score > 90 && score <=100){
            System.out.println("您的绩效评分为A");
        }else{
            System.out.println("输入有误");
        }
        System.out.println("--------------------------------------------------------------------");
        //多分支结合人机交互
        System.out.println("请输入您的绩效分数：");
        int score1 =sc.nextInt();
        if (score1 > 0 && score1 <= 60){
            System.out.println("您的绩效评分为D");
        }else if (score1 > 60 && score1 <=80){
            System.out.println("您的绩效评分为C");
        }else if (score1 > 80 && score1 <=90){
            System.out.println("您的绩效评分为B");
        }else if (score1 > 90 && score1 <=100){
            System.out.println("您的绩效评分为A");
        }else{
            System.out.println("输入有误");
        }
    }
}
