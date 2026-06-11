package com.slef.examples;

public class PrintTrianglePracticeDemo2 {
    public static void main(String[] args) {
        int n = 10;
        for (int i = 1; i < n; i++) {  //行数
            for (int j = 1; j < n-i; j++) {   //空格数
                System.out.print("\t");
            }
            for (int j = 0; j < 2*i-1; j++) { //星星数
                System.out.print("*" + "\t");
            }
            System.out.println("\t");
        }


        int m = 10;
        for (int i = 1; i < m; i++) {  //行数
            for (int j = 1; j < m-i; j++) {   //空格数
                System.out.print("\t");
            }
            for (int j = 0; j < 2*i-1; j++) { //星星数
                System.out.print(j % 2 == 0?"*" + "\t" : "\t");
            }
            System.out.println("\t");
        }
    }
}
