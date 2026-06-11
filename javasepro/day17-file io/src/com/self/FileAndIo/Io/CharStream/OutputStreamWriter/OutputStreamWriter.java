package com.self.FileAndIo.Io.CharStream.OutputStreamWriter;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.Writer;

public class OutputStreamWriter {
    public static void main(String[] args) {
        try (
                OutputStream os = new FileOutputStream("day17-file io\\src\\com\\self\\FileAndIo\\Io\\CharStream\\OutputStreamWriter\\22.txt",true);
                Writer osw = new java.io.OutputStreamWriter(os, "GBK");
                BufferedWriter bw = new BufferedWriter(osw, 8192 * 2)
        ) {
            bw.write("今年的top1是donk");
            bw.newLine();
            bw.write("今年的top2是monesy");
            bw.newLine();
            bw.write("今年的top3是zywoo");
            bw.newLine();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
