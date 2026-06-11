package com.self.processcontroller;
import java.util.Random;
public class RandomDemo {
    public static void main(String[] args) {
        Random r = new Random();
        for (int i = 1; i <= 100; i++) {
            int score = r.nextInt(100);//(0-99)
            System.out.println("输出的随机数是：" + score);
        }
        System.out.println("============================================================");
        for (int i = 1; i <= 100; i++) {
            int score = r.nextInt(100) + 1;//(1-100)
            System.out.println("您输入的随机数是：" + score);
        }
        System.out.println("=================================================");
        for (int i = 1; i <= 20; i++) {
            int score = r.nextInt(15) + 3;//(3-17)
            System.out.println("您输入的随机数是：" + score);
        }
    }
}
