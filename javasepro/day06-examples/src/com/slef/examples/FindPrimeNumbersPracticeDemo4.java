package com.slef.examples;

public class FindPrimeNumbersPracticeDemo4 {
    public static void main(String[] args) {
        primeNumbers(0,300);
        prime(0,300);

        int sum = 0;
        String code = "";
        for (int i = 0; i <= 300; i++) {
            if(judge(i)) {
                sum += 1;
                code = code + i + "\t";
            }
        }
        System.out.println("质数一共有" + sum + "个:");
        System.out.println(code);
    }

    public static void primeNumbers(int number0,int number1){
        int sum = 0;
        String code = "";
        for (int i = number0; i <= number1; i++) {
            for (int j = 2; j <= i; j++) {
                if(i == 2){
                    sum += 1;
                    code = code + i + "\t";
                    break;
                } else if (i % j == 0) {
                    break;
                }else if(j == i - 1){
                    sum += 1;
                    code = code + i + "\t";
                    break;
                }
            }
        }
        System.out.println("质数一共有" + sum + "个:");
        System.out.println(code);
    }

    public static void prime(int number0,int number1){
        int sum = 0;
        String code = "";
        for (int i = number0; i <= number1; i++) {
            boolean flag = true;
            if(i == 1 || i ==0){
                flag = false;
            }
            for (int j = 2; j < i; j++) {
                if(i % j == 0){
                    flag =false;
                    break;
                }
            }
            if(flag){
                sum += 1;
                code = code + i + "\t";
            }
        }
        System.out.println("质数一共有" + sum + "个:");
        System.out.println(code);
    }

    public static boolean judge(int number){
        if(number == 0 || number == 1){
            return false;
        } else if (number == 2) {
            return true;
        }
        for (int i = 2; i < number; i++) {
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }
}
