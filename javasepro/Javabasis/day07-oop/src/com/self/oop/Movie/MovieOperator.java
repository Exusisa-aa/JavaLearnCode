package com.self.oop.Movie;
import java.util.Scanner;

public class MovieOperator {
    private Movie[] movies;

    public MovieOperator(){

    }
    public MovieOperator(Movie[] movies){
        this.movies = movies;
    }

    public void printMovies(){
        System.out.println("-----------------------展示全部电影信息------------------------");
        for (int i = 0; i < movies.length; i++) {
             Movie m = this.movies[i];
            System.out.println(m.getId());
            System.out.println("电影名为" + m.getName());
            System.out.println("价格为" + m.getPrice());
            System.out.println("评分为" + m.getScore());
            System.out.println("导演为为" + m.getDirector());
            System.out.println("主演为为" + m.getActor());
            System.out.println("观看人数为为" + m.getInfo());
            System.out.println("-------------------");
        }
    }

    public void searchId(){
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            int id = sc.nextInt();
            for (int i = 0; i < movies.length; i++) {
                Movie m = this.movies[i];
                if(m.getId() == id){
                    System.out.println("---------------------该电影信息如下----------------------");
                    System.out.println(m.getId());
                    System.out.println("电影名为" + m.getName());
                    System.out.println("价格为" + m.getPrice());
                    System.out.println("评分为" + m.getScore());
                    System.out.println("导演为为" + m.getDirector());
                    System.out.println("主演为为" + m.getActor());
                    System.out.println("观看人数为为" + m.getInfo());
                    System.out.println("-----------");
                    flag = false;
                    break;
                }else if (m.getId() == movies.length-1) {
                    System.out.println("并未搜索到该电影,请重新输入");
                }
            }
        }
    }


}
