package com.self.learnFile.service.implement;

import com.self.learnFile.pojo.Worker;
import com.self.learnFile.service.WorkServiceFramework;

public class WorkService implements WorkServiceFramework {
    private Worker maintainer;
    @Override
    public void work() {
        System.out.println("workService work...");
        maintainer.work();
    }

    public WorkService(Worker maintainer) {
        this.maintainer = maintainer;
    }
}
