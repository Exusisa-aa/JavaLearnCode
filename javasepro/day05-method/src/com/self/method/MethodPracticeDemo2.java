package com.self.method;

public class MethodPracticeDemo2 {
    public static void main(String[] args) {
        int f =sum(10,20,30);
        System.out.println(f);


        number(21);



        print();

    }
    public static int sum(int a,int b,int c){
        int d =a*b*c;
        return d;
    }

    public static void number(int a){
         if(a % 2 == 1){
             System.out.println(a + "为奇数");
         }else if(a == 0){
             System.out.println(a + "既不是奇数也不是偶数");
         } else if (a % 2 == 0) {
             System.out.println(a + "为偶数");
         }
    }

    public static void print(){
        for (int i = 1; i <= 5; i++) {
            System.out.println("打印五次");
        }
    }
}
