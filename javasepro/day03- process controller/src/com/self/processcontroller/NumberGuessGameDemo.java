package com.self.processcontroller;
import java.util.Scanner;
import java.util.Random;
//猜数字游戏
public class NumberGuessGameDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        int point = r.nextInt(100) + 1;
        //System.out.println("生成的随机数是：" + point);
        while (true) {
            System.out.println("请输入您猜测的随机数：");
            int guess = sc.nextInt();
                if (guess < point){
                    System.out.println("您猜测的数字过小");
                }else if (guess > point) {
                    System.out.println("您猜测的数字过大");
                }else {
                    System.out.println("恭喜您猜中辣");
                    break;
                }
        }
    }
}
