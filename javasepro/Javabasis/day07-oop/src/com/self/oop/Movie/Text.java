package com.self.oop.Movie;
import java.util.Scanner;

public class Text {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Movie[] movies = new Movie[4];
        movies[0] = new Movie(1,"水门桥",38.9,9.8,"徐克","吴京","12万人想看");
        movies[1] = new Movie(2,"出拳吧",39,7.8,"唐小白","田雨","3.5万人想看");
        movies[2] = new Movie(3,"月球陨落",42,7.9,"罗兰","贝瑞","17.9万人想看");
        movies[3] = new Movie(4,"一点就到家",35,8.7,"徐宏宇","刘昊然","10.8万人想看");

        MovieOperator operate = new MovieOperator(movies);
        boolean flag = true;
        while(flag) {
            System.out.println("===电影信息系统===");
            System.out.println("1.查询全部电影信息");
            System.out.println("2.id搜索电影信息");
            System.out.println("请输入数字：");
            switch (sc.nextInt()){
                case 1 :
                    operate.printMovies();
                    flag = false;
                    break;
                case 2 :
                    System.out.println("请输入id：");
                    operate.searchId();
                    flag = false;
                    break;
                default:
                    System.out.println("请输入正确的命令");
            }
        }
        System.out.println("系统结束");

    }
}
