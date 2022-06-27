package com.listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.annotations.FrameworkAnnotations;
import com.report.ExtentLogger;
import com.report.ReportUtil;
import com.utils.JiraUtils;

public class TestListener implements ITestListener, ISuiteListener {

	@Override
	public void onStart(ISuite suite) {
		ReportUtil.initReports();
		
	}

	@Override
	public void onFinish(ISuite suite) {
		ReportUtil.tearDown();
		
	}

	@Override
	public void onTestStart(ITestResult result) {
//		To create tests on the basis of description given in annotation
//		String description = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).description();
//		ReportUtil.createTest(description);
		ReportUtil.createTest(result.getName());
		// Find the authors and categories using method reflect and the pass them to reportutil methods to add to extent report
		String[] authors = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).author();
		ReportUtil.addAuthor(authors);
		String[] categories = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).catagory();
		ReportUtil.addCategory(categories);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentLogger.pass(result.getName() + " is passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ExtentLogger.fail(String.valueOf(result.getThrowable()));
		
//		String issue = JiraUtils.createIssueInJira(String.valueOf(result.getThrowable()));
//		ExtentLogger.fail("Issue created in Jira "+ "http://localhost:8080/browse/"+issue);
		
	}


}
