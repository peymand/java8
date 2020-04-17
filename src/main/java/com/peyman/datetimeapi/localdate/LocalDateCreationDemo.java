package com.peyman.datetimeapi.localdate;

import java.time.LocalDate;

public class LocalDateCreationDemo {

    public static void main(String[] args) {
        LocalDate date1 = LocalDate.now();
        System.out.println("date1: " + date1);

        LocalDate date2 = LocalDate.parse("2012-12-10");//DateTimeFormatter
        System.out.println("date2: " + date2);

        LocalDate date3 = LocalDate.of(2020,5,8);
        System.out.println("date3: " + date3);

        LocalDate date4 = LocalDate.ofYearDay(2020,230);
        System.out.println("date4: " + date4);

    }
}
