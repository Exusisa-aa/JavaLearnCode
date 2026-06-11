package com.self.oop_pro.StaticMethodExample;

public class Text {
    public static void main(String[] args) {
        User user = new User("小明");
        UserOperators operator = new UserOperators(user);
        operator.login();
    }

}
