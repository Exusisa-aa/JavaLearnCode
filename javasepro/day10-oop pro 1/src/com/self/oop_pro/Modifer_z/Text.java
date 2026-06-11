package com.self.oop_pro.Modifer_z;

import com.self.oop_pro.Modifer_f.Fu;

public class Text {
    public void text(){
        Fu f = new Fu();
        f.publicMethod();
//        protectedMethod(); protected不能在其他包下任意类被调用，其他包下要调用只能是子类包，且不能用对象去调用
    }
}
