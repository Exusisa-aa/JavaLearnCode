package com.self.FileAndIo.Io.CharStream.InputStreamReader;

import java.io.*;

public class InputStreamReaderDemo {
    public static void main(String[] args) {
        try (
                InputStream is = new FileInputStream("day17-file io\\src\\com\\self\\FileAndIo\\Io\\CharStream\\InputStreamReader\\22.txt");
                //字符输入转换流：把原始的字节输入流转成字符输入流，并指定字符集编码，再进行缓冲操作
                Reader isr = new InputStreamReader(is, "GBK");
                BufferedReader br = new BufferedReader(isr, 8192 * 2)
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
