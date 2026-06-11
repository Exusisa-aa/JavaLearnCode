package com.slef.examples;
import java.util.Objects;
import  java.util.Random;
import java.util.Scanner;
public class VerificationCodePracticeDemo2 {
    public static void main(String[] args) {
        vc(5);
    }


    public static void vc(int n){
        String code = "";
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            int rr = r.nextInt(3);
            switch (rr){
                case 0:
                    int r0 = r.nextInt(10);
                    code += r0;
                    break;
                case 1:
                    int r1 = r.nextInt(26)+65;
                    char r11 = (char)r1;
                    code += r11;
                    break;
                case 2:
                    int r2 = r.nextInt(26)+97;
                    char r22 = (char)r2;
                    code += r22;
                    break;
            }
        }
        Scanner sc = new Scanner(System.in);

        System.out.println(code);
        while (true) {
            System.out.println("请输入验证码：");
            String c = sc.next();
            if(Objects.equals(c, code)){
                System.out.println("已通过验证");
                break;
            }else{
                System.out.println("您输入的验证码有误，请重新输入：");
            }
        }
    }
}
