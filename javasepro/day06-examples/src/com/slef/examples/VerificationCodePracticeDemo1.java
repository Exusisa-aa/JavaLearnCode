package com.slef.examples;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
public class VerificationCodePracticeDemo1 {
    public static void main(String[] args) {
        vc(6);

    }


    public static void vc(int n){
        Scanner sc = new Scanner(System.in);
        System.out.println("您的验证码为：");
        String code = "";
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            int rr = r.nextInt(3);
            switch (rr){
                case 0:
                    int r1 = r.nextInt(10);
                    code += r1;
                    break;
                case 1:
                    int r2 = r.nextInt(26)+65;
                    char r22= (char)r2;
                    code += r22;
                    break;
                case 2:
                    int r3 = r.nextInt(26)+97;
                    char r33 = (char)r3;
                    code += r33;
                    break;
            }
        }
        System.out.println(code);
        while(true){
            System.out.println("请输入您的验证码：");
            String v = sc.next();
            if(Objects.equals(v, code)){
                System.out.println("验证通过");
                break;
            }else{
                System.out.println("您输入的验证码有误，请重新输入：");
            }
        }
    }
}