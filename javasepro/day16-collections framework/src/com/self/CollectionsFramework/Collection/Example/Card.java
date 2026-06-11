package com.self.CollectionsFramework.Collection.Example;

public class Card {
    private String number;
    private String color;
    private int rank;

    public Card(String number, String color, int rank) {
        this.number = number;
        this.color = color;
        this.rank = rank;
    }

    public Card() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return color + number;
    }
}
