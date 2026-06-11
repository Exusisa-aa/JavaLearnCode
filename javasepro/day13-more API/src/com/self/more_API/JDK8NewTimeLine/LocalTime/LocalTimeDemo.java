package com.self.more_API.JDK8NewTimeLine.LocalTime;

import java.time.LocalTime;

public class LocalTimeDemo {
    public static void main(String[] args) {
        //0.创建对象
        LocalTime lt = LocalTime.now();
        System.out.println(lt);
        System.out.println("-------------------------------");

        //1.获取信息
        int hour = lt.getHour();
        int minute = lt.getMinute();
        int second= lt.getSecond();
        int nano = lt.getNano();
        System.out.println(hour + " " + minute + " " + second + " " + nano);
        System.out.println("-------------------------------");

        //2.修改指定信息
        LocalTime lt1 = lt.withHour(23).withMinute(2).withSecond(2).withNano(2);
        System.out.println(lt1);
        System.out.println("-------------------------------");

        //3.指定某信息加多少
        LocalTime lt2 = lt1.plusHours(1).plusMinutes(10).plusSeconds(10).plusNanos(10);
        System.out.println(lt2);
        System.out.println("-------------------------------");

        //4.指定某信息减多少
        LocalTime lt3 = lt2.minusHours(1).minusMinutes(10).minusSeconds(10).minusNanos(10);
        System.out.println(lt3);
        System.out.println("-------------------------------");

        //5.修改指定时间对象
        lt = LocalTime.of(11,11,11,11);
        System.out.println(lt);
        System.out.println("-------------------------------");

        //6.判断两个对象是否相等，在前或是在后
        System.out.println(lt3.equals(lt1));
        System.out.println(lt.isAfter(lt3));
        System.out.println(lt.isBefore(lt3));
    }
}
