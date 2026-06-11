package com.slef.examples;
import java.util.Random;
import java.util.Scanner;
public class DoubleColorBallPracticeDemo2 {
    public static void main(String[] args) {
        int[] RandomRedBalls = randomRedBalls();
        int[] CustomRedBalls = customRedBalls();
        int RandomBlueBall = randomBlueBall();
        int CustomBlueBall = customBlueBall();
        judgementOfReward(RandomRedBalls,CustomRedBalls,RandomBlueBall,CustomBlueBall);
    }

    public static int[] randomRedBalls(){
        Random r = new Random();
        int[] randomRedBalls = new int[6];
        for (int i = 0;i < randomRedBalls.length;i++) {
            while (true) {
                int rr = r.nextInt(33)+1;
                if(!judge(randomRedBalls,rr)){
                    randomRedBalls[i] = rr;
                    break;
                }
            }
        }
        return randomRedBalls;
    }

    public static int[] customRedBalls(){
        Scanner sc = new Scanner(System.in);
        int[] customRedBalls = new int[6];
        for (int i = 0; i < customRedBalls.length; i++) {
            System.out.println("请输入第" + (i + 1) + "位红色球的号码");
            while (true){
                int index = sc.nextInt();
                if(judge(customRedBalls,index)){
                    System.out.println("您输入的号码已存在，请重新输入：");
                } else if (index <= 33 && index >= 1) {
                    customRedBalls[i] = index;
                    break;
                }else{
                    System.out.println("您输入的号码有误，请重新输入：");
                }

            }
        }
        return customRedBalls;
    }

    public static int randomBlueBall(){
        Random r = new Random();
        return  r.nextInt(16)+1;
    }

    public static int customBlueBall(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入蓝球的号码");
        int customBlueBall;
        while (true) {
            int rr = sc.nextInt();
            if(rr >= 1 && rr <= 16){
                customBlueBall = rr;
                break;
            }else {
                System.out.println("您输入的号码有误请重新输入：");
            }
        }
        return customBlueBall;
    }

    public static void judgementOfReward(int[] RandomRedBalls,int[] CustomRedBalls,int RandomBlueBall,int CustomBlueBall){
        String[] money = {"一等奖：1000万元","二等奖：500万元","三等奖：3000元","四等奖：200元","五等奖：10元","六等奖：5元",};
        System.out.println("官方随机出的红球号码为：");
        System.out.print("[");
        for (int i = 0; i < RandomRedBalls.length; i++) {
            System.out.print(i == RandomRedBalls.length-1?RandomRedBalls[i]:RandomRedBalls[i] + " ");
        }
        System.out.print("]");
        System.out.println(" ");

        System.out.println("顾客输入的红球号码为：");
        System.out.print("[");
        for (int i = 0; i < CustomRedBalls.length; i++) {
            System.out.print(i == CustomRedBalls.length-1?CustomRedBalls[i]:CustomRedBalls[i] + " ");
        }
        System.out.print("]");
        System.out.println(" ");

        System.out.println("官方随机出的的蓝球号码为：");
        System.out.print("[");
        System.out.print(RandomBlueBall);
        System.out.print("]");
        System.out.println(" ");

        System.out.println("顾客输入的的蓝球号码为：");
        System.out.print("[");
        System.out.print(CustomBlueBall);
        System.out.print("]");
        System.out.println(" ");

        int RedCount = redCount(RandomRedBalls,CustomRedBalls);
        System.out.println("您红球中标的个数为：" + RedCount);
        int BlueCount = blueCount(RandomBlueBall,CustomBlueBall);
        System.out.println("您蓝球中标的个数为：" + BlueCount);

        if(RedCount == 6 && BlueCount == 1){
            System.out.println("恭喜这位顾客获得了" + money[0]);
        } else if (RedCount == 6 && BlueCount == 0) {
            System.out.println("恭喜这位顾客获得了" + money[1]);
        } else if (RedCount == 5 && BlueCount == 1) {
            System.out.println("恭喜这位顾客获得了" + money[2]);
        } else if (RedCount == 5 && BlueCount == 0) {
            System.out.println("恭喜这位顾客获得了" + money[3]);
        } else if (RedCount == 4 && BlueCount == 1) {
            System.out.println("恭喜这位顾客获得了" + money[3]);
        } else if (RedCount == 4 && BlueCount == 0) {
            System.out.println("恭喜这位顾客获得了" + money[4]);
        } else if (RedCount == 3 && BlueCount == 1) {
            System.out.println("恭喜这位顾客获得了" + money[4]);
        } else if (RedCount == 2 && BlueCount == 1) {
            System.out.println("恭喜这位顾客获得了" + money[4]);
        } else if (RedCount == 1 && BlueCount == 1) {
            System.out.println("恭喜这位顾客获得了" + money[5]);
        } else if (RedCount == 0 && BlueCount == 1) {
            System.out.println("恭喜这位顾客获得了" + money[5]);
        }else {
            System.out.println("很遗憾您并未中奖，感谢您对本公司的大力支持~~");
        }
    }


    public static boolean judge(int[] array,int number){
        for (int i = 0; i < array.length; i++) {
            if(array[i] == 0){
                return false;
            }else  if(array[i] == number){
                return true;
            }
        }
        return false;
    }


    public static int redCount(int[] RandomRedBalls,int[] CustomRedBalls){
        int RedCount = 0;
        for (int i = 0; i < RandomRedBalls.length; i++) {
            for (int j = 0; j < CustomRedBalls.length; j++) {
                if(RandomRedBalls[i]  == CustomRedBalls[j]){
                    RedCount += 1;
                }
            }
        }
        return RedCount;
    }

    public static int blueCount(int RandomBlueBall,int CustomBlueBall){
        int BlueCount = 0;
        if(RandomBlueBall == CustomBlueBall){
            BlueCount++;
        }
        return BlueCount;
    }
}
