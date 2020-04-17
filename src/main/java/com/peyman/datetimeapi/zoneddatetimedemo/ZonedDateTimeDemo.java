package com.peyman.datetimeapi.zoneddatetimedemo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZonedDateTimeDemo {

	public static void main(String[] args) {
		
		
		
		
		ZonedDateTime zonedDateTime = ZonedDateTime.now();
		System.out.println("ZonedDateTime1: "+zonedDateTime);
		
		ZoneId parisZoneId = ZoneId.of("Europe/Paris");
		zonedDateTime = ZonedDateTime.now(parisZoneId);
		System.out.println("ZonedDateTime2: "+zonedDateTime);
		
		LocalDate date = LocalDate.parse("1995-08-14");
		LocalTime time = LocalTime.parse("09:45");
		zonedDateTime = ZonedDateTime.of(date,time,ZoneId.systemDefault());
		System.out.println("ZonedDateTime3: "+zonedDateTime);
		
	}

}
