package com.slef.examples;

public class PrintTrianglePracticeDemo1 {
    public static void main(String[] args) {
        int n = 3;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n-i; j++) {
                System.out.print("\t");
            }
            for (int j = 1; j <= 2*i-1; j++) {
                System.out.print("*" + "\t");
            }
            System.out.println("\t");
        }

        int m = 10;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= m-i; j++) {
                System.out.print("\t");
            }
            for (int j = 1; j <= 2*i-1; j++) {
                System.out.print(j % 2 == 0? "\t" : "*" +"\t");
            }
            System.out.println("\t");
        }
    }
}
