package com.self.more.Calculator;

import java.util.Arrays;

public class ChooseSort {
    public static void main(String[] args) {
        int[] array = {20,16,31,541,654,6,4,65,26,84,624};
        int temp;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if(array[j] > array[i]){
                    temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
