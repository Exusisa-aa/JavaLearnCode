package com.self.array;

public class ArrayExchangeDemo {
    //数组的反转
    public static void main(String[] args) {
        int[] array = {10,20,30,40,50};
        for(int i = 0,j = array.length - 1; i < j; i++,j--){
            int temp = array[j];
            array[j] = array[i];
            array[i] = temp;
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
