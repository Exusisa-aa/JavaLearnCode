package com.self.cinema.CustomerManage.Records;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class Record implements Serializable {
    @Serial
    private static final long serialVersionUID = 3L; // 必须添加
    private LocalDate date;
    private LocalTime startTime;//开始时间
    private LocalTime endTime;//结束时间
    private String place;
    private String movieName;//影片名称
    private String movieType;//影片类型
    private String dimension;//影片尺寸
    private String director;//导演
    private String actors;//演员
    private String Language;//语言
    private int lastTime;//片长
    private double price;//票价
    private double rate;//评分
    private String others;//其他购买
    private int seatNumber;
    private boolean isCancel;//是否退票

    public Record() {
    }

    public Record(LocalDate date,LocalTime startTime, LocalTime endTime,String place, String movieName, String movieType, String dimension, String director, String actors, String language, int lastTime, double price, double rate, String others,int seatNumber ,boolean isCancel) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.place = place;
        this.movieName = movieName;
        this.movieType = movieType;
        this.dimension = dimension;
        this.director = director;
        this.actors = actors;
        this.Language = language;
        this.lastTime = lastTime;
        this.price = price;
        this.rate = rate;
        this.others = others;
        this.seatNumber = seatNumber;
        this.isCancel  = isCancel;
    }

    public void printInfo() {
        System.out.println(
                "日期=" + date + '\n' +
                "开始时间=" + startTime + '\n' +
                "结束时间=" + endTime + '\n' +
                "地点=" + place + '\n' +
                "电影名=" + movieName + '\n' +
                "电影类型=" + movieType + '\n' +
                "影片类型=" + dimension + '\n' +
                "导演=" + director + '\n' +
                "演员=" + actors + '\n' +
                "语言=" + Language + '\n' +
                "时长=" + lastTime + '\n' +
                "评分=" + rate + '\n' +
                "票价=" + price + '\n' +
                "小吃花费=" + others + '\n' +
                "座位号=" + seatNumber + '\n' +
                "是否退票=" + isCancel);
        System.out.println(" ");
    }

    // 添加自定义序列化逻辑
    @Serial
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeObject(date.toString());
        out.writeObject(startTime.toString()); // 序列化 LocalTime 为字符串
        out.writeObject(endTime.toString());
    }

    @Serial
    private void readObject(ObjectInputStream in)
            throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        String dateStr = (String) in.readObject();
        date = LocalDate.parse(dateStr); // 反序列化字符串为 LocalDate
        startTime = LocalTime.parse((String) in.readObject());
        endTime = LocalTime.parse((String) in.readObject());

    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public String getPlace() {
        return place;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getMovieType() {
        return movieType;
    }

    public String getDimension() {
        return dimension;
    }

    public String getDirector() {
        return director;
    }

    public String getActors() {
        return actors;
    }

    public String getLanguage() {
        return Language;
    }

    public int getLastTime() {
        return lastTime;
    }

    public double getPrice() {
        return price;
    }

    public double getRate() {
        return rate;
    }

    public String getOthers() {
        return others;
    }

    public boolean isCancel() {
        return isCancel;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setCancel(boolean cancel) {
        isCancel = cancel;
    }
}
