package com.self.more_API.JDK8NewTimeLine.LocalDate;

import java.time.LocalDate;

public class LocalDateDemo {
    public static void main(String[] args) {
        //0.创建对象
        LocalDate ld = LocalDate.now();
        System.out.println(ld);
        System.out.println("-------------------------------");

        //1.获取信息
        int year = ld.getYear();
        int month = ld.getMonthValue();
        int monthDay = ld.getDayOfMonth();
        int yearDay = ld.getDayOfYear();
        int weekDay = ld.getDayOfWeek().getValue();
        System.out.println(year + " " + month + " " + monthDay + " " + yearDay + " " + weekDay);
        System.out.println("-------------------------------");

        //2.修改指定信息
        LocalDate ld1 = ld.withYear(2077).withMonth(1).withDayOfMonth(1).withDayOfYear(1);
        System.out.println(ld1);
        System.out.println("-------------------------------");

        //3.指定某信息加多少
        LocalDate ld2 = ld1.plusYears(1).plusMonths(1).plusWeeks(1).plusDays(1);
        System.out.println(ld2);
        System.out.println("-------------------------------");

        //4.指定某信息减多少
        LocalDate ld3 = ld2.minusYears(1).minusMonths(1).minusWeeks(1).minusDays(1);
        System.out.println(ld3);
        System.out.println("-------------------------------");

        //5.修改指定时间对象
        ld = LocalDate.of(2100,1,1);
        System.out.println(ld);
        System.out.println("-------------------------------");

        //6.判断两个对象是否相等，在前或是在后
        System.out.println(ld3.equals(ld1));
        System.out.println(ld.isAfter(ld3));
        System.out.println(ld.isBefore(ld3));
    }
}
