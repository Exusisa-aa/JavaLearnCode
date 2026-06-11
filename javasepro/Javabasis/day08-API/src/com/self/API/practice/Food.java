package com.self.API.practice;

public class Food {
    private String name;
    private String discription;
    private double price;

    public Food(){

    }

    public Food(String name,String discription,double price){
        this.name = name;
        this.discription = discription;
        this.price = price;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName(){
        return this.name;
    }

    public String getDiscription() {
        return this.discription;
    }

    public double getPrice() {
        return this.price;
    }
}
