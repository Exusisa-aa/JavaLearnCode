package com.self.FileAndIo.Io.CharStream.PrintWriter;

import java.io.FileWriter;
import java.io.PrintWriter;


public class PrintWriterDemo {
    public static void main(String[] args) {
        try (
                PrintWriter pw = new PrintWriter(new FileWriter("day17-file io\\src\\com\\self\\FileAndIo\\Io\\CharStream\\PrintWriter\\222.txt", true), true)
        ) {
            pw.println("今年的top1是donk");
            pw.println("今年的top2是monesy");
            pw.println("今年的top3是ZywOo");
            pw.print(72);
            pw.println(" ");
            pw.write(72);
            pw.println(" ");
        }catch (Exception e) {
            e.getStackTrace();
        }
    }
}
