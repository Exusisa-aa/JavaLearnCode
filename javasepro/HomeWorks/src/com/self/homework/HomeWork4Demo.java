package com.self.homework;
import java.util.Random;

public class HomeWork4Demo {
    public static void main(String[] args) {
        Random r = new Random();
        int[] scores = new int[r.nextInt(20)+1];
        System.out.print("随机输入：");
        for (int i = 0; i < scores.length; i++) {
            System.out.print((scores[i] = r.nextInt(101)) + "\t");
        }
        System.out.println("\t");
        int[] frequency = {0,0,0,0,0,0,0,0,0,0};
        for (int i = 0; i < scores.length; i++) {
            int start = 0;
            int end = 9;
            for (int j = 0; j < frequency.length; j++) {
                    if(scores[i] >= start && scores[i] <= end){
                        frequency[j] += 1;
                        break;
                    }
                    start += 10;
                    end += 10;
                    if(start == 90 && scores[i] == 100){
                        frequency[frequency.length-1] += 1;
                    }
                }
            }

        System.out.print("输出结果为：");
        System.out.print("{");
        for (int i = 0; i < frequency.length; i++) {
            System.out.print(i == frequency.length-1? frequency[i] : frequency[i] + " ");
        }
        System.out.print("}");
    }
}
