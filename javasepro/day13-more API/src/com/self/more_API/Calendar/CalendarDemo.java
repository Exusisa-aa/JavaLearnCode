package com.self.more_API.Calendar;

import java.util.Calendar;
import java.util.Date;

public class CalendarDemo {
    public static void main(String[] args) {
        //1.创建对象
        Calendar c1 = Calendar.getInstance();
        System.out.println(c1);
        System.out.println("===============");

        //2.获取某信息
        System.out.println(c1.get(Calendar.YEAR));
        System.out.println(c1.get(Calendar.MONTH)+1);
        System.out.println(c1.get(Calendar.DAY_OF_MONTH));
        System.out.println(c1.get(Calendar.HOUR_OF_DAY));
        System.out.println(c1.get(Calendar.MINUTE));
        System.out.println(c1.get(Calendar.SECOND));
        System.out.println("===============");

        //3.获取日期对象
        Date a = c1.getTime();
        System.out.println(a);
        System.out.println("===============");

        //4.获取时间毫秒值
        System.out.println(c1.getTimeInMillis());
        System.out.println("===============");

        //5.修改日历信息
        c1.set(Calendar.DAY_OF_MONTH,1);
        c1.set(Calendar.YEAR,2022);
        System.out.println(c1.getTime());
        System.out.println("===============");

        //6.为某信息增加或减少
        c1.add(Calendar.DAY_OF_MONTH,10);
        System.out.println(c1.getTime());
    }
}
