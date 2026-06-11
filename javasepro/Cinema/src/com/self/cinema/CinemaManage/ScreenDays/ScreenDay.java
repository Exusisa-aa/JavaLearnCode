package com.self.cinema.CinemaManage.ScreenDays;

import com.self.cinema.CinemaManage.ScreenDays.ScreenTimes.ScreenTime;

import java.io.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Objects;

public class ScreenDay implements Serializable {
    @Serial
    private static final long serialVersionUID = 2L; // 必须添加
    private LocalDate dateInfo;//放映日期
    private final LinkedHashSet<ScreenTime> screenTimes = new LinkedHashSet<>();//放映时间

    public ScreenDay(LocalDate dateInfo) {
        this.dateInfo = dateInfo;
    }


    public void printInfo() {
        System.out.println("日期=" + dateInfo );
    }

    public LinkedHashSet<ScreenTime> getScreenTimes() {
        return screenTimes;
    }

    public LocalDate getDateInfo() {
        return dateInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScreenDay screenDay = (ScreenDay) o;
        return Objects.equals(dateInfo, screenDay.dateInfo) && Objects.equals(screenTimes, screenDay.screenTimes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateInfo, screenTimes);
    }

    // 添加自定义序列化逻辑
    @Serial
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeObject(dateInfo.toString()); // 序列化 LocalDate 为字符串
    }

    @Serial
    private void readObject(ObjectInputStream in)
            throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        String dateStr = (String) in.readObject();
        dateInfo = LocalDate.parse(dateStr); // 反序列化字符串为 LocalDate

    }
}


