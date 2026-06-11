package com.self.learnFile.factory;

import com.self.learnFile.service.WorkServiceFramework;
import com.self.learnFile.service.implement.WorkService;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

public class ServerFactorySetting implements FactoryBean<WorkServiceFramework>, InitializingBean, DisposableBean {
    @Override
    public boolean isSingleton() {
        return false;
    }

    @Override
    public WorkServiceFramework getObject(){
        return new WorkService();
    }

    @Override
    public Class<?> getObjectType() {
        return WorkServiceFramework.class;
    }

    //手动配置生命周期钩子函数
    public void initByHand(){
        System.out.println("initByHand");
    }

    public void destroyByHand(){
        System.out.println("destroyByHand");
    }



    //spring提供生命周期钩子函数
    @Override
    public void destroy() throws Exception {
        System.out.println("service destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("service init");
    }
}
