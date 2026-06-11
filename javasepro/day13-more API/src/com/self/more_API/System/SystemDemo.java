package com.self.more_API.System;

public class SystemDemo {
    public static void main(String[] args) {;
        long time1 = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            System.out.println(i);
        }
        long time2 = System.currentTimeMillis();
        System.out.println((time2 - time1) / 1000.000 + "s");


        System.exit(0);//终止java虚拟机的运行，0为人工终止
    }
}
