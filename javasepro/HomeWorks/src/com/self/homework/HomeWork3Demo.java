package com.self.homework;

public class HomeWork3Demo {
    public static void main(String[] args) {
        int sum = 0;
        int count = 0;
        int temp = 1;
        while (true){
            sum = sum + temp;
            count++;
            temp = temp + count*3;
            if (sum > 1000){
                break;
            }
        }
        System.out.println("最后结果为" + sum);
        System.out.println("一共加了" + count + "次");
    }
}
