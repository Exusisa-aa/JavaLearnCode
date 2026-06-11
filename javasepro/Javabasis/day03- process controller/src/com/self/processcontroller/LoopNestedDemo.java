package com.self.processcontroller;

public class LoopNestedDemo {
    public static void main(String[] args) {
        //嵌套循环
        for (int i = 1;i <= 5;i++){
            for(int a = 1;a <= 5;a += 1){
                System.out.println("25c");
            }
        }
        for (int i = 1;i <= 5;i++){
            for(int a = 1;a <= 5;a += 1){
                System.out.print("25c");
            }
        }
        for (int i = 1;i <= 5;i++){
            for(int a = 1;a <= 5;a += 1){
                System.out.println("25c");
                System.out.println("\n");
            }
        }
        for (int i = 1;i <= 5;i++){
            System.out.println("\n");
            for(int a = 1;a <= 5;a += 1){
                System.out.println("25c");
            }
        }
        for (int i = 1;i <= 5;i++){
            System.out.print("\n");
            for(int a = 1;a <= 5;a += 1){
                System.out.print("25c");
            }
        }
    }
}
