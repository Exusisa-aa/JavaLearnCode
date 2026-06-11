package com.self.processcontroller;

public class ForLoopDemo {
    public static void main(String[] args) {
        //掌握for循环的使用方法
        for (int i = 0; i <= 5; i++) {
            System.out.println("hello world");
        }//先执行i=0 然后判断i是否小于等于5 为true 则执行大括号内容 最后再执行迭代代码
        for (int c = 0; c <= 20; c += 4){
            System.out.println("wdf");
        }
        System.out.println("---------------------------------------------");
        //使用for循环批量产生数据
        for (int i = 0; i <= 100; i++) {
            System.out.println(i);
        }
        System.out.println("-----------------------------------------");
        int sum = 0;
        for (int i = 1; i <= 100 ; i += 2) {
            sum += i;
        }
        System.out.println("1~100的数据和为：" + sum);
        System.out.println("----------------------------------------------------------------");
        //求1-100的奇数和方法1
        int sum1 = 0;
        for (int i = 1; i <= 100 ; i += 2) {
            sum1 +=i;
        }
        System.out.println("0~100的奇数之和:" + sum);
        //求1-100的基数之和方法2
        int sum2 = 0;
        for (int i = 1; i <= 100 ; i++) {
            if (i % 2 == 1){
                sum2 += i;
            }
        }
        System.out.println("0~100的奇数之和" + sum2);
    }
    }

