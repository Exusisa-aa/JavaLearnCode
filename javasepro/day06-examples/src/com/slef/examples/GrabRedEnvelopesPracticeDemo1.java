package com.slef.examples;
import java.util.Scanner;
import java.util.Random;
public class GrabRedEnvelopesPracticeDemo1 {
    public static void main(String[] args) {
            red();
            envelop();
    }

    public static void red(){
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        int[] bags = {9,188,520,666,99999};
        for (int i = 0; i < bags.length; i++) {
            while (true){
                int rrr = r.nextInt(bags.length);
                if (bags[rrr] != 0) {
                    System.out.println("输入随机数参与抽奖：");
                    String rr = sc.next();
                    System.out.println("恭喜第" + (i + 1) + "位粉丝抽中红包" + bags[rrr]);
                    bags[rrr] = 0;
                    break;
                }
            }
        }
        System.out.println("活动结束了~~");
    }

    public static void envelop(){
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        int[] bags = {9,188,520,666,99999};
        for (int i = 0; i < bags.length; i++) {
            int rr = r.nextInt(bags.length);
            int temp = bags[i];
            bags[i] = bags[rr];
            bags[rr] = temp;
        }
        for (int i = 0; i < bags.length; i++) {
            System.out.println("请输入随机数开始抽奖：");
            String rrr = sc.next();
            System.out.println("恭喜第" + (i + 1) + "位粉丝抽中红包" + bags[i]);
        }
        System.out.println("活动结束了~~");
    }
}
