package com.self.learnFile.pojo.implement;

import com.self.learnFile.pojo.Worker;

public class Maintainer implements Worker {
    @Override
    public void work() {
        System.out.println(" maintainer work...");
    }
}
