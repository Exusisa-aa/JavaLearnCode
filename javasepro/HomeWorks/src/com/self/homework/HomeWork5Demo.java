package com.self.homework;
import java.util.Random;
import java.util.Scanner;

public class HomeWork5Demo {
    public static void main(String[] args) {
        int[][] matrix = print1();
        System.out.println("---------------------------------------");
        matrix = print2(matrix);
        System.out.println("---------------------------------------");
        print3(matrix);
    }

    public static int[][] print1(){
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        System.out.print("请输入设置几乘几的数组：");
        int number = sc.nextInt();
        int[][] matrix = new int[number][number];
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                System.out.print((matrix[i][j] = r.nextInt(100)+1) + "\t");
            }
            System.out.println("\t");
        }
        return matrix;
    }

    public static int[][] print2(int[][] matrix){
        int remember = 0;
        for (int i = 0; i < matrix.length; i++) {
            int max = matrix[i][0];
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] >= max){
                    max = matrix[i][j];
                    remember = j;
                }
            }
            int temp = matrix[i][i];
            matrix[i][i] = max;
            matrix[i][remember] = temp;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println("\t");
        }
        return matrix;
    }
    
    public static void print3(int[][] matrix){
        int min;
        int[] tempArray = new int[matrix.length];
        int[] finalArray = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            tempArray[i] = matrix[i][i];
        }
        int temp = 0;
        while (temp < tempArray.length) {
            int remember = 0;
            min = 101;
            for (int i = 0,j = 0; i < tempArray.length; i++,j++) {
                if(tempArray[i] < min){
                    min = tempArray[i];
                    remember = i;
                }
            }
            tempArray[remember] = 101;
            finalArray[temp] = min;
            temp++;
        }

        for (int i = 0; i < matrix.length; i++) {
            matrix[i][i] = finalArray[i];
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println("\t");
        }
    }
}
