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
import com.training.pom.BasesLoginPage;
import com.training.pom.ChangePasswordPage;
import com.training.pom.MyAccountInfoPage;
import com.training.pom.MyAccountPage;
import com.training.pom.OrderHistoryPage;
import com.training.pom.OrderInformationPage;
import com.training.pom.ProductReturnPage;
import com.training.pom.UserLoginPage;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import com.trianing.waits.WaitTypes;

/**
 *  
 * @See To Verify whether application allows the user to return ordered product
 */	

//Added TestNG Listeners 
@Listeners(com.training.generics.TestNgListener.class) 

public class RTTC_036 {
	private WebDriver driver;
	private String baseUrl;
	private BasesLoginPage baseLoginPage ;
	private UserLoginPage userLoginPage;
	private MyAccountPage myAccountPage;
	private static Properties properties;
	private ChangePasswordPage changePasswordPage;
	private MyAccountInfoPage myAccountInfoPage;
	private OrderHistoryPage orderHistoryPage;
	private ScreenShot screenShot;
	private ExtentReports extent;
	private ExtentReport extentReport;
	private ExtentTest test;
	private WaitTypes waitType;
	private GenericMethods genericMethods;
	private OrderInformationPage orderInformationPage;
	private ProductReturnPage productReturnPage;
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
		test = extent.startTest("Verify the return Ordered Product");   
		driver = DriverFactory.getDriver(DriverNames.CHROME); 
		baseLoginPage = new BasesLoginPage(driver,test);   
		userLoginPage = new UserLoginPage(driver,test );
		myAccountPage = new MyAccountPage(driver,test);		
		myAccountInfoPage = new MyAccountInfoPage(driver,test);
		changePasswordPage = new ChangePasswordPage(driver,test);
		genericMethods = new GenericMethods(driver);
		orderHistoryPage = new OrderHistoryPage(driver,test);
		productReturnPage = new ProductReturnPage(driver, test);
		waitType = new WaitTypes(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		orderInformationPage = new OrderInformationPage(driver, test);
		driver.get(baseUrl);		
	}
	
	/**
	 * @Method  returnOrderedProduct : method To Verify whether application allows the user to return ordered product
	 */
	@Test
	public void returnOrderedProduct() throws Exception
	{
		// Calling Account DropDown List Button method in Base Login Page Class
		baseLoginPage.accountDropdownBtn(); 
		
		// Reading Username from properties file and passing to Loginpage class as username 
		userLoginPage.sendUserName(properties.getProperty("username")); 
		
		// Reading Password from properties file and passing to Loginpage class as password 
		userLoginPage.sendPassword(properties.getProperty("password"));
		
		userLoginPage.clickLoginBtn();
		
		// To Capture the screenshots
		screenShot.captureScreenShot();
		
		//Actions class method is calling from GenericMethods class
		genericMethods.callingActionClassMethod(baseLoginPage.getAccountDropdown());
		
		//Explicit wait method is calling from WaitTypes class
		waitType.elementToBeClickable(baseLoginPage.getOrdersLink(), 30);
		
		screenShot.captureScreenShot();
		//screenShot.captureScreenShot("REf"+ 1 );
		orderHistoryPage.clickviewIconImg();
		screenShot.captureScreenShot();
		
		//Below details will enter in Product Return Page
		orderInformationPage.clickOnOrderReturnImg();
		
		productReturnPage.clickOnReasonForReturnBtn();
		
		productReturnPage.sendProductName("ProductName");
		productReturnPage.sendProductCode("123");
		productReturnPage.clickedOnproductIsOpenedAsYesBtn();
		
		productReturnPage.sendFaultyCommentsTextBox("product is faulty");
		screenShot.captureScreenShot();
		
		productReturnPage.clickedOnSubmitBtn();
		screenShot.captureScreenShot();
		
		//Verifying the Product Return Success Message
		if(productReturnPage.productReturnThankMsgDisplayed())
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
