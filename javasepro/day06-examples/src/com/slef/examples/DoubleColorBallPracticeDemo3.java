package com.slef.examples;
import java.util.Random;
import java.util.Scanner;
public class DoubleColorBallPracticeDemo3 {
    public static void main(String[] args) {
        int[] randomRedBalls = RandomRedBalls();
        int[] customRedBalls = CustomRedBalls();
        int randomBlueBall = RandomBlueBall();
        int customBlueBall = CustomBlueBall();

        judgementOfReward(randomRedBalls,customRedBalls,randomBlueBall,customBlueBall);
    }

    public static int[] RandomRedBalls(){
        Random r = new Random();
        int[] randomRedBalls = new int[6];
        for (int i = 0; i < randomRedBalls.length; i++) {
            while (true) {
                int rr =r.nextInt(33)+1;
                if(!judge(randomRedBalls,rr)){
                    randomRedBalls[i] = rr;
                    break;
                }
            }
        }
        return randomRedBalls;
    }

    public static int[] CustomRedBalls(){
        Scanner sc = new Scanner(System.in);
        int[] customRedBalls = new int[6];
        for (int i = 0;i < customRedBalls.length; i++) {
            System.out.println("请输入第" + (i + 1) + "位红球号码");
            while (true){
                int rr =sc.nextInt();
                if(judge(customRedBalls,rr)){
                    System.out.println("您输入的号码重复了，请重新输入：");
                } else if (rr >= 1 && rr <= 33) {
                    customRedBalls[i] = rr;
                    break;
                } else {
                    System.out.println("您输入的号码有误，请重新输入：");
                }
            }
        }
        return customRedBalls;
    }

    public static int RandomBlueBall(){
        Random r = new Random();
        int randomBlueBall;
        randomBlueBall = r.nextInt(16)+1;
        return randomBlueBall;
    }

    public static int CustomBlueBall(){
        int customBlueBall;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您的蓝球号码：");
        while (true) {
            int rr = sc.nextInt();
            if(rr >= 1 && rr <= 16){
                customBlueBall = rr;
                break;
            }else {
                System.out.println("您输入的号码有误，请重新输入：");
            }
        }
        return customBlueBall;
    }

    public static void judgementOfReward(int[] randomRedBalls,int[] customRedBalls,int randomBlueBall,int customBlueBall){
        String[] money = {"一等奖：1000万元","二等奖：500万元","三等奖：3000元","四等奖：200元","五等奖：10元","六等奖：5元",};
        System.out.println("官方随机的红球号码为：");
        System.out.print("[");
        for (int i = 0; i < randomRedBalls.length; i++) {
            System.out.print(i == randomRedBalls.length-1?randomRedBalls[i]:randomRedBalls[i] + " ");
        }
        System.out.println("]");


        System.out.println("官方随机的蓝球号码为：");
        System.out.print("[");
        System.out.print(randomBlueBall);
        System.out.println("]");


        System.out.println("顾客输入的的红球号码为：");
        System.out.print("[");
        for (int i = 0; i < randomRedBalls.length; i++) {
            System.out.print(i == customRedBalls.length-1?customRedBalls[i]:customRedBalls[i] + " ");
        }
        System.out.println("]");


        System.out.println("顾客输入的的蓝球号码为：");
        System.out.print("[");
        System.out.print(customBlueBall);
        System.out.println("]");

        int red = red(randomRedBalls,customRedBalls);
        System.out.println("您的红球中标个数为：" + red);
        int blue =blue(randomBlueBall,customBlueBall);
        System.out.println("您的篮球中标个数为：" + blue);

        if(red == 6 && blue == 1){
            System.out.println("恭喜这位顾客获得了" + money[0]);
        } else if (red == 6 && blue == 0) {
            System.out.println("恭喜这位顾客获得了" + money[1]);
        } else if (red == 5 && blue == 1) {
            System.out.println("恭喜这位顾客获得了" + money[2]);
        } else if (red == 5 && blue == 0) {
            System.out.println("恭喜这位顾客获得了" + money[3]);
        } else if (red == 4 && blue == 1) {
            System.out.println("恭喜这位顾客获得了" + money[3]);
        } else if (red == 4 && blue == 0) {
            System.out.println("恭喜这位顾客获得了" + money[4]);
        } else if (red == 3 && blue == 1) {
            System.out.println("恭喜这位顾客获得了" + money[4]);
        } else if (red == 2 && blue == 1) {
            System.out.println("恭喜这位顾客获得了" + money[4]);
        } else if (red == 1 && blue == 1) {
            System.out.println("恭喜这位顾客获得了" + money[5]);
        } else if (red == 0 && blue == 1) {
            System.out.println("恭喜这位顾客获得了" + money[5]);
        }else {
            System.out.println("很遗憾您并未中奖，感谢您对本公司的大力支持~~");
        }
    }

    public static int red(int[] randomRedBalls,int[] customRedBalls){
        int red = 0;
        for (int i = 0; i < randomRedBalls.length; i++) {
            for (int i1 = 0; i1 < customRedBalls.length; i1++) {
                if(randomRedBalls[i] == customRedBalls[i1]){
                    red++;
                    break;
                }
            }
        }
        return red;
    }

    public static int blue(int randomBlueBall,int customBlueBall){
        int blue = 0;
        if(randomBlueBall == customBlueBall){
            blue++;
        }
        return blue;
    }

    public static boolean judge(int[] array,int number){
        for (int i = 0; i < array.length; i++) {
            if(array[i] == 0){
                return false;
            } else if (array[i] == number) {
                return true;
            }
        }
        return false;
    }
}
