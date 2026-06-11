package com.self.method;
public class MethodPracticeDemo1 {
    public static void main(String[] args) {
        int sum0 = sum(100);
        System.out.println("1-n的和是：" + sum0);
        System.out.println("==================================");
        number(100);
    }
    //求1-n的和
    public static int sum(int n){
        int c = 0;
        for (int i = 1; i <= n; i++) {
            c += i;
        }
        return c;
    }

    //判断一个整型是奇数还是偶数，并把它输出出来
    public static void number(int a) {
        if(a % 2 == 1){
            System.out.println("此数为基数，且值为：" + a);
        } else if (a == 0){
            System.out.println("此数既不是基数也不是偶数，为0");
        } else if (a % 2 == 0) {
        System.out.println("此数为偶数，且值为：" + a);
        }
    }
}


