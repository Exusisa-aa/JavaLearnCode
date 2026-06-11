package com.slef.examples;

public class FindPrimeNumbersPracticeDemo3 {
    public static void main(String[] args) {
        System.out.println(primeNumber(0, 300));
        System.out.println(prime(0, 300));

        int m = 0;
        int n = 300;
        int sum = 0;
        String code = "";
        for (int i = m; i <= n; i++) {
            if(v(i)){
                sum += 1;
                code = code + i + "\t";
            }
        }
        System.out.println("质数一共有：" + sum);
        System.out.println(code);
    }

    public static String primeNumber(int number0,int number1){
        int sum = 0;
        String code = "";
        for (int i = number0; i <= number1; i++) {
            for (int j = 2; j <= i; j++) {
                if(i == 2){
                    sum += 1;
                    code = code + 2 + "\t";
                    break;
                }else if (i % j == 0) {
                    break;
                }else if(j == i - 1){
                    sum += 1;
                    code = code + i + "\t";
                    break;
                }
            }
        }
        System.out.println("质数一共有：" + sum);
        return code;
    }

    public static String prime(int number0,int number1){
        int sum = 0;
        String code = "";
        for (int i = number0; i <= number1; i++) {
            boolean s = true;
            if(i == 0 || i == 1){
                s = false;
            }
            for (int j = 2; j < i; j++) {
                if(i % j == 0){
                    s = false;
                    break;
                }
            }
            if(s){
                sum += 1;
                code = code + i + "\t";
            }
        }
        System.out.println("质数一共有：" + sum);
        return code;
    }

    public static boolean v(int number){
        if(number == 0 || number == 1){
            return false;
        }else if (number == 2){
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
