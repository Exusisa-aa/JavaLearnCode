package com.slef.examples;

public class ArrayCopyDemo {
    //一个整型数组为11,22,33，拷贝成一个一摸一样的数组出来
    public static void main(String[] args) {
        int[] arr ={11,22,33,44};
        int[] copyArr = copy(arr);
        print(copyArr);
    }

    public static int[]copy(int[] arr){
        int[] copyArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            copyArr[i] = arr[i];
        }
        return copyArr;
    }


    public static void print(int[] number){
        System.out.print("[");
        for (int i = 0; i < number.length; i++) {
            System.out.print(i == number.length - 1 ? number[i] : number[i] + ",");
        }
        System.out.print("]");
    }

//    public static void print(int[] number){
//        System.out.print("[");
//        for (int i = 0; i < number.length; i++) {
//            if (i < number.length - 1) {
//                System.out.print(number[i] + ",");
//            }else{
//                System.out.print(number[i]);
//            }
//        }
//        System.out.print("]");
//    }
}
