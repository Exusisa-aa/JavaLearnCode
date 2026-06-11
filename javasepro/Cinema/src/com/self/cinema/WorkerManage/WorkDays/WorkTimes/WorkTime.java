package com.self.cinema.WorkerManage.WorkDays.WorkTimes;


import java.io.*;
import java.time.LocalTime;

public class WorkTime implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    protected LocalTime startWorkTime;//上班时间 自适应
    protected LocalTime endWorkTime;//下班时间 自适应
    protected String workHall;

    public WorkTime(LocalTime startWorkTime, LocalTime endWorkTime, String workHall) {
        this.startWorkTime = startWorkTime;
        this.endWorkTime = endWorkTime;
        this.workHall = workHall;
    }

    public LocalTime getStartWorkTime() {
        return startWorkTime;
    }

    public LocalTime getEndWorkTime() {
        return endWorkTime;
    }

    public String getWorkHall() {
        return workHall;
    }



    @Override
    public String toString() {
        return "地点:" + workHall + '\n' +
                "上班时间:" + startWorkTime + '\n' +
                "下班时间:" + endWorkTime + '\n';
    }

    // 添加自定义序列化逻辑
    @Serial
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeObject(startWorkTime.toString()); // 序列化 LocalTime 为字符串
        out.writeObject(endWorkTime.toString());
    }

    @Serial
    private void readObject(ObjectInputStream in)
            throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        startWorkTime = LocalTime.parse((String) in.readObject());
        endWorkTime = LocalTime.parse((String) in.readObject());

    }




}
