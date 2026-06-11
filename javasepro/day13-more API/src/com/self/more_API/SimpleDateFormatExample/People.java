package com.self.more_API.SimpleDateFormatExample;

import java.util.Date;

public class People {
    private String name;
    private String time;

    People(){

    }

    public People(String name, String time) {
        this.name = name;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
