package com.self.homework;

public class HomeWork2Demo {
    public static void main(String[] args) {
        int count = 0;
        String rs = "";
        for (int i = 100; i <= 999; i++) {
            int gw = i % 10;
            int sw = (i % 100) / 10;
            int bw = i / 100;
            if (gw*gw*gw + sw*sw*sw + bw*bw*bw == i) {
                count++;
                rs += i + "\t";
            }
        }
        System.out.println("一共有水仙花数" + count + "个");
        System.out.println("他们分别是" + rs);
    }
}
