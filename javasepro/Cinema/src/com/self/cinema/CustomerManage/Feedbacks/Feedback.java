package com.self.cinema.CustomerManage.Feedbacks;

import java.io.*;
import java.time.LocalDateTime;

public class Feedback implements Serializable {
    @Serial
    private static final long serialVersionUID = 3L; // 必须添加
    private String content;//评论内容
    private LocalDateTime time;//评论时间

    public void setContent(String content) {
        this.content = content;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Feedback(String content, LocalDateTime time) {
        this.content = content;
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getTime() {
        return time;
    }


    //自定义序列化
    @Serial
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();

        // 序列化 LocalDateTime -> 分解为日期时间元素
        out.writeObject(time.getYear());
        out.writeObject(time.getMonthValue());
        out.writeObject(time.getDayOfMonth());
        out.writeObject(time.getHour());
        out.writeObject(time.getMinute());
        out.writeObject(time.getSecond());

    }

    @Serial
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject(); // 默认反序列化非瞬态字段

        // 反序列化 LocalDateTime
        int year = (int) in.readObject();
        int month = (int) in.readObject();
        int day = (int) in.readObject();
        int hour = (int) in.readObject();
        int minute = (int) in.readObject();
        int second = (int) in.readObject();
        time = LocalDateTime.of(year, month, day, hour, minute, second);

    }
}
