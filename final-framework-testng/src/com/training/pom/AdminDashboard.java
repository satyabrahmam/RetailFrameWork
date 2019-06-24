package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AdminDashboard {
	
	private WebDriver driver; 
	private ExtentTest test;	
	public AdminDashboard(WebDriver driver, ExtentTest test) 
	{
			this.driver = driver; 
			this.test = test;
			PageFactory.initElements(driver, this);
	}
	
	//WebElement for CataLog Menu in Dashboard Page
	@FindBy(xpath="//*[@id = 'menu-catalog']")
	private WebElement cataLogMenu; 
	
	//WebElement for Categories Option in CataLog Menu in Dashboard Page
	@FindBy(xpath="//*[@id = 'menu-catalog']/ul/li[1]/a")
	private WebElement categoriesOption; 
	
	//Method will get CataLog Menu in Dashboard Page
	public WebElement getCataLogMenu() {
		return cataLogMenu;
	}

	//Method will get Categories Option in CataLog Menu in Dashboard Page
	public WebElement getCategoriesOption() {
		return categoriesOption;
	}

	//Method will click on Categories Option in CataLog Menu in Dashboard Page
	public void clickOnCategoriesOption() {
		this.categoriesOption.click(); 
		test.log(LogStatus.INFO, "Clicked on Categories Button");
	}
	
	
}
