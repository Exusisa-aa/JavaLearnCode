package com.self.Multithreading.MultithreadingProblemSolution2;

public class MyRunnable implements Runnable{
    public Account account;

    public MyRunnable(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        Thread t = Thread.currentThread();
        takeMoney(account,100000,t);
    }


    //非静态方法默认为this
    public synchronized void takeMoney(Account account, double money, Thread t){
            if (account.getMoney() >= money) {
                account.setMoney(account.getMoney() - money);
                System.out.println(t.getName() + "成功取走" + money + "元");
                System.out.println("账户剩下" + account.getMoney() + "元");
            }else {
                System.out.println(t.getName() + "取钱失败，余额不足");
            }
            this.notifyAll();
        try {
            this.wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //静态方法默认为数据类.class
//    public static synchronized void takeMoney(Account, double money, Thread t){
//        if (account.getMoney() >= money) {
//            account.setMoney(account.getMoney() - money);
//            System.out.println(t.getName() + "成功取走" + money + "元");
//            System.out.println("账户剩下" + account.getMoney() + "元");
//        }else {
//            System.out.println(t.getName() + "取钱失败，余额不足");
//        }
//    }


}
