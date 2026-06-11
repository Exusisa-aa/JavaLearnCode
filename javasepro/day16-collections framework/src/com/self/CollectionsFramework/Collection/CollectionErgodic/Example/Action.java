package com.self.CollectionsFramework.Collection.CollectionErgodic.Example;

import java.util.ArrayList;
import java.util.Collection;

public class Action {
    public static void main(String[] args) {
        Movie movie1 = new Movie("《肖生克的救赎》",9.7,"罗宾斯");
        Movie movie2 = new Movie("《霸王别姬》",9.6,"张国荣，张丰毅");
        Movie movie3 = new Movie("《阿甘正传》",9.5,"汤姆汉克斯");
        Collection<Movie> movies = new ArrayList<>();
        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);

        for (Movie movie : movies){
            System.out.println(movie.getName());
            System.out.println(movie.getRating());
            System.out.println(movie.getActors());
            System.out.println("---------------------------");
        }
    }
}
