package com.self.FileAndIo.Io.PerformanceAnalysis;

import java.io.*;

public class PerformanceAnalysis {
    public static File startF = new File("D:\\animation\\Look.Back.2024.1080p.AMZN.WEB-DL.DDP5.1.H.264-VARYG.mkv");
    public static File endF = new File("E:\\百度网盘\\LookBack.mkv");
    public static void main(String[] args) {
        inputStreamCopy();
        bufferedInputStreamCopy();
    }

    public static void inputStreamCopy(){
        long startTime = System.currentTimeMillis();
        try (
                InputStream is = new FileInputStream(startF);
                OutputStream os = new FileOutputStream(endF)
        ) {
            byte[] buffer = new byte[1024*32];
            int len;
            while ((len = is.read(buffer)) != -1) {
                os.write(buffer,0,len);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("原始流复制消耗时间：" + (endTime - startTime)/1000.000 + "s");
        System.out.println(endF.delete());
    }

    public static void bufferedInputStreamCopy(){
        long startTime = System.currentTimeMillis();
        try (
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(startF),8192*16);
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(endF),8192*16)
        ) {
            byte[] buffer = new byte[1024*128];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer,0,len);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("缓冲流流复制消耗时间：" + (endTime - startTime)/1000.000 + "s");
        System.out.println(endF.delete());
    }
}
