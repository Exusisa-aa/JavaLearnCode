package com.self.CollectionsFramework.Collection.CollectionErgodic.Example;

public class Movie {
    private String name;
    private double rating;
    private String actors;

    public Movie() {
    }

    public Movie(String name, double rating, String actors) {
        this.name = name;
        this.rating = rating;
        this.actors = actors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }
}
