package com.self.Multithreading.Example;

import java.util.ArrayList;
import java.util.Random;

public class MyRunnable implements Runnable{
    private ArrayList<String> list = new ArrayList<>();
    private int count1 = 0;
    private int count2 = 0;

    @Override
    public void run() {
        Thread t = Thread.currentThread();
        Random r = new Random();
        while (list.size() > 10){
            synchronized (this) {
                String gift = list.get(r.nextInt(list.size()));
                System.out.println(t.getName() + " 发放了礼物：" + gift);
                list.remove(gift);
                if (t.getName().equals("小红")){
                    count1++;
                }else {
                    count2++;
                }
            }
        }
    }

    public void addGift(){
        String name = "礼物";
        for (int i = 0; i < 100; i++) {
            list.add(name + (i + 1));
        }
    }

    public int getCount1() {
        return count1;
    }

    public int getCount2() {
        return count2;
    }


}
