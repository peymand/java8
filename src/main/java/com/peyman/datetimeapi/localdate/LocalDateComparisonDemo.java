package com.peyman.datetimeapi.localdate;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

public class LocalDateComparisonDemo {

    public static void main(String[] args) {


        LocalDate date1 = LocalDate.parse("2011-08-01");

        LocalDate date2 = LocalDate.parse("2013-03-26");

        System.out.println("Date1: "+date1);
        System.out.println("Date2: "+date2);

        boolean isAfter = date1.isAfter(date2);
        System.out.println("isAfter: "+isAfter);

        boolean isBefore = date1.isBefore(date2);
        System.out.println("isBefore: "+isBefore);

        boolean isEqual = date1.isEqual(date2);
        System.out.println("isEqual: "+isEqual);

        boolean isLeapYear = date1.isLeapYear();
        System.out.println("isLeapYear: "+isLeapYear);

    }
}
