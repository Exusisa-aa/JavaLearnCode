package com.self.cinema.WorkerManage.Workers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.self.cinema.WorkerManage.WorkDays.WorkDay;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Worker implements Serializable,WorkerJob{
    //单人锁对象，锁的是个人的数据
    private transient Lock lock = new ReentrantLock(); // transient避免序列化

    private static final ObjectMapper mapper = new ObjectMapper();//jackson依赖
    @Serial
    private static final long serialVersionUID = 1L;
    protected String workType;//工作类型 输入
    protected String workCode;//工号 输入
    protected String name;//姓名 输入
    protected String gender;//性别 输入
    protected String phone;//电话 输入
    protected String password;//密码 输入
    protected double salary;//薪水 输入
    protected List<WorkDay> workDays = new ArrayList<>();//员工工作日期
    protected final LinkedHashMap<Integer,String> leaveApplications = new LinkedHashMap<>();//请假记录


    public Worker() {
    }

    public Worker(String workType, String workCode, String name, String gender, String phone, String password, double salary) {
        this.workType = workType;
        this.workCode = workCode;
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.password = password;
        this.salary = salary;
    }

    public void printWorkInfo() {

        System.out.println("工号:" + workCode + "\n" +
                "职位:" + workType + "\n" +
                "姓名:" + name + "\n" +
                "性别:" + gender + "\n" +
                "电话:" + phone + "\n" +
                "薪水:" + salary);
        workDays.forEach(workDay -> {
            if(!workDay.isLeave()){
                System.out.println(workDay);
            }else {
                System.out.println("工作日期:" +  workDay.getWorkDate());
                System.out.println("已请假~~~" + "\n");
            }
        });
    }

    public String getWorkCode() {
        return workCode;
    }

    public List<WorkDay> getWorkDays() {
        return workDays;
    }

    public String getWorkType() {
        return workType;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LinkedHashMap<Integer, String> getLeaveApplications() {
        return leaveApplications;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Lock getLock() {
        return lock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false; // 先比较父类(Map)的内容

        Worker worker = (Worker) o;
        return Double.compare(worker.salary, salary) == 0 &&
                Objects.equals(workType, worker.workType) &&
                Objects.equals(workCode, worker.workCode) &&
                Objects.equals(name, worker.name) &&
                Objects.equals(gender, worker.gender) &&
                Objects.equals(phone, worker.phone) &&
                Objects.equals(password, worker.password) &&
                Objects.equals(workDays, worker.workDays);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                super.hashCode(),    // 包含父类(Map)的哈希
                workType,
                workCode,
                name,
                gender,
                phone,
                password,
                salary,
                workDays
        );
    }

    public String getGender() {
        return gender;
    }

    public String getPhone() {
        return phone;
    }

    public double getSalary() {
        return salary;
    }

    @Serial
    private void writeObject(ObjectOutputStream oos) throws IOException {
        // 1. 默认序列化非transient/非static字段
        oos.defaultWriteObject();
        // 2. 单独序列化leaveApplications
        String json = mapper.writeValueAsString(leaveApplications);
        oos.writeObject(json);
    }

    @Serial
    private void readObject(ObjectInputStream ois)
            throws IOException, ClassNotFoundException {
        // 1. 默认反序列化非transient/非static字段
        ois.defaultReadObject();
        // 2. 反序列化leaveApplications
        String json = (String) ois.readObject();
        LinkedHashMap<Integer, String> map = mapper.readValue(json,
                new TypeReference<LinkedHashMap<Integer, String>>() {});
        leaveApplications.clear();
        leaveApplications.putAll(map);
        // 重建锁对象
        lock = new ReentrantLock();
    }
}
