package com.self.Multithreading.MultithreadingProblemSolution1;

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

    public void takeMoney(Account account, double money, Thread t){
        synchronized (this) {
            if (account.getMoney() >= money) {
                account.setMoney(account.getMoney() - money);
                System.out.println(t.getName() + "成功取走" + money + "元");
                System.out.println("账户剩下" + account.getMoney() + "元");
            }else {
                System.out.println(t.getName() + "取钱失败，余额不足");
            }
        }
        this.notifyAll();
        try {
            this.wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    //静态方法用数据类名.class文件作为锁的对象
//    public static void takeMoney(Account account, double money, Thread t){
//        synchronized (Account.class) {
//            if (account.getMoney() >= money) {
//                account.setMoney(account.getMoney() - money);
//                System.out.println(t.getName() + "成功取走" + money + "元");
//                System.out.println("账户剩下" + account.getMoney() + "元");
//            }else {
//                System.out.println(t.getName() + "取钱失败，余额不足");
//            }
//        }
//    }
}
