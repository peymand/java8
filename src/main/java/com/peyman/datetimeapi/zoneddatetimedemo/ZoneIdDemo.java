package com.peyman.datetimeapi.zoneddatetimedemo;

import java.time.LocalTime;
import java.time.ZoneId;

public class ZoneIdDemo {

	public static void main(String[] args) {
		
		ZoneId currentTimeZone = ZoneId.systemDefault();
		System.out.println("Current time: "+LocalTime.now(currentTimeZone));
		
		ZoneId australiaTimeZone = ZoneId.of("Australia/Sydney");
		System.out.println("Australia time: "+LocalTime.now(australiaTimeZone));
		
		ZoneId parisTimeZone = ZoneId.of("GMT+2");
		System.out.println("Paris time: "+LocalTime.now(parisTimeZone));

	}

}
