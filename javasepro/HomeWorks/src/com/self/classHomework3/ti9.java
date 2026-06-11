package com.self.classHomework3;

import java.time.LocalDate;

public class ti9 {
    public static void main(String[] args) {
        System.out.println("今日日期" + LocalDate.now());
        LocalDate birthday = LocalDate.of(2004,3,28);
        judge(birthday);

        System.out.println("两星期后为" + LocalDate.now().plusDays(14));
    }


    public static void judge(LocalDate birthday){
        if(birthday.getYear() % 4 == 0){
            System.out.println("生日是闰年");
        }else {
            System.out.println("生日不是闰年");
        }
    }
}
