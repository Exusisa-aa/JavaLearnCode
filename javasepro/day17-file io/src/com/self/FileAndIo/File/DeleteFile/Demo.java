package com.self.FileAndIo.File.DeleteFile;

import java.io.File;

public class Demo {

    //删除非空文件夹
    public static void main(String[] args) {
        deleteFile(new File("C:\\Users\\24474\\AppData\\Local\\Temp"));
    }

    public static void deleteFile(File parentFile) {
        //判断是否有权访问文件夹
        if (parentFile == null) {
            System.out.println("您无权访问该文件！");
            return;
        }

        if (!parentFile.exists()) {
            System.out.println("您输入的路径有误！");
            return;
        }

        if (parentFile.isFile()) {
            System.out.println("请输入文件夹路径~~");
            return;
        }

        File[] files = parentFile.listFiles();

        //判断是否有权访问
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    file.delete();
                }else {
                    deleteFile(file);
                    file.delete();
                }
            }
        }



    }
}
