package com.self.more_API.OldDate;

import java.util.Date;

public class OldDateDemo {
    public static void main(String[] args) {
//        1.查看当前时间
        Date a = new Date();
        System.out.println(a);
//        2.把时间转为毫秒数
        long time = a.getTime();
        System.out.println(time);
//        3.把毫秒数转为时间
        time += 100 * 1000;
        Date b = new Date(time);
        System.out.println(b);
//        4.设置对象的时间
        a.setTime(704436310000L);
        System.out.println(a);
    }
}
