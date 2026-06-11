package com.self.method;
import java.util.Scanner;
public class PracticeDemo1 {
    public static void main(String[] args) {
        //判断两个数组的数值是否相同，相同则输出true，不同则输出false
        Scanner sc = new Scanner(System.in);
        int[] arr1 = new int[5];
        int[] arr2 = new int[5];
        for (int i = 0; i < arr1.length; i++) {
            while(true){
                System.out.println("请输入第一组的第" + (i + 1) + "位数字");
                int s1 = sc.nextInt();
                arr1[i] = s1;
                if(s1 >= 0 && s1 <= 100){
                    System.out.println("请输入第一组的第" + (i + 1) + "位数字" + "为" + s1);
                    break;
                }else{
                    System.out.println("您输入的数字有误，请重新输入：");
                }
            }
        }
        for (int i = 0; i < arr2.length; i++) {
            while(true){
                System.out.println("请输入第二组的第" + (i + 1) + "位数字");
                int s2 = sc.nextInt();
                arr1[i] = s2;
                if(s2 >= 0 && s2 <= 100){
                    System.out.println("请输入第二组的第" + (i + 1) + "位数字" + "为" + s2);
                    break;
                }else{
                    System.out.println("您输入的数字有误，请重新输入：");
                }
            }
        }
        boolean a = judge(arr1,arr2);
        System.out.println(a);

    }


    public static boolean judge(int[] array1,int[] array2){
        if(array1 == null && array2 == null){
            System.out.println(array1);
            System.out.println(array2);
            return false;
        }

        if(array1 == null || array2 == null){
            System.out.println(array1);
            System.out.println(array2);
            return false;
        }




        for (int i = 0; i < array1.length; i++) {
            if(array1[i] != array2[i]);
            {
                return false;
        }
    }
        return true;
    }
}
