package com.self.processcontroller;

public class DoWhileDemo {
    public static void main(String[] args) {
        //掌握do-while循环的使用
        int i = 0;
        do{
            System.out.println("Hello World");
            i += 1;
        }while (i <= 5);
        System.out.println("-----------------------------------------------");
        //do-while特点是先执行后判断  如抢票程序 先抢票在判断有没有抢到票
        int g = 5;
        do{
            System.out.println("抢票");
            g++;
        }while(g < 5); //即使不符合条件 仍然执行了一次
    }
}
