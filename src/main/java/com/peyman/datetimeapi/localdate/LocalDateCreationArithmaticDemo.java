package com.peyman.datetimeapi.localdate;

import java.time.LocalDate;

public class LocalDateCreationArithmaticDemo {

    public static void main(String[] args) {
        LocalDate date1 = LocalDate.parse("2019-07-15");

        LocalDate date2 = date1.plusDays(5);// adds 5 days
        System.out.println(date1+"    +5 day:        "+date2);

        date2 = date1.plusWeeks(2);// adds 2 weeks
        System.out.println(date1+"    +2 weeks:      "+date2);

        date2 = date1.minusMonths(6);// minus 6 months
        System.out.println(date1+"    -6 months:     "+date2);

        date2 = date1.minusYears(4);// minus 4 years
        System.out.println(date1+"    -4 years:      "+date2);

        System.out.println("----------------------With Operations------------------------------------");

        date2 = date1.withMonth(2);// set month to Feb
        System.out.println(date1+"    with month 2:            "+date2);

        date2 = date1.withDayOfMonth(24);// set Day of month = 24
        System.out.println(date1+"    with DayOfMonth 24:      "+date2);

        date2 = date1.withYear(2014);// set Year = 2014
        System.out.println(date1+"    with Year 2014:          "+date2);

        date2 = date1.withDayOfYear(42);// set DayOfYear =42
        System.out.println(date1+"    with DayOfYear 42:       "+date2);
    }
}
