package com.self.oop.practice;
import java.util.Scanner;

public class MovieOperator {
    private Movie[] movies;
    
    public MovieOperator(Movie[] movies){
        this.movies = movies;
    }
    
    public void printAll(){
        System.out.println("--------------电影全部信息如下-------------");
        for (int i = 0; i < this.movies.length; i++) {
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
        System.out.println("请输入id：");
        while (flag){
            int id = sc.nextInt();
            for (int i = 0; i < this.movies.length; i++) {
                Movie m = this.movies[i];
                if (m.getId() == id){
                    System.out.println("电影名为" + m.getName());
                    System.out.println("价格为" + m.getPrice());
                    System.out.println("评分为" + m.getScore());
                    System.out.println("导演为为" + m.getDirector());
                    System.out.println("主演为为" + m.getActor());
                    System.out.println("观看人数为为" + m.getInfo());
                    flag = false;
                    break;
                } else if (m.getId() == movies.length) {
                    System.out.println("您输入的信息有误，请重新输入");
                    break;
                }
            }
        }
    }
}
