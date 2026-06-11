package com.self.FileAndIo.Io.CharStream.BufferedReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;

public class BufferedReaderDemo {
    public static void main(String[] args) {
        try (
                Reader fr = new FileReader("day17-file io\\src\\com\\self\\FileAndIo\\Io\\CharStream\\FileReader\\hh.txt");
                //用字符缓冲输入流包装原始流
                BufferedReader br = new BufferedReader(fr,8192*2)
        ) {
//            int len1;
//            while ((len1 = fr.read()) != -1){
//                System.out.print((char) len1);
//            }

//            int len2;
//            char[] buffer = new char[1024];
//            while ((len2 = br.read(buffer)) != -1){
//                String rs = new String(buffer,0,len2);
//                System.out.println(rs);
//            }

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }


        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
