package com.self.FileAndIo.Io.ByteStream.TryCatchFinally;

import java.io.*;

public class TryCatchFinallyDemo {
    public static void main(String[] args) {
        //防止出现无法识别的报错
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream("K:\\study\\方舟.jpg");
            os = new FileOutputStream("E:\\百度网盘\\方舟.jpg");

            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1) {
                os.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.getStackTrace();
        } finally { //在finally中执行释放资源操作
            //防止在还未创建流时就报错
            if (os != null) {
                try {
                    os.close();//不要在try中关闭流
                }catch (Exception e){
                    e.getStackTrace();
                }
            }


            //防止在还未创建流时就报错
            if (is != null) {
                try {
                    is.close();//不要在try中关闭流
                }catch (Exception e){
                    e.getStackTrace();
                }
            }
        }
    }
}
