package com.self.array;

public class TwoDimensionalArrayDemo {
    public static void main(String[] args) {
        String[][] array = {{"小一","小二","小三","小四"},
                            {"小五","小六","小七"},
                            {"小八","小九"},
                            {"小十","小十一","小十二","小十三","小十四","小十五"}};

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println(" ");
        }
        System.out.println("===================================================");
        for (int i = 0; i < array[2].length; i++) {
            System.out.print(array[2][i] + "\t");
        }
        System.out.println(" ");
        System.out.println("============================================================");

        System.out.println(array[3][4]);
        System.out.println("=============================================");
        System.out.println(array.length);
        System.out.println(array[3].length);
        System.out.println(array[1].length);
    }
}
