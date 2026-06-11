package com.self.oop_pro.API.API_StringBuilder_StringBuffer;

public class Example {
    public static void main(String[] args) {
        int[] number = {22,44,55,99,77};
        System.out.println(getArrayDate(number));
    }

    public static String getArrayDate(int[] array){
        if(array == null){
            return null;
        }

        StringBuilder a = new StringBuilder();
        a.append("[");
        for (int i = 0; i < array.length; i++) {
            a.append(i == array.length - 1?array[i]:array[i] + "," );
        }
        a.append("]");
        return a.toString();
    }
}
