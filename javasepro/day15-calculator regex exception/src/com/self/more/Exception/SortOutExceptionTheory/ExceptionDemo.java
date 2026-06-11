package com.self.more.Exception.SortOutExceptionTheory;


import java.io.IOException;

public class ExceptionDemo {
    public static void main(String[] args) throws IOException {
        Runtime r = Runtime.getRuntime();
        r.exec("Wechat");


//        try {
//            Runtime r = Runtime.getRuntime();
//            r.exec("Wechat");//1.抛出异常  2.用try和catch
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }
}
