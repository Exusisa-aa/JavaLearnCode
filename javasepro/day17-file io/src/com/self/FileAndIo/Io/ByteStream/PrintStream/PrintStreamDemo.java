package com.self.FileAndIo.Io.ByteStream.PrintStream;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.nio.charset.Charset;

public class PrintStreamDemo {
    public static void main(String[] args) throws Exception{
        try (
                PrintStream ps = new PrintStream(new FileOutputStream("day17-file io\\src\\com\\self\\FileAndIo\\Io\\ByteStream\\PrintStream\\222.txt", true), true, Charset.forName("UTF-8"))
                //自动缓冲
        ) {
            ps.println("今年的top1是donk");
            ps.println("今年的top2是monesy");
            ps.println("今年的top3是ZywOo");
            ps.write(72);
            ps.println(" ");
            ps.print(72);
            ps.println(" ");
        }catch (Exception e) {
            e.getStackTrace();
        }
    }
}
