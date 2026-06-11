package com.self.array;

public class ArrayMaxAndMinDemo {
    //数组中找最值的使用
    public static void main(String[] args) {
        int[] array = {10,20,30,40,50};
        int max = array[0];
        for (int i = 1;i < array.length;i++){
            if(max < array[i]){
                max = array[i];
            }
        }
        System.out.println(max);


        int[] array0 = {10,20,30,40,50};
        int min = array[0];
        for (int i = 1;i < array.length;i++){
            if(min > array0[i]){
                min = array0[i];
            }
        }
        System.out.println(min);
    }
}
