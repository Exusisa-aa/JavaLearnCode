package com.self.more_API.JDK8NewTimeLine.Instant;

import java.time.Instant;

public class InstantDemo {
    public static void main(String[] args) {
        Instant ins = Instant.now();
        System.out.println(ins);
        long seconds = ins.getEpochSecond();//拿总秒数
        System.out.println(seconds + "s");
        int nano = ins.getNano();//拿此时的纳秒数
        System.out.println(nano + "ns");
        Instant ins1 = ins.plusSeconds(5);
        System.out.println(ins1);
        Instant ins2 = ins1.minusSeconds(5);
        System.out.println(ins2);
        //与LocalTime基本一致
    }
}
