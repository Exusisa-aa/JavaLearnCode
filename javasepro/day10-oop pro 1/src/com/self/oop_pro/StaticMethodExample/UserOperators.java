package com.self.oop_pro.StaticMethodExample;
import java.util.Objects;
import java.util.Scanner;

public class UserOperators {
    private User user;

    public UserOperators() {
    }

    public UserOperators(User user) {
        this.user = user;
    }

    public void login(){
        while (true) {
            Scanner sc = new Scanner(System.in);
            String codes = MyUtil.code(6);
            System.out.println(codes);
            System.out.println("请输入验证码：");
            String code = sc.next();
            if(Objects.equals(code,codes)){
                System.out.println("验证码输入正确,欢迎" + user.getNmae() + "登录");
                break;
            }else {
                System.out.println("验证码输入错误");
            }
        }
    }
}
