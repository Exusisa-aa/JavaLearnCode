package com.self.CollectionsFramework.Timer;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

public class Time {
    public static void main(String[] args) {
        LocalDateTime endTime = LocalDateTime.of(2025,1,15,2,55,0);

        Timer timer = new Timer();

        System.out.println("倒计时启动！！");
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                LocalDateTime now = LocalDateTime.now();
                Duration d = Duration.between(now, endTime);
                if(d.toSeconds() >= 0) {
                    System.out.println(d.toDays() + "天" + d.toHoursPart() + "时" + d.toMinutesPart() + "分" + d.toSecondsPart() + "秒");
                }else {
                    System.out.println("时间到~~");
                    timer.cancel();
                }
            }
        },0,1000);
    }
}
