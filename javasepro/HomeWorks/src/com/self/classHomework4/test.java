package com.self.classHomework4;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入三个数：");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        if(a+b > c && a+c > b && b+c > a){
            if(a == b && b == c){
                System.out.println("等边三角形");
            } else if (a == b || b == c || a == c) {
                System.out.println("等腰三角形");
            } else {
                System.out.println("普通三角形");
            }
        }else {
            System.out.println("不是三角形");
        }
    }
}
