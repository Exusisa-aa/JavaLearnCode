package com.self.more.Calculator;
import java.util.Arrays;
import java.util.Scanner;

public class TwoOfQuarterToFind {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        Arrays.sort(array);
        int max = array.length - 1;
        int min = 0;
        int mid = 0;
        boolean found = false;
        System.out.println("请输入您要查找的数：");
        int number = sc.nextInt();
        while (max >= min){
            mid = (max + min) / 2;
            if (number > array[mid]) {
                min = mid + 1;
            } else if (number < array[mid]) {
                max = mid - 1;
            } else if(number == array[mid]){
                found = true;
                break;
            }
        }
        if(found){
            System.out.println(number + "在第" + (mid+1) + "位");
        }else {
            System.out.println("没找到该数字");
        }
    }
}
