package com.utils;

import com.github.javafaker.Faker;

public final class FakerUtils {
	
	private FakerUtils() {
		
	}
	
	// Making accessibility to default to restrict accessing from other packages like tests or pojos
	
	static int fakeNumber(int start, int end) {
		return new Faker().number().numberBetween(start, end);
	}
	
	static String FakeFirstName() {
		return new Faker().name().firstName();
	}
	
	static String FakeLastName() {
		return new Faker().name().lastName();
	}

}
