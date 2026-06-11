package com.self.more_API.JDK8NewTimeLine.Period;

import java.time.LocalDate;
import java.time.Period;

public class PeriodDemo {
    public static void main(String[] args) {
        //period仅仅支持LocalDate
        LocalDate ld1 = LocalDate.of(2024,1,1);
        LocalDate ld2 = LocalDate.of(2077,2,2);

        Period p = Period.between(ld1,ld2);

        System.out.println(p.getYears());
        System.out.println(p.getMonths());
        System.out.println(p.getDays());
    }
}
