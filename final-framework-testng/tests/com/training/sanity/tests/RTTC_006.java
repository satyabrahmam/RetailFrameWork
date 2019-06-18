package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
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
import com.training.pom.ChangePasswordPage;
import com.training.pom.LoginPOM;
import com.training.pom.MyAccountPage;
import com.training.pom.UserLoginPage;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

/**
 *  
 * @See This Test Case will Change the password
 */	

//Added TestNG Listeners 
@Listeners(com.training.generics.TestNgListener.class) 
public class RTTC_006 {
	
	private WebDriver driver;
	private String baseUrl;
	private BasesLoginPage baseLoginPage ;
	private UserLoginPage userLoginPage;
	private MyAccountPage myAccountPage;
	private static Properties properties;
	private ChangePasswordPage changePasswordPage;
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
		properties.load(inStream);
	}
	/**
	 * @Method  setUp : method will instantiate all required classes 
	 */
	@BeforeMethod
	public void setUp() throws Exception {
		extent = extentReport.getInstance();
		test = extent.startTest("Updating the Password Details");
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		baseLoginPage = new BasesLoginPage(driver,test); 
		userLoginPage = new UserLoginPage(driver,test);
		myAccountPage = new MyAccountPage(driver,test);
		changePasswordPage = new ChangePasswordPage(driver,test);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		driver.get(baseUrl);
	}

	/**
	 * @Method  changePasswordTest : method will login into the application and change the password
	 * 								
	 */
	@Test
	public void changePasswordTest() {
		// Calling Account DropDown List Button method in Base Login Page Class
		baseLoginPage.accountDropdownBtn();
		
		// Reading Username from properties file and passing to Loginpage class as username
		userLoginPage.sendUserName(properties.getProperty("username"));
		
		// Reading Password from properties file and passing to Loginpage class as password
		userLoginPage.sendPassword(properties.getProperty("password"));
		
		// To Capture the screenshots
		userLoginPage.clickLoginBtn();
		screenShot.captureScreenShot();
		myAccountPage.clickChangePasswordLink();
		screenShot.captureScreenShot();
		
		//below steps will change the password
		changePasswordPage.sendNewPassword("mehadi");
		changePasswordPage.sendConfirmPassword("mehadi");
		
		
		screenShot.captureScreenShot();
		changePasswordPage.clickcontinueBtn();		
		screenShot.captureScreenShot();
		
		if(myAccountPage.isPasswordChangeMessageDisplay())
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
		
		Thread.sleep(5000);
		extent.endTest(test);
		extent.flush();
		extent.close();
		driver.close();
	}

}
