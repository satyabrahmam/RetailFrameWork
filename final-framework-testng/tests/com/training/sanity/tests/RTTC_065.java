package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
import com.training.pom.AdminProductsPage;
import com.training.pom.BasesLoginPage;
import com.training.pom.UserShopPage;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import com.trianing.waits.WaitTypes;


/**
 *  
 * @See To Verify whether added product details get displayed in home screen
 */	
//Added TestNG Listeners 
@Listeners(com.training.generics.TestNgListener.class) 

public class RTTC_065 {


	private WebDriver driver;
	private String adminBaseUrl;
	private String baseUrl;
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
	private AdminProductsPage adminProductsPage;
	private BasesLoginPage basesLoginPage;
	private UserShopPage userShopPage;
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
		baseUrl =  properties.getProperty("baseURL");
		genericMethods = new GenericMethods(driver);
		adminLoginPage = new AdminLoginPage(driver, test);
		adminDashboard = new AdminDashboard(driver, test);
		basesLoginPage = new BasesLoginPage(driver, test);
		adminProductsPage = new AdminProductsPage(driver, test);
		userShopPage = new UserShopPage(driver, test);
		waitType = new WaitTypes(driver);
		adminCategoriesPage = new AdminCategoriesPage(driver, test);
		screenShot = new ScreenShot(driver); 
		driver.get(adminBaseUrl);		
	}
	
	@Test
	public void addProduct() throws Exception
	{
	
		// Reading Username from properties file and passing to Admin Loginpage class as username 	
		adminLoginPage.sendAdminUserName(properties.getProperty("adminUserName"));
		
		// Reading Password from properties file and passing to Admin Loginpage class as password 
		adminLoginPage.sendAdminPassword(properties.getProperty("adminPassword"));
		
	
		adminLoginPage.clickAdminLoginBtn();
		
		//Actions class method is calling from GenericMethods class
		genericMethods.callingActionClassMethod(adminDashboard.getCataLogMenu());
				
		//Explicit wait method is calling from WaitTypes class
		waitType.elementToBeClickable(adminDashboard.getProductsOption(), 30);
				
				
		// To Capture the screenshots
		screenShot.captureScreenShot();
		
		//To add Product 
		adminProductsPage.clickOnAddBtn();
		
		//below details will load in Product
		adminProductsPage.sendProductName("Finger Ring");
		adminProductsPage.sendMetaTagTitle("Finger Ring for ladies");
		adminProductsPage.clickDataTab();
		
		adminProductsPage.sendModel("SKU-012");
		adminProductsPage.sendPrice("500");
		adminProductsPage.sendQuantity("50");
		
		adminProductsPage.clickLinksTab();
		
		//
		String categoryName = "Necklace";
		adminProductsPage.sendCategoryName(categoryName);
		
		//driver.findElement(By.xpath("//*[@name = 'category']")).sendKeys("EARRINGS");
		adminProductsPage.clickCategoryDropDownTab();
		adminProductsPage.clickOnSaveBtn();
		
		adminDashboard.clickOnLogout();
		
		//Navigate to User's URL
		driver.navigate().to(baseUrl);
		
		
		genericMethods.callingActionClassMethod(basesLoginPage.getshopDropdown());
		
		//Explicit wait method is calling from WaitTypes class
		waitType.elementToBeClickable(basesLoginPage.getnecklaceLink(), 30);
		
		//To get List for number of Displayed Products in Category 
		String locator = "//*[@class = 'row tb_gut_xs_10']/div/h4/a" ;
		List<WebElement> list = genericMethods.getElementsAsList(locator, "xpath");
		
		//List<WebElement> list = driver.findElements(By.xpath("//*[@class = 'row tb_gut_xs_10']/div/h4/a"));
		//System.out.println(list.size());
		int count = 0;
		for(int i = 0; i<list.size();i++)
		{
			String actualtext = list.get(i).getText();
			if(actualtext.equalsIgnoreCase("Finger Ring"))
			{
				count = count + 1;
				break;
				
			}
			
		}
		if(count == 1)
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
