package com.self.more.Calculator;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {20,16,31,541,654,6,4,65,26,84,624};
        int temp;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if(array[j] > array[j+1]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
