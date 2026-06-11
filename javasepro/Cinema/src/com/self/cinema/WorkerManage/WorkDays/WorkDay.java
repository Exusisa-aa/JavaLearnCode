package com.self.cinema.WorkerManage.WorkDays;




import com.self.cinema.WorkerManage.WorkDays.WorkTimes.WorkTime;

import java.io.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Objects;

public class WorkDay implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L; // 必须添加
    protected LocalDate workDate;//工作日期 自适应
    protected boolean isLeave;//是否请假
    protected final LinkedHashSet<WorkTime> workTimes = new LinkedHashSet<>();//具体工作时间

    public WorkDay(LocalDate workDate, boolean isLeave) {
        this.workDate = workDate;
        this.isLeave = isLeave;
    }

    public WorkDay() {
    }

    @Override
    public String toString() {
        return "工作日期:" + workDate + '\n' +
                "具体工作时间:" + '\n' + workTimes + '\n';
    }

    public LinkedHashSet<WorkTime> getWorkTimes() {
        return workTimes;
    }

    public LocalDate getWorkDate() {
        return workDate;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkDay workDay = (WorkDay) o;
        return isLeave == workDay.isLeave && Objects.equals(workDate, workDay.workDate) && Objects.equals(workTimes, workDay.workTimes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(workDate, isLeave, workTimes);
    }

    // 添加自定义序列化逻辑
    @Serial
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeObject(workDate.toString()); // 序列化 LocalDate 为字符串
        out.writeBoolean(isLeave);
    }

    @Serial
    private void readObject(ObjectInputStream in)
            throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        String dateStr = (String) in.readObject();
        workDate = LocalDate.parse(dateStr); // 反序列化字符串为 LocalDate
        isLeave = in.readBoolean();

    }


    public boolean isLeave() {
        return isLeave;
    }

    public void setLeave(boolean leave) {
        isLeave = leave;
    }
}
