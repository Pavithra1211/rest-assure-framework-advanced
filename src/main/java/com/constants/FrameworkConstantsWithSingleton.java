package com.constants;

public class FrameworkConstantsWithSingleton {
	
	
	// Singleton - Single instance of a class at a particular point of time
	// Creational Design Pattern
	// Should not use places like creating webdriver
	// When there is setters involved, we can not use singleton
	// With only Getters we can use Singleton
	
	private static FrameworkConstantsWithSingleton INSTANCE = null;
	
	public static synchronized FrameworkConstantsWithSingleton getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new FrameworkConstantsWithSingleton();
		}
		return INSTANCE;
	}
	
	
	public final String REQUEST_JSON_PATH = System.getProperty("user.dir")+"/src/test/java/resources/jsons/";
	public final String RESPONSE_JSON_PATH = System.getProperty("user.dir")+"/Output/";
	
	
	
	
}
