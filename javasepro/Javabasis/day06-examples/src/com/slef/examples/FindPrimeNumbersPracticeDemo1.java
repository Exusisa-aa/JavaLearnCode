package com.slef.examples;

public class FindPrimeNumbersPracticeDemo1 {
    public static void main(String[] args) {
        System.out.println(findPrimeNumbers(0, 300));
        System.out.println(findPrimeNumber(0, 300));



        String code = "";
        int sum = 0;
        for (int i = 0; i <=300; i++) {
            if(v(i)){
                sum += 1;
                code = code + i + "\t";
            }
        }
        System.out.println("一共有质数：" + sum + "个");
        System.out.println(code);
    }

    public static String findPrimeNumbers(int number0,int number1){ //我的方法
        String code = "";
        int sum = 0;
        for (int i = number0; i <= number1; i++) {
            for (int j = 2; j <= i ; j++) {
                if(i == 2){
                    sum += 1;
                    code = code + 2 + "\t";
                    break;
                } else if (i % j == 0) {
                    break;
                } else if (j == i - 1) {
                    sum += 1;
                    code = code + i + "\t";
                    break;
                }
            }
        }
        System.out.println("一共有质数：" + sum + "个");
        return code;
    }


    public static String findPrimeNumber(int number0,int number1){  //黑马的方法
        String code = "";
        int sum = 0;
        for (int i = number0; i <= number1; i++) {
            boolean flag = true;
            for (int j = 2; j < i ; j++) {
                if(i % j ==0){
                    flag = false;
                    break;
                }
            }
            if(i == 0 || i == 1){
                flag = false;
            } else if (i ==2) {
                sum += 1;
                code = code + 2 + "\t";
            } else if (flag) {
                sum += 1;
                code = code + i + "\t";
            }
        }
        System.out.println("一共有质数：" + sum + "个");
        return code;
    }
    public static boolean v(int number){
        for (int i = 2; i < number; i++) {
            if(number % i == 0){
                return false;
            }
        }
        if(number == 0 || number == 1){
            return false;
        } else if (number == 2) {
         return true;
        }
        return true;
    }
}
