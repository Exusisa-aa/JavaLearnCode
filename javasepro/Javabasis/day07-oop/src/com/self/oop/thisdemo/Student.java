package com.self.oop.thisdemo;

public class Student {
    String name;
    double score;
    public void scorePass (double score) {
        if(this.score > score) {
            System.out.println("恭喜" + name + "同学成功考入清华大学");
        }else {
            System.out.println("很遗憾，落选了~~");
        }
    }

    public void url() {
        System.out.println(this);
    }
}
