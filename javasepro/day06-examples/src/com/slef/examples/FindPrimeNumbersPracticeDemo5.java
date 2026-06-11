package com.slef.examples;

public class FindPrimeNumbersPracticeDemo5 {
    public static void main(String[] args) {
        System.out.println(primeNumber(0, 300));
        System.out.println(prime(0, 300));

        String code = "";
        int sum = 0;
        for (int i = 0;i <= 300;i++) {
            if(v(i)){
                code = code + i + "\t";
                sum += 1;
            }
        }
        System.out.println("一共有质数" + sum + "个");
        System.out.println(code);
    }

    public static String primeNumber(int number0,int number1){
        String code = "";
        int sum = 0;
        for (int i = number0; i <= number1; i++) {
            for (int j = 2; j <= i; j++) {
                if(i == 2){
                    code = code + i + "\t";
                    sum += 1;
                } else if (i % j == 0) {
                    break;
                } else if (j == i - 1) {
                    code = code + i + "\t";
                    sum += 1;
                }
            }
        }
        System.out.println("一共有质数" + sum + "个");
        return code;
    }

    public static String prime(int number0,int number1){
        String code = "";
        int sum = 0;
        for (int i = number0; i <= number1; i++) {
            boolean r = true;
            if(i == 0 || i == 1){
                r = false;
            }
            for (int j = 2; j < i; j++) {
                if(i % j == 0){
                    r = false;
                    break;
                }
            }
            if(r){
                code = code + i + "\t";
                sum += 1;
            }
        }
        System.out.println("一共有质数" + sum + "个");
        return code;
    }

    public static boolean v(int number){
        if(number == 0 || number ==1){
            return false;
        } else if (number == 2) {
            return true;
        }
        for (int i = 2; i < number ; i++) {
            if (number % i == 0){
                return false;
            }
        }
        return true;
    }
}
