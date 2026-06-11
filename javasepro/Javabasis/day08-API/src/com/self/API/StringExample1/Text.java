package com.self.API.StringExample1;

public class Text {
    public static void main(String[] args) {
        Login login = new Login();
        login.setUser("itheima");
        login.setPassword("123456");
        System.out.println("----------------------系统登录界面----------------------");
        LoginOperators operator = new LoginOperators(login);
        operator.LoginIn();
    }
}
