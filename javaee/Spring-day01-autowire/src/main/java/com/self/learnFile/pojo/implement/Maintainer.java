package com.self.learnFile.pojo.implement;

import com.self.learnFile.pojo.Worker;

public class Maintainer implements Worker {

    private String databaseName;
    private int databaseSize;

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public void setDatabaseSize(int databaseSize) {
        this.databaseSize = databaseSize;
    }

    @Override
    public void work() {
        System.out.println(" maintainer work... " + databaseName + " " + databaseSize);
    }


}
