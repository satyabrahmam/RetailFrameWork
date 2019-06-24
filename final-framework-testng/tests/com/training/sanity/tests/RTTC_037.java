package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.training.generics.ExtentReport;
import com.training.generics.ScreenShot;
import com.training.pom.BasesLoginPage;
import com.training.pom.UserLoginPage;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import com.trianing.waits.WaitTypes;

/**
 *  
 * @See To verify whether application denies admin getting logged in upon entering invalid 
 * credentials in required field



 */	

//Added TestNG Listeners 
@Listeners(com.training.generics.TestNgListener.class) 
public class RTTC_037 {
	
	private WebDriver driver;
	private static Properties properties;
	private String baseUrl;
	private BasesLoginPage baseLoginPage ;
	private UserLoginPage userLoginPage;
	private ScreenShot screenShot;
	private ExtentReports extent;
	private ExtentReport extentReport;
	private ExtentTest test;
		
	/**
	 * @Method  setUpBeforeClass : method will Load the Properties File 
	 */	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);  // Loading Properties File
	}
	/**
	 * @Method  setUp : method will instantiate all required classes 
	 */	
	@BeforeMethod
	public void setUp() throws Exception {
		
		extent = extentReport.getInstance();   
		test = extent.startTest("Verify User Credentials");   
		driver = DriverFactory.getDriver(DriverNames.CHROME); 
		baseLoginPage = new BasesLoginPage(driver,test);   
		userLoginPage = new UserLoginPage(driver,test );
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		driver.get(baseUrl);		
	}
	/**
	 * @Method  verifyUserCredentials : method will try to login into the application with invalid 
	 * credentials in required field
	 */
	@Test
	public void verifyUserCredentials() throws Exception
	{
		// Calling Account DropDown List Button method in Base Login Page Class
		baseLoginPage.accountDropdownBtn(); 
		screenShot.captureScreenShot();
		// Reading Username from properties file and passing to Loginpage class as username 
		userLoginPage.sendUserName(properties.getProperty("username")); 
		
		// Reading Password from properties file and passing to Loginpage class as password 
		userLoginPage.sendPassword("mehadd");
		
		screenShot.captureScreenShot();
		
		userLoginPage.clickLoginBtn();
		screenShot.captureScreenShot();
		
		//Verifying the Invalid UserName or Password Errpr Message
				if(userLoginPage.isUsrOrPwdInvalid())
				{
					
					test.log(LogStatus.PASS, "Test Case Passed");
				
				}
				else
				{
					test.log(LogStatus.FAIL, "Test Case Failed");
					Assert.fail();
					
				}
				
	}

	/**
	 * @Method  tearDown : method will close the all instances 
	 */	
	@AfterClass
	public void tearDown() throws Exception {
		
		extent.endTest(test);
		extent.flush();
		extent.close();
		driver.close();
	}
}
