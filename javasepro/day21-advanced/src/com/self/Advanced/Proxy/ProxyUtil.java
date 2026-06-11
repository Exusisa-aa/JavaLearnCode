package com.self.Advanced.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Objects;

public class ProxyUtil {
    public static Star createProxy(BigStar bigStar){
        Star StarProxy = (Star) Proxy.newProxyInstance(ProxyUtil.class.getClassLoader(), new Class[]{Star.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (Objects.equals(method.getName(),"sing")){
                    System.out.println("准备话筒,收钱20w");
                }else if (Objects.equals(method.getName(),"dance")){
                    System.out.println("准备舞台,收钱100w");
                }
                return method.invoke(bigStar,args);
            }
        });
        return StarProxy;
    }
}
