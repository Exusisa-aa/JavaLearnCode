package com.self.learnFile.service.implement;
import com.self.learnFile.pojo.Worker;
import com.self.learnFile.service.WorkServiceFramework;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;


@Service("workService")
@Scope("singleton")
public class WorkService implements WorkServiceFramework {

    @Autowired
    @Qualifier("maintainer")
    private Worker maintainer;

    @Override
    public void work() {
        System.out.println("workService work...");
        maintainer.work();
    }

    @PostConstruct
    public void init() {
    	System.out.println("workService init...");
    }

    @PreDestroy
    public void destroy() {
    	System.out.println("workService destroy...");
    }


}
