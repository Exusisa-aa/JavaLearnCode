package com.self.more_API.JDK8NewTimeLine.ZoneId;

import java.time.ZoneId;
import java.util.Set;

public class ZoneIdDemo {
    public static void main(String[] args) {
        ZoneId id1 = ZoneId.systemDefault();
        System.out.println(id1.getId());
        Set<String> set = ZoneId.getAvailableZoneIds();
        System.out.println(set);
        ZoneId id2 = ZoneId.of("America/New_York");
        System.out.println(id2.getId());
        System.out.println("-----------------");
    }
}
