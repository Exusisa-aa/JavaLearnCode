package com.self.processcontroller;

public class EndLessLoopDemo {
    public static void main(String[] args) {
        //死循环的写法其一
        /*for ( ; ; ){
            System.out.println("111");
        }*/
        //死循环写法其二（经典写法）
        /*while (true){
            System.out.println("111");
        }*/
        //死循环代码其三
        do {
            System.out.println("111");
        }while (true);
    }
}
//死循环不能连写两个   这样就会导致第二个死循环代码无法执行