package com.self.FileAndIo.Io.ByteStream.Copy;

import java.io.*;

public class CopyDemo {
    public static void main(String[] args) {
        InputStream is = null;
        OutputStream os = null;
        try {
            //字节流文件复制适用于一切文件，只要前后的文件后缀一致就行
            //字节输入列创建
            is = new FileInputStream("K:\\study\\方舟.jpg");
            //字节输出流创建
            os = new FileOutputStream("E:\\百度网盘\\方舟.jpg");

            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1) {
                os.write(buffer,0,len);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.getStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.getStackTrace();
                }
            }
        }
    }
}
