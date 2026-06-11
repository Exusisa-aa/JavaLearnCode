package com.slef.examples;
import java.util.Random;
public class VerificationCodeDemo {
    //开发一个程序，可以生成指定位数的验证码，每位可以是数字、大小写字母。
    public static void main(String[] args) {
        System.out.println(verificationCode(5));
    }


    public static String verificationCode(int n){
        String code = "";
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            int s = r.nextInt(3);
            switch (s){
                case 0:
                    int rr = r.nextInt(10);
                    code += rr;
                    break;
                case 1:
                    int rrr =r.nextInt(26)+65;//大写字母
                    char rrr1 = (char)rrr;
                    code += rrr1;
                    break;
                case 2:
                    int rrrr =r.nextInt(26)+97;//小写字母
                    char rrrr1 =(char)rrrr;
                    code += rrrr1;
                    break;
            }
        }
        return code;
    }
}
