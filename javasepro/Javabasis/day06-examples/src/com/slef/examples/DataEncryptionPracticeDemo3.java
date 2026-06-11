package com.slef.examples;

public class DataEncryptionPracticeDemo3 {
    public static void main(String[] args) {
        System.out.println("加密后的数字为：" + DataEncryption(4567));
    }

    public static String DataEncryption(int numbers){
        String code = "";
        int[] number = spilt(numbers);
        for (int i = 0; i < number.length; i++) {
            number[i] = (number[i] + 5) % 10;
        }
        reverse(number);
        for (int i = 0; i < number.length; i++) {
            code = code + number[i] + "";
        }
        return code;
    }

    public static int[] spilt(int numbers){
        int[] number = new int[4];
        number[0] = numbers / 1000;
        number[1] = (numbers / 100) % 10;
        number[2] = (numbers / 10) % 10;
        number[3] = numbers % 10;
        return number;
    }

    public static void reverse(int[] number){
        for (int i = 0,j = number.length - 1; i < j; i++,j--) {
            int temp = number[i];
            number[i] = number[j];
            number[j] = temp;
        }
    }
}
