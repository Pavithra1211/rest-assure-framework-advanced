package com.report;


import com.aventstack.extentreports.ExtentTest;

public final class ExtentManager {

	
	private ExtentManager() {
		
	}
	
	private static ThreadLocal<ExtentTest> threadTest = new ThreadLocal<>();
	
	static ExtentTest getTest() {
		return threadTest.get();
	}
	static void setTest(ExtentTest test) {  // Making it default to restrict the access
		threadTest.set(test);
	}
	
}
