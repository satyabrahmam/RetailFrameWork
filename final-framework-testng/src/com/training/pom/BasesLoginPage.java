package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BasesLoginPage {
	
private WebDriver driver; 
private ExtentTest test;
	
	public BasesLoginPage(WebDriver driver, ExtentTest test) {
		this.driver = driver; 
		this.test = test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@class = 'fa fa-user-o']")
	public WebElement accountDropdown; 
	
	@FindBy(xpath="//*[@class = 'tb_link tb_menu_system_account_login']")
	private WebElement loginIDLink; 
	
	@FindBy(xpath="//*[contains(text(), 'MY ORDERS')]")
	public WebElement ordersLink; 
	
	public void accountDropdownBtn() {
		this.accountDropdown.click();
		test.log(LogStatus.INFO, "Clicked on Account DropDown Button");
	}
	
	public void loginIDLink() {
		this.loginIDLink.click(); 
		test.log(LogStatus.INFO, "Clicked on Login ID Link");
	}
	
	public void clickOrdersLink() {
		this.ordersLink.click(); 
		test.log(LogStatus.INFO, "Clicked on Orders Link");
	}
	public WebElement returnAccountDropDown() 
	{
		WebElement dropdownValue =  this.accountDropdown;
		return dropdownValue;
	}
	
}
