package com.slef.examples;

public class FindPrimeNumbersPracticeDemo2 {
    public static void main(String[] args) {
        System.out.println(primeNumbers(0,300));
        System.out.println(prime(0, 300));

        int sum = 0;
        String code = "";
        for (int i = 0;i <= 300; i++) {
            if(v(i)){
                sum += 1;
                code = code + i + "\t";
            }
        }
        System.out.println("一共有质数：" + sum);
        System.out.println(code);
    }

    public static String primeNumbers(int number0,int number1){
        String code = "";
        int sum = 0;
        for (int i = number0; i <= number1; i++) {
            for (int j = 2; j <= i; j++) {
                        if(i == 2) {
                            sum += 1;
                            code = code + i + "\t";
                            break;
                        }else if(i % j == 0){
                           break;
                        }else if (j == i - 1) {
                            sum += 1;
                            code = code + i + "\t";
                            break;
                        }
            }
        }
        System.out.println("一共有质数：" + sum);
        return code;
    }

    public static String prime(int number0,int number1){
        String code = "";
        int sum = 0;
        for (int i = number0; i <= number1; i++) {
            boolean flag = true;
            if(i == 0 || i == 1){
                flag = false;
            }
            for (int j = 2; j < i; j++) {
                if (i % j ==0) {
                    flag = false;
                    break;
                }
            }
            if(flag){
                sum += 1;
                code = code + i + "\t";
            }
        }
        System.out.println("一共有质数：" + sum);
        return code;
    }

    public static boolean v(int number){
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
