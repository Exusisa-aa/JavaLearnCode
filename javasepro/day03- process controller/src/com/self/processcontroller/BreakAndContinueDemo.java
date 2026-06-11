package com.self.processcontroller;

public class BreakAndContinueDemo {
    public static void main(String[] args) {
        //break
        for (int i = 1;i <=5;i++){
            if (i == 3){
                break;
            }
            System.out.println("break" + i);
        }
        //continue
        for (int i = 1;i <=5;i++){
            if (i == 3){
                continue;
            }
            System.out.println("continue" + i);
        }
    }
}
