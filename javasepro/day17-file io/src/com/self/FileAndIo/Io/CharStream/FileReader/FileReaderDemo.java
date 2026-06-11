package com.self.FileAndIo.Io.CharStream.FileReader;

import java.io.FileReader;
import java.io.Reader;

public class FileReaderDemo {
    public static void main(String[] args) {
        try (
                Reader fr = new FileReader("day17-file io\\src\\com\\self\\FileAndIo\\Io\\CharStream\\FileReader\\hh.txt")
        ) {
//            int len1;
//            while ((len1 = fr.read()) != -1){
//                System.out.print((char) len1);
//            }

            int len2;
            char[] buffer = new char[1024];
            while ((len2 = fr.read(buffer)) != -1){
                String rs = new String(buffer,0,len2);
                System.out.println(rs);
            }


        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
