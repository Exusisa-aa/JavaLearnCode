package com.slef.examples;
import java.util.Scanner;

public class JudgesScoreDemo {
    //在歌唱比赛中，有多名评委打分，请去掉一个最高分和一个最低分，计算出平均分成为最终得分。
    public static void main(String[] args) {
        double judge = judges(6);
        System.out.println("该选手的最终评分为：" + judge);
    }

    public static double judges(int n){


        Scanner sc = new Scanner(System.in);
        double[] scores = new double[n];
        double sum = 0.0;
        for (int i = 0; i < n; i++) {
            while (true) {
                System.out.println("请输入第" + (i + 1) + "位评委的评分");
                double score = sc.nextDouble();
                if(score >= 0 && score <= 100){
                    System.out.println("第" + (i + 1) + "位选手的评分为" + score);
                    scores[i] = score;
                    sum += score;
                    break;
                }else{
                    System.out.println("您输入的评分有误，请重新输入：");
                }
            }
        }
        double max = scores[0];
        for (int i = 0; i < n; i++) {
            if(scores[i] > max){
                max = scores[i];
            }
        }
        System.out.println("去掉一个最高分为：" + max);

        double min = scores[0];
        for (int i = 0; i < n; i++) {
            if(scores[i] < min){
                min = scores[i];
            }
        }
        System.out.println("去掉一个最低分为：" + min);

        sum = sum - max - min;
        double average = sum/(n-2);
        return average;
    }

}
