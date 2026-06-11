package com.self.method;
import java.util.Scanner;
public class ParameterPracticeDemo2 {
    public static void main(String[] args) {
        //判断两个数值是否相同，相同则输出true，不同则输出false
        Scanner sc = new Scanner(System.in);
        int[] arr1 = new int[5];
        for (int i = 0; i < arr1.length; i++) {
            System.out.println("请输入第1组第" + (i + 1) + "号的数字：");
            int s = sc.nextInt();
            arr1[i] = s;
        }

        int[] arr2 = new int[5];
        for (int i = 0; i < arr2.length; i++) {
            System.out.println("请输入第2组第" + (i + 1) + "号的数字：");
            int ss = sc.nextInt();
            arr2[i] = ss;
        }

        boolean g =judge(arr1,arr2);
        System.out.println(g);

    }

    public static boolean judge(int[] arr3, int[] arr4){
        if(arr3 == null && arr4 == null){
            return true;//保险
        }


        if(arr3 == null || arr4 == null){
            return false;//保险
        }


        if(arr3.length != arr4.length) {
            return false;
        }
                         //层层拦截的形式看起来会更加有条理

        for (int i = 0; i < arr3.length; i++) {
            if(arr3[i] != arr4[i]){
                return false;//不用变量去记住true或false  直接return结果就好 结果返回给g
            }
        }
        return true;//由于只有两种情况  没有不相等的参数，故跳过if分支执行这里
    }
}
