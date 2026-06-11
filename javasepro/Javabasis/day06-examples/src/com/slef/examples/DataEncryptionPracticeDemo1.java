package com.slef.examples;

public class DataEncryptionPracticeDemo1 {
    public static void main(String[] args) {
        System.out.println(encryption(4567));
    }

    public static String encryption(int number){
        String date = "";
        int[] numbers =spilt(number);
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (numbers[i] + 5) % 10;
        }
        reverse(numbers);
        for (int i = 0; i < numbers.length; i++) {
            date += numbers[i];
        }
        return date;
    }

    public static void reverse(int[] numbers){
        for (int i = 0,j = numbers.length - 1; i < j; i++,j--) {
            int temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
        }
    }

    public static int[] spilt(int number){
        int[] spiltnumber = new int[4];
        spiltnumber[0] = number / 1000;
        spiltnumber[1] = (number / 100) % 10;
        spiltnumber[2] = (number / 10) % 10;
        spiltnumber[3] = number % 10;
        return spiltnumber;
    }
}
