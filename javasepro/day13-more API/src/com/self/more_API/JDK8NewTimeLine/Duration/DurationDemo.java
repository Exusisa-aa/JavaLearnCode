package com.self.more_API.JDK8NewTimeLine.Duration;

import java.time.*;

public class DurationDemo {
    public static void main(String[] args) {
        //duration 支持LocalTime LocalDateTime Instant
        LocalTime lt1 = LocalTime.of(22,1,1,1);
        LocalTime lt2 = LocalTime.of(23,2,2,2);

        Duration d1 = Duration.between(lt1,lt2);
        System.out.println(d1.toDays());
        System.out.println(d1.toHours());
        System.out.println(d1.toMinutes());
        System.out.println(d1.toSeconds());
        System.out.println(d1.toMillis());
        System.out.println(d1.toNanos());
        System.out.println("==============");

        LocalDateTime ldt1 = LocalDateTime.of(2023,1,1,1,1,1,1);
        LocalDateTime ldt2= LocalDateTime.of(2077,2,2,2,2,2,2);



        Duration d2 = Duration.between(ldt1,ldt2);
        System.out.println(d2.toDays());
        System.out.println(d2.toHours());
        System.out.println(d2.toMinutes());
        System.out.println(d2.toSeconds());
        System.out.println(d2.toMillis());
        System.out.println(d2.toNanos());
        System.out.println("==============");

        Instant i1 = Instant.now();
        Instant i2 = Instant.now().plusSeconds(3600);


        Duration d3 = Duration.between(i1,i2);
        System.out.println(d3.toDays());
        System.out.println(d3.toHours());
        System.out.println(d3.toMinutes());
        System.out.println(d3.toSeconds());
        System.out.println(d3.toMillis());
        System.out.println(d3.toNanos());

    }
}
