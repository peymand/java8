package com.peyman.datetimeapi.zoneddatetimedemo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZonedDateTimeOperationsDemo {

	public static void main(String[] args) {
		
		ZoneId parisZoneId = ZoneId.of("Europe/Paris");
		ZonedDateTime zonedDateTime1 = ZonedDateTime.of(2012,8,11,5,25,0,0,parisZoneId);
		System.out.println("zonedDateTime1 is "+zonedDateTime1);
		
		ZonedDateTime zonedDateTime2 = zonedDateTime1.minusMinutes(15);
		System.out.println(" minus 15 minutes:  "+zonedDateTime2);
		
		Month month = zonedDateTime1.getMonth();
		System.out.println("Month: "+month);
		
		LocalDate date = zonedDateTime1.toLocalDate();
		System.out.println("Date   :"+date);
		
		ZonedDateTime zonedDateTime3 = zonedDateTime1.withHour(8);
		System.out.println(" with hour as 8:  "+zonedDateTime3);
		
		boolean isBefore = zonedDateTime1.isBefore(zonedDateTime2);
		System.out.println(" Is before "+zonedDateTime2+"=" + isBefore);

	}

}
