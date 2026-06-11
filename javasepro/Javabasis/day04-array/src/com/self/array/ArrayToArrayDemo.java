package com.self.array;

public class ArrayToArrayDemo {
    //多变量指向同一数组的使用
    public static void main(String[] args) {
        int[] array1 = {10,20,30,40,50};
        int[] array2 = array1;
        System.out.println(array1);
        System.out.println(array2);
        for (int i = 0; i < array1.length; i++) {
            System.out.println(array1[i]);
        }
        for (int i = 0; i < array2.length; i++) {
            System.out.println(array2[i]);
        }


        array2[0] = 99;
        array2[1] = 99;
        array2[2] = 99;
        array2[3] = 99;
        array2[4] = 99;


        System.out.println(array1);
        System.out.println(array2);

        for (int i = 0; i < array1.length; i++) {
            System.out.println(array1[i]);
        }
        for (int i = 0; i < array2.length; i++) {
            System.out.println(array2[i]);
        }
    }
}
