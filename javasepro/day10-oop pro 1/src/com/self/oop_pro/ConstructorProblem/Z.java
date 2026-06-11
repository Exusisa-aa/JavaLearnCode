package com.self.oop_pro.ConstructorProblem;

public class Z extends F{
    public Z(){
//        super();默认有，调用父类无参构造器
        super("小明");
        System.out.println("子类无参构造器执行");
    }
}
