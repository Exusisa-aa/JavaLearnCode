package com.self.learnFile.factory;

import com.self.learnFile.service.WorkServiceFramework;
import com.self.learnFile.service.implement.WorkService;
import org.springframework.beans.factory.FactoryBean;

public class ServerFactorySetting implements FactoryBean<WorkServiceFramework> {
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
}
