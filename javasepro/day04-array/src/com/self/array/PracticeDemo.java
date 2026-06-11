package com.self.array;
import java.util.Scanner;
public class PracticeDemo {
    public static void main(String[] args) {
        //某歌唱比赛中，需要开发一个系统:可以录入6民评委的打分，录入完毕后立即输出平均分作为选手的得分。
        Scanner sc = new Scanner(System.in);
        double[] score = new double[6];
        double sum = 0;
        double average;
        for(int i = 0;i < score.length;i++){
            while(true){
                System.out.println("请输入第" + (i + 1) + "位评委的评分：");
                double s = sc.nextDouble();
                if(s >= 0.0 && s <= 10.0){
                    System.out.println("第" + (i + 1) + "位评委的评分为：" + s);
                    score[i] = s;
                    sum += score[i];
                    break;
                }else{
                    System.out.println("您输入的评分有误，请重新输入。");
                }
            }
        }
        double max = score[0];
        for (int i = 1; i < score.length; i++) {
            if(max < score[i]){
                max = score[i];
            }
        }
        double min = score[0];
        for (int i = 1; i < score.length; i++) {
            if(min > score[i]){
                min = score[i];
            }
        }
        sum = sum - max - min;
        average = sum / (score.length - 2);
        System.out.println("去掉一个最高分与一个最低分，该选手的平均分为：" + average);
    }

}
