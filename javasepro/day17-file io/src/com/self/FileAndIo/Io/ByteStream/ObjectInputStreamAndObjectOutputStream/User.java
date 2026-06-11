package com.self.FileAndIo.Io.ByteStream.ObjectInputStreamAndObjectOutputStream;

import java.io.Serializable;

public class User implements Serializable {
    private String userName;
    private int age;
    private transient String password;

    public User() {
    }

    public User(String userName, int age, String password) {
        this.userName = userName;
        this.age = age;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                '}';
    }
}
