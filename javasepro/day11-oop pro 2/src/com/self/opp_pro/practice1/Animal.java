package com.self.opp_pro.practice1;

public abstract class Animal {
    public final void cure(){
        System.out.println("治疗程序启动");
        System.out.println("正在识别对象");
        cureMain();
        System.out.println("治疗成功");
        System.out.println("==========================================");
    }

    public abstract void cureMain();
}
