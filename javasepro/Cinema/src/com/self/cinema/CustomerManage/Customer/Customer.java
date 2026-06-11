package com.self.cinema.CustomerManage.Customer;

import com.self.cinema.CustomerManage.Feedbacks.Feedback;
import com.self.cinema.CustomerManage.Records.Record;

import java.io.*;
import java.net.InetAddress;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Customer implements Serializable {
    //单人锁对象，锁的是个人的数据
    private transient Lock lock = new ReentrantLock(); // transient避免序列化

    @Serial
    private static final long serialVersionUID = 3L; // 必须添加
    private String UUID;// UUID
    private String name;// 姓名
    private String gender;// 性别
    private String phone;// 电话
    private String userName;// 用户名
    private String password;// 密码
    private double money;
    private InetAddress ip;//ip
    private LinkedHashMap<String, Feedback> comment = new LinkedHashMap<>();//评论 (电影名，内容)
    private LinkedHashSet<String> friends = new LinkedHashSet<>();//好友 存的是UUID
    private LinkedHashSet<Record> records = new LinkedHashSet<>();//电影记录


    public void setIp(InetAddress ip) {
        this.ip = ip;
    }

    public String getGender() {
        return gender;
    }

    public String getPhone() {
        return phone;
    }

    public double getMoney() {
        return money;
    }

    public String getUUID() {
        return UUID;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public LinkedHashMap<String, Feedback> getComment() {
        return comment;
    }

    public LinkedHashSet<String> getFriends() {
        return friends;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public InetAddress getIp() {
        return ip;
    }

    public LinkedHashSet<Record> getRecords() {
        return records;
    }

    public Lock getLock() {
        return lock;
    }

    public void setLock(Lock lock) {
        this.lock = lock;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setComment(LinkedHashMap<String, Feedback> comment) {
        this.comment = comment;
    }

    public void setFriends(LinkedHashSet<String> friends) {
        this.friends = friends;
    }

    public void setRecords(LinkedHashSet<Record> records) {
        this.records = records;
    }

    //供测试用
    public Customer(InetAddress ip, double money, String password, String userName, String phone, String gender, String name, String UUID) {
        this.ip = ip;
        this.money = money;
        this.password = password;
        this.userName = userName;
        this.phone = phone;
        this.gender = gender;
        this.name = name;
        this.UUID = UUID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Double.compare(money, customer.money) == 0 && Objects.equals(lock, customer.lock) && Objects.equals(UUID, customer.UUID) && Objects.equals(name, customer.name) && Objects.equals(gender, customer.gender) && Objects.equals(phone, customer.phone) && Objects.equals(userName, customer.userName) && Objects.equals(password, customer.password) && Objects.equals(ip, customer.ip) && Objects.equals(comment, customer.comment) && Objects.equals(friends, customer.friends) && Objects.equals(records, customer.records);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lock, UUID, name, gender, phone, userName, password, money, ip, comment, friends, records);
    }

    //自定义序列化
    @Serial
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();


        // 序列化 InetAddress -> 转为字节数组
        byte[] ipBytes = ip.getAddress();
        out.writeObject(ipBytes);
    }

    @Serial
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject(); // 默认反序列化非瞬态字段


        // 反序列化 InetAddress
        byte[] ipBytes = (byte[]) in.readObject();
        ip = InetAddress.getByAddress(ipBytes);

        // 重建锁对象
        lock = new ReentrantLock();
    }
}


