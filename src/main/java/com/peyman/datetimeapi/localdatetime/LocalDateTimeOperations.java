package com.peyman.datetimeapi.localdatetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalDateTimeOperations {

	public static void main(String[] args) {
		LocalDateTime dateTime1 = LocalDateTime.of(2018,9,8,5,25);
		
		LocalDateTime dateTime2 = dateTime1.plusWeeks(3);
		System.out.println("Date "+dateTime1+" plus 3 weeks : "+dateTime2);
		
		int minute = dateTime1.getMinute();
		System.out.println("Minute   :"+minute);
		
		LocalDate date = dateTime1.toLocalDate();
		System.out.println("Date   :"+date);
		
		LocalTime time = dateTime1.toLocalTime();
		System.out.println("Time   :"+time);
		
		LocalDateTime dateTime3 = dateTime1.withHour(7);
		System.out.println("DateTime3   :"+dateTime3);
		
		boolean isAfter = dateTime1.isAfter(dateTime3);
		System.out.println("isAfter   :"+isAfter);
		
		

	}
}


//boolean isBefore = dateTime1.isBefore(dateTime2);
//System.out.println(dateTime1+" Is before "+dateTime2+"=" + isBefore);
