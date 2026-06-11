package com.self.array;
import java.util.Random;
import java.util.Scanner;
public class RandomRankDemo {
    //某公司开发部5民开发人员，要进行项目进展汇报演讲，现在采取随机排名后进行汇报，先录入五名员工的号码，然后展示一组随机排名号。
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        int[] number = new int[5];
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
        for (int i = 0; i < number.length; i++) {
            int index = r.nextInt(number.length);
            int temp = number[index];
            number[index] = number[i];
            number[i] = temp;
        }
        for (int i = 0; i < number.length; i++) {
            System.out.println(number[i]);
        }
    }
}
