package com.self.FileAndIo.SetOut;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class SetOutDemo {
    public static void main(String[] args) {
        try (
                PrintStream ps = new PrintStream(new FileOutputStream("day17-file io\\src\\com\\self\\FileAndIo\\SetOut\\222.txt", true), true)
        ) {
            System.setOut(ps);
            System.out.println("今年的top1是donk");
            System.out.println("今年的top2是monesy");
            System.out.println("今年的top3是ZywOo");
        }catch (Exception e) {
            e.getStackTrace();
        }
    }
}
