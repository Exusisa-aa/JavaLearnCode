package com.self.array;
import java.util.Scanner;
import java.util.Random;

public class RandomRankPracticeDemo {
    //某公司开发部5民开发人员，要进行项目进展汇报演讲，现在采取随机排名后进行汇报，先录入五名员工的号码，然后展示一组随机排名号。
    public static void main(String[] args) {
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        int[] codes = new int[5];
        for (int i = 0; i < codes.length; i++) {
            while (true) {
                System.out.println("请输入第" + (i + 1) + "位员工的号码");
                int s = sc.nextInt();
                if(s >= 0 && s <= 100){
                    System.out.println("该员工的号码为：" + s);
                    codes[i] = s;
                    break;
                }else{
                    System.out.println("您输入的号码有误，请重新输入：");
                }
            }
        }
        for (int i = 0; i < codes.length; i++) {
            int index = r.nextInt(codes.length);//0-4
            int temp = codes[index];
            codes[index] = codes[i];
            codes[i] = temp;
        }
        for (int i = 0; i < codes.length; i++) {
            System.out.println(codes[i]);
        }
    }
}
