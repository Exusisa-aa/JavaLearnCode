package com.slef.examples;

public class PrintTriangleDemo {
    public static void main(String[] args) {
        for (int i = 1; i <= 15; i++,i++) {  //我的写法
            for (int j = 15; j >= i; j--,j--) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println(" ");
        }

        int n = 4;  //黑马
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= n-i; j++) {
                System.out.print("\t");
            }
            for (int j = 1; j <= 2*i-1; j++) {
                System.out.print("*" + "\t");
            }
            System.out.println(" ");

        }
        int m = 4;  //黑马
        for (int i = 1; i <= m ; i++) {
            for (int j = 1; j <= m - i; j++) {
                System.out.print("\t");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print(j % 2 == 0 ? "\t" : "*" + "\t");
            }
            System.out.println(" ");
        }
        //i    n-i     2*i-1
        //行   空格数   星星数
        //1    3       1
        //2    2       3
        //3    1       5
        //4    0       7
    }
}
