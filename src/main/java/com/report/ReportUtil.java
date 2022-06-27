package com.report;

import java.io.File;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public final class ReportUtil {
	
	private ReportUtil() {
		
	}
	
	private static ExtentReports Extent;
	private static ExtentTest test;
	
	
	public static void initReports() {
		Extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter(new File(System.getProperty("user.dir") + "/index.html"));
		Extent.attachReporter(spark);
	}
	
	public static void createTest(String name) {
		test = Extent.createTest(name);
		ExtentManager.setTest(test);
	}
	
	public static void addAuthor(String[] authors) {
		for(String author: authors) {
			ExtentManager.getTest().assignAuthor(author);
		}
	}
	
	public static void addCategory(String[] categories) {
		for(String category: categories) {
			ExtentManager.getTest().assignCategory(category);
		}
	}
	
	public static void tearDown() {
		Extent.flush();
	}
	

}
