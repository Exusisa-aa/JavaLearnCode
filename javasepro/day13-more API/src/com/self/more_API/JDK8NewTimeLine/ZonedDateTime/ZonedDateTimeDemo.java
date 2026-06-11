package com.self.more_API.JDK8NewTimeLine.ZonedDateTime;

import java.time.Clock;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZonedDateTimeDemo {
    public static void main(String[] args) {
        ZoneId id = ZoneId.systemDefault();
        ZoneId id1 = ZoneId.of("America/New_York");
        Clock c = Clock.systemUTC();

        ZonedDateTime zdt1 = ZonedDateTime.now();
        ZonedDateTime zdt2 = ZonedDateTime.now(id1);
        ZonedDateTime zdt3 = ZonedDateTime.now(c);
        System.out.println(zdt1);
        System.out.println(zdt2);
        System.out.println(zdt3);

        //其余方法与LocalDateTime一致
        zdt1 = ZonedDateTime.of(2022,2,2,2,2,2,2,id);

    }
}
