package com.self.API.ArrayListExample2;

public class Food {
    private String name;
    private String description;
    private String price;

    public Food(){

    }

    public Food(String name,String description,String price){
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getDescription(){
        return this.description;
    }

    public void setPrice(String price){
        this.price = price;
    }

    public String getPrice() {
        return price;
    }
}
