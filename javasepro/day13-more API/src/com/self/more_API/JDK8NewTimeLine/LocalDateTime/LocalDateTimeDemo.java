package com.self.more_API.JDK8NewTimeLine.LocalDateTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalDateTimeDemo {
    public static void main(String[] args) {
        //0.创建对象
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);
        System.out.println("-------------------------------");

        //1.获取信息
        int year = ldt.getYear();
        int month = ldt.getMonthValue();
        int monthDay = ldt.getDayOfMonth();
        int yearDay = ldt.getDayOfYear();
        int weekDay = ldt.getDayOfWeek().getValue();
        int hour = ldt.getHour();
        int minute = ldt.getMinute();
        int second= ldt.getSecond();
        int nano = ldt.getNano();
        System.out.println(hour + " " + minute + " " + second + " " + nano);
        System.out.println(year + " " + month + " " + monthDay + " " + yearDay + " " + weekDay);
        System.out.println("-------------------------------");

        //2.修改指定信息
        LocalDateTime ldt1 = ldt.withYear(2077).withMonth(1).withDayOfMonth(1).withDayOfYear(1).withHour(23).withMinute(2).withSecond(2).withNano(2);
        System.out.println(ldt1);
        System.out.println("-------------------------------");

        //3.指定某信息加多少
        LocalDateTime ldt2 = ldt1.plusYears(1).plusMonths(1).plusWeeks(1).plusDays(1).plusHours(1).plusMinutes(10).plusSeconds(10).plusNanos(10);
        System.out.println(ldt2);
        System.out.println("-------------------------------");

        //4.指定某信息减多少
        LocalDateTime ldt3 = ldt2.minusYears(1).minusMonths(1).minusWeeks(1).minusDays(1).minusHours(1).minusMinutes(10).minusSeconds(10).minusNanos(10);
        System.out.println(ldt3);
        System.out.println("-------------------------------");

        //5.修改指定时间对象
        ldt = LocalDateTime.of(2100,1,1,11,11,11,11);
        System.out.println(ldt);
        System.out.println("-------------------------------");

        //6.判断两个对象是否相等，在前或是在后
        System.out.println(ldt3.equals(ldt1));
        System.out.println(ldt.isAfter(ldt3));
        System.out.println(ldt.isBefore(ldt3));

        //7.拆分和合并
        LocalDate ld = ldt.toLocalDate();
        LocalTime lt = ldt.toLocalTime();
        LocalDateTime ldt4 = LocalDateTime.of(ld,lt);
    }
}
