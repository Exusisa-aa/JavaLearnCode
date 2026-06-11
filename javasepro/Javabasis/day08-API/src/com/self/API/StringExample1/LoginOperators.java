package com.self.API.StringExample1;
import java.util.Scanner;

public class LoginOperators {
    Login login;

    public LoginOperators(){

    }

    public LoginOperators(Login login){
        this.login = login;
    }

    public void LoginIn(){
        int count = 0;
        while (count <= 3){
            Scanner sc = new Scanner(System.in);
            System.out.print("请输入账号：");
            String user = sc.next();
            System.out.print("请输入密码：");
            String password = sc.next();
            if(this.login.getUser().equals(user) && this.login.getPassword().equals(password)){
                System.out.println("登陆成功，欢迎~~");
                break;
            } else if (count  == 2) {
                System.out.println("为了您的账号安全，请过一段时间再尝试");
                break;
            } else {
                count++;
                System.out.println("您输入有误," + "还剩" + (3 - count) + "次机会");
            }
        }
    }
}
