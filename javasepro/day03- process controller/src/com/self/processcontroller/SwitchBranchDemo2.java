package com.self.processcontroller;
import java.util.Scanner;
public class SwitchBranchDemo2 {
    public static void main(String[] args) {
        //switch的使用方法  利用穿透性
        /*
        周一：埋头苦干，解决bug            周二：埋头苦干，解决bug          周三：埋头苦干，解决bug
        周四：埋头苦干，解决bug    周五：今晚lol                  周六：埋头苦干，解决bug
        周天/日：郁郁寡欢，准备上班
         */
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您的星期信息：");
        String week =sc.next();
        switch (week) {
            case "周一" :
            case "周二" :
            case "周三" :
            case "周四" :
            case "周六" :
                System.out.println("埋头苦干，解决bug");
                break;
            case "周五" :
                System.out.println("今晚lol ");
                break;
            case "周天" :
            case "周日" :
                System.out.println("郁郁寡欢，准备上班");
                break;
            default:
                System.out.println("您输入的星期信息有误，请重新输入~~");
        }
        System.out.println("祝您一周过得愉快~~");
    }
}
