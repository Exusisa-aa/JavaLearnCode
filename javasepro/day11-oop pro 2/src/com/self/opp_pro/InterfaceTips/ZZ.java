package com.self.opp_pro.InterfaceTips;

public class ZZ extends Fu implements A,B{
    //一个类继承了父类，又同时实现了接口，父类和接口中有用明德默认方法，实现类优先用父类方法
    @Override
    public void test(){
        //一个类实现多个接口时，若多个接口中有同名但方法权限冲突的方法，则不支持多实现
    }

}
