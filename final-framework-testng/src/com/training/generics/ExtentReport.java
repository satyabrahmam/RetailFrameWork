package com.training.generics;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;


public class ExtentReport {
	
	private static ExtentReports extent ;
	private ExtentTest test;
	
		public ExtentReport(ExtentTest test) {			
			this.test = test;			
		}
	 	
		public static ExtentReports getInstance()
		{
			
			extent = new ExtentReports(System.getProperty("user.dir")+"\\test-output\\ExtentReport.html",true);
			return extent;
			
		}
		
}
