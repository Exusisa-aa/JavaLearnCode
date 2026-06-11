package com.self.Multithreading.CreateMultithreading.MethodTwo;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {
    int n;

    public MyCallable(int n) {
        this.n = n;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    @Override
    public String call() throws Exception {
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += i;
        }
        return "1到" + n + "的和为：" + sum;
    }
}
