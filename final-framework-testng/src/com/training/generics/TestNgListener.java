package com.training.generics;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestNgListener implements ITestListener {

	
	@Override
	public void onTestFailure(ITestResult result) {
		
		System.out.println("Test Case Failed :"+result.getName());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		System.out.println("Test Case Skipped :"+result.getName());
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		
		System.out.println("Test Case Started :"+result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		System.out.println("Test Case Passed :"+result.getName());
	}






	@Override
	public void onStart(ITestContext result) {
		
		
	}



	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}



	@Override
	public void onFinish(ITestContext arg0) {
		
	}

}
