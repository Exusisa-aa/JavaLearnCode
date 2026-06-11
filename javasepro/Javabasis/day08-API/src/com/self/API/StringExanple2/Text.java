package com.self.API.StringExanple2;

public class Text {
    public static void main(String[] args) {
        Code code = new Code();
        code.setCode();
        CodeOperators operator = new CodeOperators(code);
        System.out.println("-----------------------验证码登录界面-------------------------");
        operator.YZM();
    }
}
