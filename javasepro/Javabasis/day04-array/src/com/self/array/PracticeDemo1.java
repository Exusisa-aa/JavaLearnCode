package com.self.array;
import java.util.Scanner;
import java.util.Random;
public class PracticeDemo1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        //歌唱比赛中，给六个人赋分，减去一个最高分和一个最低分，求平均分
        double[] score = new double[6];
        double sum = 0;
        double average = 0;
        for (int i = 0; i < score.length; i++) {
            while (true) {
                System.out.println("请输入" + (i + 1) + "位选手的评分：");
                double s = sc.nextDouble();
                if (s >= 0 && s <= 100.0) {
                    System.out.println("第" + (i + 1) + "位评委的评分为：" + s);
                    score[i] = s;
                    sum +=score[i];
                    break;
                } else {
                    System.out.println("您输入的分数有误，请重新输入：");
                }
            }
        }
        double max = score[0];
        for (int i = 0; i < score.length; i++) {
            if (max < score[i]) {
                max = score[i];
            }
        }
        double min = score[0];
        for (int i = 0; i < score.length; i++) {
            if (min > score[i]) {
                min = score[i];
            }
        }

        sum = sum - max - min;
        average = sum / 4;
        System.out.println("该选手的平均分为：" + average);

        //数组的随机数排序

        int number[] ={10,20,30,40,50,60};

        for(int i = 0;i < number.length;i++){
            while(true){
                System.out.println("请输入第" + (i + 1) + "位员工的号码");
                int n = sc.nextInt();
                if(n < 100 && n > 0){
                    System.out.println("第" + (i + 1) + "位员工的号码是；" + n);
                    number[i] = n;
                    break;
                }else{
                    System.out.println("您输入的号码有误，请重新输入：");
                }
            }
        }

        int index = r.nextInt(7);
        for (int i = 0; i < number.length; i++) {
            int temp = 0;
            temp = number[index];
            number[index] = number[i];
            number[i] = temp;
        }
        for (int i = 0; i < number.length; i++) {
            System.out.println(number[i]);
        }
    }
}
