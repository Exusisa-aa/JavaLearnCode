package com.self.classHomework3;

import java.time.MonthDay;
import java.util.Objects;

public class ti10 {
    public static void main(String[] args) {
        MonthDay birthday = MonthDay.of(3,28);
        MonthDay today = MonthDay.now();
        if(Objects.equals(birthday,today)){
            System.out.println("今天是生日");
        }else {
            System.out.println("今天不是生日");
        }
    }
}
