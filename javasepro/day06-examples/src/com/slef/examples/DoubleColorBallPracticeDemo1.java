package com.slef.examples;
import java.util.Random;
import java.util.Scanner;
public class DoubleColorBallPracticeDemo1 {
    public static void main(String[] args) {
        int[] randomRedBalls = RandomRedBalls();
        int[] customRedBalls = CustomRedBalls();
        int randomBlueBall = RandomBlueBall();
        int customBlueBall = CustomBlueBall();
        JudgementOfResult(randomRedBalls,customRedBalls,randomBlueBall,customBlueBall);
    }

    public static int[] RandomRedBalls(){
        Random r = new Random();
        int[] randomRedBalls = new int[6];
        for (int i = 0; i < randomRedBalls.length; i++) {
            while (true) {
                int index = r.nextInt(33)+1;
                if(!judge(randomRedBalls,index)){
                    randomRedBalls[i] = index;
                    break;
                }
            }

        }
        return randomRedBalls;
    }

    public static int[] CustomRedBalls(){
        Scanner sc = new Scanner(System.in);
        int[] customRedBalls = new int[6];
        for (int i = 0; i < customRedBalls.length; i++) {
            System.out.println("请输入第" + (i + 1) + "位红球的号码：");
            while (true){
                int index = sc.nextInt();
                if(judge(customRedBalls,index)){
                    System.out.println("您输入的号码有重复，请重新输入：");
                } else if (index >= 1 && index <= 33) {
                    customRedBalls[i] = index;
                    break;
                }else{
                    System.out.println("您输入的号码不在范围内，请重新输入：");
                }
            }
        }
        return customRedBalls;
    }

    public static int CustomBlueBall(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入蓝球号码：");
        while (true) {
            int index = sc.nextInt();
            if(index >= 1 && index <= 16){
                return index;
            }else{
                System.out.println("您输入的号码不在范围内，请重新输入：");
            }
        }
    }

    public static int RandomBlueBall(){
        Random r = new Random();
        return r.nextInt(16)+1;
    }

    public static void JudgementOfResult(int[] randomRedBalls,int[] customRedBalls,int randomBlueBall,int customBlueBall){
        String[] money = {"一等奖：1000万元","二等奖：500万元","三等奖：3000元","四等奖：200元","五等奖：10元","六等奖：5元"};
        System.out.println("官方随机出的红色球号码为：");
        System.out.print("[");
        for (int i = 0; i < randomRedBalls.length; i++) {
            System.out.print(i == randomRedBalls.length-1 ? randomRedBalls[i]:randomRedBalls[i] + " ");
        }
        System.out.print("]");
        System.out.println(" ");

        System.out.println("顾客输入的红球号码为：");
        System.out.print("[");
        for (int i = 0; i < customRedBalls.length; i++) {
            System.out.print(i == customRedBalls.length-1 ? customRedBalls[i]:customRedBalls[i] + " ");
        }
        System.out.print("]");
        System.out.println(" ");

        System.out.println("官方随机出的蓝球号码为：");
        System.out.print("[");
        System.out.print(randomBlueBall);
        System.out.print("]");
        System.out.println(" ");

        System.out.println("顾客输入的蓝球号码为：");
        System.out.print("[");
        System.out.print(customBlueBall);
        System.out.print("]");
        System.out.println(" ");

        int redballcount = resultr(randomRedBalls,customRedBalls);
        int blueballcount = resultb(randomBlueBall,customBlueBall);

        if(redballcount == 6 && blueballcount == 1){
            System.out.println("恭喜该顾客获得了" + money[0]);
        } else if (redballcount == 6 && blueballcount == 0) {
            System.out.println("恭喜该顾客获得了" + money[1]);
        } else if (redballcount == 5 && blueballcount == 1) {
            System.out.println("恭喜该顾客获得了" + money[2]);
        } else if (redballcount == 5 && blueballcount == 0) {
            System.out.println("恭喜该顾客获得了" + money[3]);
        } else if (redballcount == 4 && blueballcount == 1) {
            System.out.println("恭喜该顾客获得了" + money[3]);
        } else if (redballcount == 4 && blueballcount == 0) {
            System.out.println("恭喜该顾客获得了" + money[4]);
        } else if (redballcount == 3 && blueballcount == 1) {
            System.out.println("恭喜该顾客获得了" + money[4]);
        } else if (redballcount == 2 && blueballcount == 1) {
            System.out.println("恭喜该顾客获得了" + money[4]);
        } else if (redballcount == 1 && blueballcount == 1) {
            System.out.println("恭喜该顾客获得了" + money[5]);
        } else if (redballcount == 0 && blueballcount == 1) {
            System.out.println("恭喜该顾客获得了" + money[5]);
        }else{
            System.out.println("很遗憾您并未中奖，感谢您对福彩公司做出的贡献~~");
        }
    }

    public static int resultr(int[] randomRedBalls,int[] customRedBalls){
        int redballcount = 0;
        for (int i = 0; i < randomRedBalls.length; i++) {
            for (int j = 0; j < randomRedBalls.length; j++) {
                if(randomRedBalls[i] == customRedBalls[j]){
                    redballcount++;
                    break;
                }
            }
        }
        System.out.println("该顾客中标的红球有" + redballcount + "个");
        return redballcount;
    }

    public static int resultb(int randomBlueBall,int customBlueBall){
        int blueballcount = 0;
        if(randomBlueBall == customBlueBall){
            blueballcount++;
        }
        System.out.println("该顾客中标的蓝球数为：" + blueballcount + "个");
        return blueballcount;
    }

    public static boolean judge(int[] array,int number){
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                return false;
            } else if (array[i] == number) {
                return true;
            }
        }
        return false;
    }
}
