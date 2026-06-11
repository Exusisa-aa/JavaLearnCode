package com.self.more_API.JDK8NewTimeLine.DateTimeFormatter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeFormatterDemo {
    public static void main(String[] args) {
        //创建对象
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH时mm分ss秒");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        System.out.println("==============================");

        //正向格式化
        String rs1 = formatter.format(now);
        System.out.println(rs1);
        System.out.println("==============================");

        //反向格式化
        String rs = now.format(formatter);
        System.out.println(rs);
        System.out.println("==============================");

        //解析时间
        String rs2 = now.format(formatter);
//        String rs2 = formatter.format(now);
        LocalDateTime ldt = LocalDateTime.parse(rs2,formatter);
        System.out.println(ldt);
    }
}
