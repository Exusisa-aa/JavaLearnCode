package com.self.learnFile.pojo.implement;

import com.self.learnFile.pojo.Worker;

public class Maintainer implements Worker {

    private String databaseName;
    private int databaseSize;

    public Maintainer(String databaseName, int databaseSize) {
        this.databaseName = databaseName;
        this.databaseSize = databaseSize;
    }

    @Override
    public void work() {
        System.out.println(" maintainer work... " + databaseName + " " + databaseSize);
    }


}
