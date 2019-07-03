package com.training.sanity.tests;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.function.Consumer;

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
import com.training.bean.CategoryBean;
import com.training.bean.LoginBean;
import com.training.dao.UpSkillRetail;
import com.training.dao.UpSkillRetailCategoryTable;
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
 * @See This Test case will modify one of the Category in Categories List 
 */	
//Added TestNG Listeners 
@Listeners(com.training.generics.TestNgListener.class) 
public class RTTC_064 {

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
	private UpSkillRetail upSkillRetail;
	private LoginBean loginBean;
	private CategoryBean categoryBean;
	private UpSkillRetailCategoryTable upSkillRetailCategoryTable;
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
		upSkillRetail = new UpSkillRetail();
		upSkillRetailCategoryTable = new UpSkillRetailCategoryTable();
		adminProductsPage = new AdminProductsPage(driver, test);
		userShopPage = new UserShopPage(driver, test);
		waitType = new WaitTypes(driver);
		loginBean = new LoginBean();
		categoryBean = new CategoryBean();
		
		adminCategoriesPage = new AdminCategoriesPage(driver, test);
		screenShot = new ScreenShot(driver); 
		driver.get(adminBaseUrl);
		
	}
	
	@Test
	public void categoryModifying() throws Exception
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
		
		adminCategoriesPage.clickOnCategorySelection();
		adminCategoriesPage.clickOnEditButton();
				
		//Modifying the below values in one of the Category
		
		
		adminCategoriesPage.sendCategoryName("EARR");
		screenShot.captureScreenShot();
		
		adminCategoriesPage.sendCategoryDescription("Description");
		
		adminCategoriesPage.sendMetaTagTitle("metaTag");
		screenShot.captureScreenShot();
		
		adminCategoriesPage.sendMetaTagDesciption("metaTagDesciption");
		adminCategoriesPage.clickOnSaveBtn();
				
		screenShot.captureScreenShot();
		
		//Verify point for Category updation or Modification
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
	@AfterClass
	public void tearDown() throws Exception {
		
		extent.endTest(test);
		extent.flush();
		extent.close();
		driver.close();
	}

}
