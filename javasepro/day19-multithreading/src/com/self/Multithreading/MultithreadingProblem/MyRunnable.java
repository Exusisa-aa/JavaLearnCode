package com.self.Multithreading.MultithreadingProblem;

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

    public void takeMoney(Account account,double money,Thread t){
        if (account.getMoney() >= money) {
            account.setMoney(account.getMoney() - money);
            System.out.println(t.getName() + "成功取走" + money + "元");
            System.out.println("账户剩下" + account.getMoney() + "元");
        }else {
            System.out.println(t.getName() + "取钱失败，余额不足");
        }
    }
}
