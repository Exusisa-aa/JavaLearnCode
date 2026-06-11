package com.slef.examples;

public class PrintNineMultiplyNineFormPracticeDemo1 {
    public static void main(String[] args) {
        for (int i = 1; i <= 9 ; i++) { //每行
            for (int j = 1; j <= i ; j++) { //每行的个数
                System.out.print(j + "×" + i + "=" + (i * j) + "\t");
            }
            System.out.println(" ");
        }
    }
}
