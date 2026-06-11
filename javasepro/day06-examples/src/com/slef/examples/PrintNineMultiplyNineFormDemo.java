package com.slef.examples;

public class PrintNineMultiplyNineFormDemo {
    //打印99乘法表
    public static void main(String[] args) {
        form();//我的方法  没错但是不好
        System.out.println("-----------------------------------");
        another();//黑马的方法 整洁 优雅
    }

    public static void form(){
        for (int i = 1; i <= 9;i++) {
            System.out.print("1*" + i + "=" + i + " ");
        }
        System.out.println(" ");
        for (int i = 2; i <= 9;i++) {
            int result = i*2;
            System.out.print("2*" + i + "=" + result + " ");
        }
        System.out.println(" ");
        for (int i = 3; i <= 9;i++) {
            int result = i*3;
            System.out.print("3*" + i + "=" + result + " ");
        }
        System.out.println(" ");
        for (int i = 4; i <= 9;i++) {
            int result = i*4;
            System.out.print("4*" + i + "=" + result + " ");
        }
        System.out.println(" ");
        for (int i = 5; i <= 9;i++) {
            int result = i*5;
            System.out.print("5*" + i + "=" + result + " ");
        }
        System.out.println(" ");
        for (int i = 6; i <= 9;i++) {
            int result = i*6;
            System.out.print("6*" + i + "=" + result + " ");
        }
        System.out.println(" ");
        for (int i = 7; i <= 9;i++) {
            int result = i*7;
            System.out.print("7*" + i + "=" + result + " ");
        }
        System.out.println(" ");
        for (int i = 8; i <= 9;i++) {
            int result = i*8;
            System.out.print("8*" + i + "=" + result + " ");
        }
        System.out.println(" ");
        for (int i = 9; i <= 9;i++) {
            int result = i*9;
            System.out.print("9*" + i + "=" + result + " ");
        }
    }

    public static void another(){
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "×" + i + "=" + (i * j) + "\t");
            }
            System.out.println(" ");
        }
    }
}
