package com.self.cinema.MyUtilsAndJunitsAndLockEnumAndFilepath;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public enum LockForThread {
    //一个全局锁  锁的是共享数据
    INSTANCE;//单例设计
    private final Lock lock = new ReentrantLock();

    public Lock getLock() {
        return lock;
    }

    //单线程调用共享数据时不上锁
    //多线程调用共享数据时上锁
}




