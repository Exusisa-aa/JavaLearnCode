package com.self.FileAndIo.Recursion;

public class Factorial {
    public static void main(String[] args) {
        System.out.println("5的阶乘为：" + factorial(5));
        System.out.println("1-100的和为：" + sum(100));

        //有一猴子，每天吃一半桃子，再多吃一个，重复好几天，第十天发现桃子只有一个了，求原来的桃子数
        //f(10) = 1
        //f(n)-f(n)/2-1 = f(n+1)
        //f(n) = 2f(n+1)+2
        System.out.println("原来有桃子数：" + eat(1));
    }

    public static int factorial(int n) {
        if(n == 0 || n == 1) {
            return 1;
        }else {
            return factorial(n-1) * n;
        }
    }

    public static int sum(int n){
        if(n == 1){
            return 1;
        }else {
            return sum(n - 1) + n;
        }
    }

    public static int eat(int n){
        if(n == 10){
            return 1;
        }else {
            return 2*eat(n+1)+2;
        }
    }
}
