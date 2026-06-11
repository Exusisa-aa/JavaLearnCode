package com.self.method;

public class ParameterPracticeDemo1 {
    public static void main(String[] args) {
        //需求；打印出[11,22,33,44,55]
            int[] array1={11,22,33,44,55};
            arr1(array1);


            int[] array2=null;
            arr1(array2);//此时改变了堆内存中的数组，会报空指令异常的错误，以防出现这样的问题，在arr1方法中做个保险


            int[] array3={};
            arr1(array3);
    }
    public static void arr1(int[] array ){
        if(array == null){
            System.out.println(array);
            return;
        }






        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
//            if(i < array.length - 1){
//                System.out.print(array[i] + ",");
//            }else{
//                System.out.print(array[i] + "]");
//            }                //过于繁琐
            System.out.print(i == array.length - 1 ? array[i] : array[i] + ",");
        }
        System.out.println("]");
    }
}
