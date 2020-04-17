package com.peyman.datetimeapi.localdate;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

public class LocalDateExtractionDemo {

    public static void main(String[] args) {


        LocalDate date = LocalDate.parse("2012-12-10");//DateTimeFormatter

        int day = date.getDayOfYear();
        int dayOfMonth = date.getDayOfMonth();
        Month month = date.getMonth();
        DayOfWeek dayOfWeek = date.getDayOfWeek();

    }
}
