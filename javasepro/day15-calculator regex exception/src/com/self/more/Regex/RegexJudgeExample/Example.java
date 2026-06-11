package com.self.more.Regex.RegexJudgeExample;

import java.util.Scanner;

public class Example {
    public static void main(String[] args) {
//        checkPhone();
//        checkEmail();
        checkTime();
    }

    public static void checkPhone() {
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("请输入手机或座机号码：");
            String phoneNumber = sc.nextLine();
            // 15384238051 010-62611963 0101561616232
            if (phoneNumber.matches("(1[3-9]\\d{9})|(0\\d{2,7}-?[1-9]\\d{4,19})")){
                System.out.println("您输入号码正确");
                break;
            }else {
                System.out.println("您输入的号码错误");
            }
        }
    }

    public static void checkEmail() {
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("请输入邮箱号：");
            String phoneNumber = sc.nextLine();
            // 2447439574@qq.com 2447439574@itcast.com.cn chen@gmail.com
            if (phoneNumber.matches("\\w{2,}@\\w{2,20}(\\.\\w{2,10}){1,2}")){
                System.out.println("您输入邮箱号正确");
                break;
            }else {
                System.out.println("您输入的邮箱号错误");
            }
        }
    }

    public static void checkTime() {
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("请输入时间：");
            String time = sc.nextLine();
            // 00:00:00 - 23:59:59
            if(time.startsWith("0") || time.startsWith("1")){
                if (time.matches("[0-1][0-9]:[0-5][0-9]:[0-5][0-9]")){
                    System.out.println("您输入的时间正确");
                    break;
                } else {
                    System.out.println("您输入时间错误");
                }
            } else if (time.startsWith("2")) {
                if (time.matches("2[0-3]:[0-5][0-9]:[0-5][0-9]")) {
                    System.out.println("您输入的时间正确");
                    break;
                }else {
                    System.out.println("您输入时间错误");
                }
            }else {
                System.out.println("您输入的时间有误");
            }
        }
    }
}
