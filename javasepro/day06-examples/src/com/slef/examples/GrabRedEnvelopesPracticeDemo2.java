package com.slef.examples;
import  java.util.Scanner;
import java.util.Random;
public class GrabRedEnvelopesPracticeDemo2 {
    public static void main(String[] args) {
        red();
        bag();
    }

    public static void red(){
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        int[] money ={9,188,250,666,99999};
        for (int i = 0; i < money.length; i++) {
            while (true){
                int rr = r.nextInt(money.length);
                if ( money[rr] != 0){
                    System.out.println("按随机键开始抽奖：");
                    String m = sc.next();
                    System.out.println("恭喜您抽中了" + money[rr] + "元");
                    money[rr] = 0;
                    break;
                }
            }
        }
        System.out.println("活动已结束~~");
    }

    public static void bag(){
        Scanner sc = new Scanner(System.in);
        int[] money ={9,188,250,666,99999};
        Random r = new Random();
        for (int i = 0;i < money.length;i++) {
            int index = r.nextInt(money.length);
            int temp = money[i];
            money[i] = money[index];
            money[index] = temp;
        }
        for (int i = 0; i < money.length; i++) {
            System.out.println("输入任意键完成抽奖");
            String n = sc.next();
            System.out.println("第一位粉丝抽中了" + money[i] + "元");
        }
        System.out.println("活动已结束~~");
    }
}
