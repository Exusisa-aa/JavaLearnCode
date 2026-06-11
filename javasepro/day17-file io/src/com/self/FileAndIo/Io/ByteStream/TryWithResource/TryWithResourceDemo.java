package com.self.FileAndIo.Io.ByteStream.TryWithResource;

import java.io.*;

public class TryWithResourceDemo {

    public static void main(String[] args) {
        try (
                //字节流文件复制适用于一切文件，只要前后的文件后缀一致就行
                //字节输入列创建
                InputStream is = new FileInputStream("K:\\study\\方舟.jpg");
                //字节输出流创建
                OutputStream os = new FileOutputStream("E:\\百度网盘\\方舟.jpg");

                Test t = new Test()
        ) {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1) {
                os.write(buffer,0,len);
            }
            System.out.println(t);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
