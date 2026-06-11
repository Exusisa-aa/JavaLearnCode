package com.self.cinema.WorkerManage.Workers;

public enum WorkType {
    CLEANER("清洁工"),
    FRONTDESKER("前台"),
    MAINTAINER("修理工"),
    MOVIEPLAYER("电影放映员");


    private final String workType;

    WorkType(String workType) {
        this.workType = workType;
    }

    public String getWorkType() {
        return workType;
    }
}
