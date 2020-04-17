package com.peyman.datetimeapi.localdatetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class LocalDateTimeDemo {

	public static void main(String[] args) {
		LocalDateTime dateTime1 = LocalDateTime.now();
		System.out.println("Current DateTime  : "+dateTime1);
		
		LocalDateTime dateTime2 = LocalDateTime.parse("2012-05-06T10:15:30");
		System.out.println("DateTime3  : "+dateTime2);
		
		LocalDateTime dateTime3 = LocalDateTime.of(LocalDate.parse("2013-03-24"),LocalTime.parse("06:45"));
		System.out.println("DateTime3 : "+dateTime3);
		

	}

}
