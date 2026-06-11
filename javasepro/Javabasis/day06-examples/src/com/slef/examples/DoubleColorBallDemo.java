package com.slef.examples;
import java.util.Random;
import java.util.Scanner;
public class DoubleColorBallDemo {
    public static void main(String[] args) {
        int[] randomRedBalls = RandomRedBalls();
        int[] randomBlueBall = RandomBlueBall();
        int[] customRedBalls = CustomRedBalls();
        int[] customBlueBall = CustomBlueBall();
        JudgementAndReward(randomRedBalls,randomBlueBall,customRedBalls,customBlueBall);
    }

    public static int[] RandomRedBalls(){
        Random r = new Random();
        int[] randomRedBalls = new int[6];
        for (int i = 0; i < randomRedBalls.length; i++) {
            while (true) {
                int index = r.nextInt(33)+1;
                if (!exist(randomRedBalls,index)) {
                    randomRedBalls[i] = index;
                    break;
                }
            }
        }
        return randomRedBalls;
    }

    public static int[] RandomBlueBall(){
        Random r = new Random();
        int[] randomBlueBall = new int[1];
        for (int i = 0; i < randomBlueBall.length; i++) {
            int index = r.nextInt(16)+1;
            randomBlueBall[i] = index;
        }
        return randomBlueBall;
    }

    public static int[] CustomRedBalls(){
        Scanner sc = new Scanner(System.in);
        int[] customRedBalls = new int[6];
        for (int i = 0; i < customRedBalls.length; i++) {
            while (true){
                System.out.println("请输入第" + (i + 1) + "号球的数字");
                int s = sc.nextInt();
                if (exist(customRedBalls,s)) {
                    System.out.println("您输入的号码有重复，请重新输入：");
                }else if(s >= 1 && s <= 33){
                    System.out.println("第" + (i + 1) + "号球的号码为" + s);
                    customRedBalls[i] = s;
                    break;
                }else{
                    System.out.println("您输入的号码有误,请重新输入：");
                }
            }
        }
        return customRedBalls;
    }

    public static int[] CustomBlueBall(){
        Scanner sc = new Scanner(System.in);
        int[] customBedBall = new int[1];
        while (true) {
            System.out.println("请输入篮球的号码");
            int s = sc.nextInt();
            if(s >= 1 && s <= 16){
                System.out.println("您的篮球号码为：" + s);
                customBedBall[0] = s;
                break;
            }else{
                System.out.println("您输入的号码有误，请重新输入：");
            }
        }
        return customBedBall;
    }
    public static void JudgementAndReward(int[] randomredballs,int[] randomblueball,int[] customredballs,int[] custombuleball){
        String[] money ={"一等奖：1000万元","二等奖：500万元","三等奖：3000元","四等奖：200元","五等奖：10元","六等奖：5元",};
        System.out.println("官方随机出的红球号码为：");
        System.out.print("[");
        for (int i = 0; i < randomredballs.length; i++) {
            System.out.print(i == randomredballs.length-1 ?randomredballs[i] : randomredballs[i] + " ");
        }
        System.out.print("]");

        System.out.println(" ");
        System.out.println("顾客输入的红球号码为：");
        System.out.print("[");
        for (int i = 0; i < customredballs.length; i++) {
            System.out.print(i == customredballs.length-1 ?customredballs[i] : customredballs[i] + " ");
        }
        System.out.print("]");

        System.out.println(" ");
        System.out.println("官方随机出的蓝球号码为：");
        System.out.print("[");
        System.out.print(randomblueball[0]);
        System.out.print("]");

        System.out.println(" ");
        System.out.println("顾客输入的蓝球号码为：");
        System.out.print("[");
        System.out.print(custombuleball[0]);
        System.out.print("]");
        System.out.println(" ");

        int redCount = resultr(randomredballs,customredballs);
        int blueCount = resultb(randomblueball,custombuleball);

        if(redCount == 6 && blueCount == 1){
            System.out.println("恭喜您中了" + money[0]);
        } else if (redCount == 6 && blueCount == 0) {
            System.out.println("恭喜您中了" + money[1]);
        } else if (redCount == 5 && blueCount == 1) {
            System.out.println("恭喜您中了" + money[2]);
        } else if (redCount == 5 && blueCount == 0) {
            System.out.println("恭喜您中了" + money[3]);
        } else if (redCount == 4 && blueCount == 1) {
            System.out.println("恭喜您中了" + money[3]);
        } else if (redCount == 4 && blueCount == 0) {
            System.out.println("恭喜您中了" + money[4]);
        } else if (redCount == 3 && blueCount == 1) {
            System.out.println("恭喜您中了" + money[4]);
        } else if (redCount == 2 && blueCount == 1) {
            System.out.println("恭喜您中了" + money[5]);
        } else if (redCount == 1 && blueCount == 1) {
            System.out.println("恭喜您中了" + money[5]);
        } else if (redCount == 0 && blueCount == 1) {
            System.out.println("恭喜您中了" + money[5]);
        } else {
            System.out.println("很遗憾您未中奖~~");
        }

    }

    public static boolean exist(int[] numbers,int s){
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] == 0){
                return false;
            }
            if(numbers[i] == s){
                return true;
            }
        }
        return false;
    }


    public static int resultr(int[] randomredballs,int[] customredballs){
        int redCount = 0;
        for (int i = 0; i < randomredballs.length; i++) {
            for (int j = 0; j < randomredballs.length; j++) {
                if(randomredballs[i] == customredballs[j]){
                    redCount++;
                    break;
                }
            }
        }
        System.out.println("红球号码一共镖中" + redCount + "个");
        return redCount;
    }

    public static int resultb(int[] randomblueball,int[] customblueball){
        int blueCount = 0;
        if(randomblueball[0] == customblueball[0]){
            blueCount++;
        }
        System.out.println("篮球镖中了" + blueCount + "个");
        return blueCount;
    }
}
