package com.self.cinema.CinemaManage;

public enum ManagerAccountMessage {
    MANAGER("admin123","123456");
    private final String userName;
    private final String password;

    ManagerAccountMessage(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
