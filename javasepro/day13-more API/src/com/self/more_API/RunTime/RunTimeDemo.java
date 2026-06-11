package com.self.more_API.RunTime;

import java.io.IOException;

public class RunTimeDemo {
    public static void main(String[] args) throws IOException, InterruptedException {
//        1.RunTime是单例设计模式，需要创建对象去接getRunTime方法
        Runtime r = Runtime.getRuntime();

//        2.终止当前程序
//        r.exit(0);  一般不用

//        3.返回虚拟机中的可用处理器数
        System.out.println(r.availableProcessors());

//        4.返回虚拟机的内存总量
        System.out.println(r.totalMemory() / 1024 / 1024 + "MB");

//        5.返回虚拟机中的可用内存
        System.out.println(r.freeMemory() / 1024 / 1024 + "MB");

//        6.启动某个程序
        Process stop = r.exec("D:\\WeChat\\WeChat.exe");
        Thread.sleep(5000);
        stop.destroy();
    }
}
