package com.slef.examples;

public class FindPrimeNumbersDemo {
    //判断101-200之间有多少个质数，并输出所有质数
    public static void main(String[] args) {
        System.out.println(primeNumbers(0,300));
        System.out.println(primeNumber(0,300));
    }


    public static String primeNumbers(int number0,int number1){  //我的
        int sum = 0;
        String code = "";
        for (int i = number0; i <= number1; i++) {
            for (int j = 2; j <= i; j++) {
                if(i == 2){
                    sum += 1;
                    code = code + 2 + " ";
                    break;
                }else if (i % j == 0){
                    break;
                }else if(j == i - 1){
                    sum += 1;
                    code = code + i + " ";
                    break;
                }
            }
        }
        System.out.println("一共有质数" + sum + "个");
        return code;
    }



    public static String primeNumber(int number0,int number1) {  //黑马
        int sum = 0;
        String code = "";
        for (int i = number0; i < number1; i++) {
            boolean flag = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if(i == 0 || i == 1){
                flag = false;
            }
            if (flag) {
                sum += 1;
                code = code + i + " ";
            }

        }
        System.out.println("一共有质数" + sum + "个");
        return code;
    }
}
