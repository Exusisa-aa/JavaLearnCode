package com.self.array;
import java.util.Random;

public class TwoDimensionalPracticeDemo {
    public static void main(String[] args) {
        //n*n的二维数组并随机打乱数字的位置
        start(5);
    }

    public static void start(int number){
        int count = 1;
        int[][] array = new int[number][number];
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                array[i][j] = count++;
            }
        }

        for (int i = 0; i < array.length; i++) {
            for (int i1 = 0; i1 < array[i].length; i1++) {
                System.out.print(array[i][i1] + "\t");
            }
            System.out.println(" ");
        }

        System.out.println("================================");

        Random r = new Random();
        for (int j = 0; j < array.length;j++) {
            for (int i = 0; i < array[0].length; i++) {
                int index = r.nextInt(number);
                int temp = array[j][i];
                array[j][i] = array[index][index];
                array[index][index] = temp;
            }
        }
        for (int i = 0; i < array.length; i++) {
            for (int i1 = 0; i1 < array[i].length; i1++) {
                System.out.print(array[i][i1] + "\t");
            }
            System.out.println(" ");
        }
    }
}
