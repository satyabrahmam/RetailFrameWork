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
import com.training.generics.GenericMethods;
import com.training.generics.ScreenShot;
import com.training.pom.AdminCategoriesPage;
import com.training.pom.AdminDashboard;
import com.training.pom.AdminLoginPage;
import com.training.pom.BasesLoginPage;
import com.training.pom.ChangePasswordPage;
import com.training.pom.MyAccountInfoPage;
import com.training.pom.MyAccountPage;
import com.training.pom.OrderHistoryPage;
import com.training.pom.UserLoginPage;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import com.trianing.waits.WaitTypes;

/**
 *  
 * @See To verify whether application allows admin to add category in categories page
 */	
//Added TestNG Listeners 
@Listeners(com.training.generics.TestNgListener.class) 

public class RTTC_038 {
	
	private WebDriver driver;
	private String adminBaseUrl;
	private static Properties properties;
	private AdminLoginPage adminLoginPage;
	private AdminDashboard adminDashboard ;
	private ScreenShot screenShot;
	private ExtentReports extent;
	private ExtentReport extentReport;
	private ExtentTest test;
	private WaitTypes waitType;
	private GenericMethods genericMethods;
	private AdminCategoriesPage adminCategoriesPage;
	
	
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
		test = extent.startTest("Verify add category in categories page");   
		driver = DriverFactory.getDriver(DriverNames.CHROME); 
		adminBaseUrl = properties.getProperty("adminBaseURL");
		genericMethods = new GenericMethods(driver);
		adminLoginPage = new AdminLoginPage(driver, test);
		adminDashboard = new AdminDashboard(driver, test);
		waitType = new WaitTypes(driver);
		adminCategoriesPage = new AdminCategoriesPage(driver, test);
		screenShot = new ScreenShot(driver); 
		driver.get(adminBaseUrl);		
	}
	
	/**
	 * @Method  addCategory : method will login into the application and add the Category 
	 */
	@Test
	public void addCategory() throws Exception
	{
		// Reading Username from properties file and passing to Admin Loginpage class as username 	
		adminLoginPage.sendAdminUserName(properties.getProperty("adminUserName"));
		
		// Reading Password from properties file and passing to Admin Loginpage class as password 
		adminLoginPage.sendAdminPassword(properties.getProperty("adminPassword"));
		
	
		adminLoginPage.clickAdminLoginBtn();
		
		//Actions class method is calling from GenericMethods class
		genericMethods.callingActionClassMethod(adminDashboard.getCataLogMenu());
		
		//Explicit wait method is calling from WaitTypes class
		waitType.elementToBeClickable(adminDashboard.getCategoriesOption(), 30);
		
		
		// To Capture the screenshots
		screenShot.captureScreenShot();
		
		adminCategoriesPage.clickOnAddBtn();
		
		//Entering below details in Category Page
		//Accessing the all values from Properties File
		adminCategoriesPage.sendCategoryName(properties.getProperty("categoryName"));
		screenShot.captureScreenShot();
		adminCategoriesPage.sendCategoryDescription(properties.getProperty("categoryDescription"));
		adminCategoriesPage.sendMetaTagTitle(properties.getProperty("metaTagTitle"));
		screenShot.captureScreenShot();
		adminCategoriesPage.sendMetaTagDesciption(properties.getProperty("metaTagDesciption"));
		adminCategoriesPage.clickOnSaveBtn();
		
		screenShot.captureScreenShot();
		
		//Verifying the Category added Message
		if(adminCategoriesPage.isCategoryAddedMessageDisplay())
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
