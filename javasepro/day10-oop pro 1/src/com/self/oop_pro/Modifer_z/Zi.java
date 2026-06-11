package com.self.oop_pro.Modifer_z;

import com.self.oop_pro.Modifer_f.Fu;

import java.lang.reflect.Method;

public class Zi extends Fu {
    public void text(){
        Fu f = new Fu();
//        f.Method(); 缺省不能写在其他包下
        protectedMethod();
        f.publicMethod();
    }
}
