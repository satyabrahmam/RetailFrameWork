package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
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
 * @See To Verify Category DB Table values with added Category values
 */	
public class RTTC_066 {


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
	public void verifyCategoryTableData() throws Exception
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
		
		//String addingCategoryName1 = "rama";
		String addingCategoryName = properties.getProperty("categoryName");
		adminCategoriesPage.sendCategoryName(addingCategoryName);
		screenShot.captureScreenShot();
		
		String addingCategoryDescription = properties.getProperty("categoryDescription");
		adminCategoriesPage.sendCategoryDescription(addingCategoryDescription);
		
		String addingMetaTagTitle = properties.getProperty("metaTagTitle");
		adminCategoriesPage.sendMetaTagTitle(addingMetaTagTitle);
		screenShot.captureScreenShot();
		
		String addingMetaTagDescription = properties.getProperty("metaTagDesciption");
		adminCategoriesPage.sendMetaTagDesciption(addingMetaTagDescription);
		adminCategoriesPage.clickOnSaveBtn();
		
		//Creating local variable for DB values
		screenShot.captureScreenShot();
		
		
		String categoryNameDB = "";
		String categoryDescriptionDB = "";
		String metaTagTitleDB = "";
		String metaTagTitleDescriptionDB = "";
		
		//will fetch values from Category table from DB
		Iterator<CategoryBean> categoryValues = upSkillRetailCategoryTable.getCategoryDetails().iterator();
		
		//storing DB values in local variables
		while(categoryValues.hasNext()) {
			categoryBean = categoryValues.next();
			categoryNameDB = categoryBean.getCategoryname();
			categoryDescriptionDB = categoryBean.getDescription();
			metaTagTitleDB = categoryBean.getMetaTagTitle();
			metaTagTitleDescriptionDB = categoryBean.getMetaTagDescription();
			
		}
		//Comparing added values with database values
		if(addingCategoryName.equalsIgnoreCase(categoryNameDB) && addingCategoryDescription.equalsIgnoreCase(categoryDescriptionDB) && addingMetaTagTitle.equalsIgnoreCase(metaTagTitleDB) && addingMetaTagDescription.equalsIgnoreCase(metaTagTitleDescriptionDB))
		{
			test.log(LogStatus.PASS, "Test Case Passed");
		}
		else
		{
			test.log(LogStatus.FAIL, "Test Case Failed");
			Assert.fail();
		}
		
			
		/**************LOGIN DETAILS FETCHING ********************/
		//LoginBean bean ;
		//Consumer<LoginBean> bean1 = null;
		//upSkillRetail.getLogins().forEach((x) -> System.out.println(x.getUserName()));
		
		/*
		Iterator<LoginBean> itr = upSkillRetail.getLogins().iterator();
		while(itr.hasNext()) {
			loginBean = itr.next();
			System.out.println(loginBean.getUserName());
		}*/
		
		//System.out.println(loginBean.getUserName());
		//System.out.println(loginBean.getPassword());
	}
	@AfterClass
	public void tearDown() throws Exception {
		
		extent.endTest(test);
		extent.flush();
		extent.close();
		driver.close();
	}


}
