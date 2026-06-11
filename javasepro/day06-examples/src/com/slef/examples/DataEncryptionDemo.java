package com.slef.examples;
import java.util.Scanner ;

public class DataEncryptionDemo {
    public static void main(String[] args) {
        DateEncryption();//me
        System.out.println("加密后密码为：" + encryption(4567));
    }

    public static void DateEncryption(){
        //设计一个加密程序，原密码为四位数，请对每一位数+5再对10取余，最后倒转这四位数为加密密码 我的写法
        int[] array = new int[4];
        Scanner sc = new Scanner(System.in);
        String code0 = "";
        for (int i = 0; i < 4; i++) {
            while (true){
                System.out.println("请输入第" + (i + 1) +"位密码：");
                int s = sc.nextInt();
                if(s >= 0 && s <= 9){
                    array[i] = s;
                    code0 += array[i];
                    break;
                }else{
                    System.out.println("您输入的数字有误，请重新输入：");
                }
            }
        }
        System.out.println("您输入的原密码为" + code0);
        String code1 = "";
        for (int i = 0; i < 4; i++) {
            array[i] = (array[i] + 5) % 10;
        }

        for (int i = 0,j = array.length -1; i < j; i++,j--) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

        for (int i = 0; i < 4; i++) {
            code1 += array[i];
        }
        System.out.println("加密后为:" + code1);
    }


    public static String encryption(int number){ //黑马写法
        String code ="";
        int[] numbers =spilt(number);
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (numbers[i] + 5) % 10;
        }
        reverse(numbers);
        for (int i = 0; i < 4; i++) {
            code += numbers[i];
        }
        return code;
    }



    public static void reverse(int[] numbers){
        for (int i = 0,j = numbers.length-1; i < j; i++,j--) {
            int temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
        }
    }

    public static int[] spilt(int number){
        int[] numbers = new int[4];
        numbers[0] = number / 1000;
        numbers[1] = (number / 100) % 10;
        numbers[2] = (number / 10) % 10;
        numbers[3] = number % 10;
        return numbers;
    }
}
