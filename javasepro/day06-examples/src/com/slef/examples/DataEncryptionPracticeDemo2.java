package com.slef.examples;

public class DataEncryptionPracticeDemo2 {
    public static void main(String[] args) {
        System.out.println(DataEncryption(4567));

    }

    public static String DataEncryption(int number){
        int[] arr = spilt(number);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (arr[i] + 5) % 10;
        }
        reverse(arr);
            String code = "";
        for (int i = 0; i < arr.length; i++) {
            code += arr[i];
        }
        return code;
    }

    public static int[] spilt(int number){
        int[] numbers = new int[4];
        numbers[0] = number / 1000;
        numbers[1] = (number / 100) % 10;
        numbers[2] = (number / 10) % 10;
        numbers[3] = number % 10;
        return numbers;
    }

    public static void reverse(int[] arr){
        for (int i = 0,j = arr.length - 1; i < j; i++,j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
