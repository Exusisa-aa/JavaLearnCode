package com.self.cinema.CinemaManage.ScreenDays.ScreenTimes;

import com.self.cinema.CustomerManage.Customer.Customer;

import java.io.*;
import java.time.LocalTime;
import java.util.LinkedHashMap;
import java.util.Objects;

public class ScreenTime implements Serializable {
    @Serial
    private static final long serialVersionUID = 2L; // 必须添加
    private LocalTime startTime;//开始时间
    private LocalTime endTime;//结束时间
    private String movieName;//影片名称
    private String movieType;//影片类型
    private String dimension;//影片尺寸
    private String director;//导演
    private String actors;//演员
    private String Language;//语言
    private int lastTime;//片长
    private double price;//票价
    private double rate;//评分
    private final LinkedHashMap<Integer, Customer> seats = new LinkedHashMap<>();//座位信息

    public ScreenTime(LocalTime startTime, LocalTime endTime, String movieName, String movieType, String dimension, String director, String actors, String language, int lastTime, double price, double rate) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.movieName = movieName;
        this.movieType = movieType;
        this.dimension = dimension;
        this.director = director;
        this.actors = actors;
        this.Language = language;
        this.lastTime = lastTime;
        this.price = price;
        this.rate = rate;
    }



    public String getMovieName() {
        return movieName;
    }

    public String getMovieType() {
        return movieType;
    }

    public String getDirector() {
        return director;
    }

    public String getActors() {
        return actors;
    }

    public int getLastTime() {
        return lastTime;
    }

    public double getRate() {
        return rate;
    }

    public LinkedHashMap<Integer, Customer> getSeats() {
        return seats;
    }


    public double getPrice() {
        return price;
    }

    public String getLanguage() {
        return Language;
    }

    public String getDimension() {
        return dimension;
    }

    public void printInfo() {
        System.out.println("开始时间=" + startTime + '\n' +
                "结束时间=" + endTime + '\n' +
                "电影名=" + movieName + '\n' +
                "电影类型=" + movieType + '\n' +
                "影片类型=" + dimension + '\n' +
                "导演=" + director + '\n' +
                "演员=" + actors + '\n' +
                "语言=" + Language + '\n' +
                "时长=" + lastTime + '\n' +
                "价格=" + price + '\n' +
                "评分=" + rate);
        printSeats();
        System.out.println(" ");

    }

    public void printSeats(){
        seats.forEach((k, v) -> {
            String status = (v == null)
                    ? "\u001B[32m●\u001B[0m"
                    : "\u001B[31m●\u001B[0m";

            // 每个座位号占6位左对齐，方便对齐显示
            System.out.printf("%-4s%s\t", k + 1 + ":", status);

            if ((k + 1) % 10 == 0) {
                System.out.println();
            }
        });
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void setMovieType(String movieType) {
        this.movieType = movieType;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public void setLanguage(String language) {
        Language = language;
    }

    public void setLastTime(int lastTime) {
        this.lastTime = lastTime;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScreenTime that = (ScreenTime) o;
        return lastTime == that.lastTime && Double.compare(price, that.price) == 0 && Double.compare(rate, that.rate) == 0 && Objects.equals(startTime, that.startTime) && Objects.equals(endTime, that.endTime) && Objects.equals(movieName, that.movieName) && Objects.equals(movieType, that.movieType) && Objects.equals(dimension, that.dimension) && Objects.equals(director, that.director) && Objects.equals(actors, that.actors) && Objects.equals(Language, that.Language) && Objects.equals(seats, that.seats);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startTime, endTime, movieName, movieType, dimension, director, actors, Language, lastTime, price, rate, seats);
    }

    // 添加自定义序列化逻辑
    @Serial
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeObject(startTime.toString()); // 序列化 LocalTime 为字符串
        out.writeObject(endTime.toString());
    }

    @Serial
    private void readObject(ObjectInputStream in)
            throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        startTime = LocalTime.parse((String) in.readObject());
        endTime = LocalTime.parse((String) in.readObject());

    }
}
