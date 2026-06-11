package com.self.FileAndIo.Io.ByteStream.BufferedInputStreamAndBufferedOutputStream;

import java.io.*;

public class BufferedStreamDemo {
    public static void main(String[] args) {
        //用缓冲流包装原始流，再调用缓冲流即可，默认创建一个8kb的缓冲池，减少调用文件的次数，大大提高了读写的性能。
        try (
                InputStream is = new FileInputStream("K:\\study\\方舟.jpg");
                OutputStream os = new FileOutputStream("E:\\百度网盘\\方舟.jpg");
                //包装原始流
                BufferedInputStream bis = new BufferedInputStream(is,8192*2);
                BufferedOutputStream bos = new BufferedOutputStream(os,8192*2)
        ) {
            int len;
            byte[] buffer = new byte[1024];
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer,0,len);
            }
        }catch (Exception e) {
            e.getStackTrace();
        }
    }
}
