package com.self.array;
import java.util.Scanner;
public class DynamicallyInitializeArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //动态初始化数组
        int[] array = new int[5];

        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(array[2]);
        System.out.println(array[3]);
        System.out.println(array[4]);

        array[0] = 20;
        array[1] = 50;
        array[2] = 70;
        array[3] = 100;
        array[4] = 200;

        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(array[2]);
        System.out.println(array[3]);
        System.out.println(array[4]);
        System.out.println("=====================================================================");



        char[] abc = new char[3];
        //System.out.println(abc[0]);  char字符转数字为字符   但0没有对应的字符  所以乱码
        //System.out.println(abc[2]);
        System.out.println((int) abc[0]);
        System.out.println((int) abc[2]);


        double[] bcd= new double[3];
        System.out.println(bcd[0]);
        System.out.println(bcd[2]);


        boolean[] cde = new boolean[3];
        System.out.println(cde[0]);
        System.out.println(cde[2]);


        String[] names = new String[3];
        System.out.println(names[0]);
        System.out.println(names[2]);
        System.out.println("============================================================================");


        //案例；某歌唱比赛中，需要开发一个系统:可以录入6民评委的打分，录入完毕后立即输出平均分作为选手的得分。 我的
        double[] score = new double[6];
            while(true){
                System.out.println("请输入第一位评委的评分");
                double s1 = sc.nextDouble();
                if (s1 >= 0.0 && s1 <= 10.0){
                    score[0] = s1;
                    System.out.println("第一位评委的打分为：" + s1);
                    break;
                }else{
                    System.out.println("您输入的评分有误，请重新输入：");
                }
            }
            while(true){
                System.out.println("请输入第二位评委的评分");
                double s2 = sc.nextDouble();
                if (s2 >= 0.0 && s2 <= 10.0){
                    score[1] = s2;
                    System.out.println("第二位评委的打分为：" + s2);
                    break;
                }else{
                    System.out.println("您输入的评分有误，请重新输入：");
                }
            }
            while(true){
                System.out.println("请输入第三位评委的评分");
                double s3 = sc.nextDouble();
                if (s3 >= 0.0 && s3 <= 10.0){
                    score[2] = s3;
                    System.out.println("第三位评委的打分为：" + s3);
                    break;
                }else{
                    System.out.println("您输入的评分有误，请重新输入：");
                }
            }
            while(true){
                System.out.println("请输入第四位评委的评分");
                double s4 = sc.nextDouble();
                if (s4 >= 0.0 && s4 <= 10.0){
                    score[3] = s4;
                    System.out.println("第四位评委的打分为：" + s4);
                    break;
                }else{
                    System.out.println("您输入的评分有误，请重新输入：");
                }
            }
            while(true){
                System.out.println("请输入第五位评委的评分");
                double s5 = sc.nextDouble();
                if (s5 >= 0.0 && s5 <= 10.0){
                    score[4] = s5;
                    System.out.println("第五位评委的打分为：" + s5);
                    break;
                }else{
                    System.out.println("您输入的评分有误，请重新输入：");
                }
            }
            while(true){
                System.out.println("请输入第六位评委的评分");
                double s6 = sc.nextDouble();
                if (s6 >= 0.0 && s6 <= 10.0){
                    score[5] = s6;
                    System.out.println("第六位评委的打分为：" + s6);
                    break;
                }else{
                    System.out.println("您输入的评分有误，请重新输入：");
                }
            }
        double sumScore = 0;
        double averageScore = 0;
        for (int i = 0;i < score.length; i++) {
            sumScore += score[i];
            averageScore = sumScore / score.length;
        }
        System.out.println("该选手的得分为：" + averageScore);
        System.out.println("========================================================");
        //案例 黑马
        double[] score1 = new double[6];
        double sum = 0;
        double average = 0;
        for(int i = 0;i < score1.length;i++){
            while (true) {
                System.out.println("请输入第" + (i + 1) + "位评委的分数：");
                double s = sc.nextDouble();
                if (s >= 0 && s <= 10) {
                    score1[i] = s;
                    System.out.println("第" + (i + 1) + "位评委的打分是" + score1[i]);
                    sum += score1[i];
                    average = sum / score1.length;
                    break;
                }else{
                    System.out.println("您输入的评分有误，请重新评分：");
                }
            }
        }
        System.out.println("该选手的平均分是" + average);
    }
}

