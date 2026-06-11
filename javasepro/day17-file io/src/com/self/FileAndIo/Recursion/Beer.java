package com.self.FileAndIo.Recursion;

public class Beer {
    private static int bottle;
    private static int cover;
    private static int sum;
    public static void main(String[] args) {
        //啤酒2元一瓶，4个盖子可以换一瓶，2个空瓶可以换一瓶，请问10元能喝多少瓶啤酒

        beer(20);
        System.out.println("剩余瓶盖：" + cover);
        System.out.println("剩余酒瓶：" + bottle);
    }

    public static void beer(double yuan) {
        if (yuan <= 0) {
            System.out.println("输入错误，请输入大于0的数");
        }



        int buy1 = (int)yuan/2;

        bottle = bottle + buy1;
        cover = cover + buy1;

        if (bottle < 2 && cover < 4){
            System.out.println("一共喝了" + sum + "瓶");
            return;
        }

        int bottleAdd = bottle/2;
        int coverAdd = cover/4;
        int buy2 = bottleAdd + coverAdd;
        sum = sum + buy1 + buy2;

        bottle = bottle - bottleAdd*2 + buy2;
        cover = cover - coverAdd*4 + buy2;
        beer(0.1);
    }
}
