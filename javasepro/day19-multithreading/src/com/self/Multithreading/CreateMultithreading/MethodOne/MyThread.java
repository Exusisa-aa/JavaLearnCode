package com.self.Multithreading.CreateMultithreading.MethodOne;

public class MyThread extends Thread{

    public MyThread(String name) {
        super(name);
    }
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("字线程MyThread执行了" + i);
        }
    }
    //缺点：子线程类已经继承了thread  无法继承其他类  失去了拓展性
}
