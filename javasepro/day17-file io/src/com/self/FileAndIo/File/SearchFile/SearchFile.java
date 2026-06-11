package com.self.FileAndIo.File.SearchFile;

import java.io.File;
import java.util.Objects;

public class SearchFile {
    public static void main(String[] args) {
        try {
            searchFile(new File("D:"),"QQ.exe");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void searchFile(File parentFile,String fileName) throws Exception{
        //判断文件夹是否有权限访问
        if(parentFile == null) {
            System.out.println("您无权访问！");
            return;
        }
        //判断文件夹根目录路径是否有误
        if(!parentFile.exists()) {
            System.out.println("根目录路径有误！");
            return;
        }

        //判断是否是文件
        if (parentFile.isFile()) {
            System.out.println("请输入根目录文件夹路径~~");
            return;
        }

        File[] files = parentFile.listFiles();

        //判断一级文件夹是否有权访问
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    //若是文件
                    if (Objects.equals(fileName,file.getName())) {
                        System.out.println(file.getAbsolutePath());
                        Runtime runtime = Runtime.getRuntime();
                        runtime.exec(file.getAbsolutePath());
                        return;
                    }
                }else {
                    //若是文件夹
                    searchFile(file,fileName);
                }
            }
        }
    }
}
