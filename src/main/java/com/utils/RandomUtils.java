package com.utils;

public final class RandomUtils {
	
	// Business layer -  All the business level changes can be applied here
	
	private RandomUtils() {
		
	}

	public static int generateID() {
		return FakerUtils.fakeNumber(1000, 2000);
	}
	
	public static String generateFirstName() {
		return FakerUtils.FakeFirstName();
	}
	
	public static String generateLastName() {
		return FakerUtils.FakeLastName();
	}
	
	public static String generateEmail() {
		return generateFirstName()+"."+generateLastName()+"@Gmail.com";
	}
	
	
}
