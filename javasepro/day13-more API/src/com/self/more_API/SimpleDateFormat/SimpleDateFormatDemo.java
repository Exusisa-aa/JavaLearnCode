package com.self.more_API.SimpleDateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatDemo {
    public static void main(String[] args) throws ParseException {
        Date a = new Date();
        System.out.println(a);
        long time = a.getTime();
        System.out.println(time);

        SimpleDateFormat format1 = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒 EEE a");
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss EEE a");
//        1.日期的美化字符串
        String rs1 = format1.format(a);
        System.out.println(rs1);
//        2.毫秒数转美化日期字符串
        String rs2 = format2.format(time);
        System.out.println(rs2);
//        3.将字符串日期转为date的对象
        Date b = format1.parse(rs1);
        System.out.println(b);
        Date c = format2.parse(rs2);
        System.out.println(c);
    }
}
