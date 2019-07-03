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
	
	//WebElement for Account Drop Down link 
	@FindBy(xpath="//*[@class = 'fa fa-user-o']")
	private WebElement accountDropdown; 
	
	//WebElement for Login ID link
	@FindBy(xpath="//*[@class = 'tb_link tb_menu_system_account_login']")
	private WebElement loginIDLink; 
	
	//WebElement for Orders link
	@FindBy(xpath="//*[contains(text(), 'MY ORDERS')]")
	private WebElement ordersLink; 
	
	//WebElement for Account Drop Down link 
	@FindBy(xpath="//*[text() = 'Shop']")
	private WebElement shopDropdown; 
	
	//WebElement for Necklace link
	@FindBy(xpath="//*[@class = 'tb_menu_category_Gd1U2 tb_link']")
	private WebElement necklaceLink; 
		
	//Method will get the SHOP Drown Down Link
	public WebElement getshopDropdown() {
		return shopDropdown;
	}
	
	////Method will get the NECKLACE Link
	public WebElement getnecklaceLink() {
		return necklaceLink;
	}
	
	//Method will get Account Drop Down link
	public WebElement getAccountDropdown() {
		return accountDropdown;
	}

	//Method will get Orders link
	public WebElement getOrdersLink() {
		return ordersLink;
	}
	//Method will click Account Drop Down link 
	public void accountDropdownBtn() {
		this.accountDropdown.click();
		test.log(LogStatus.INFO, "Clicked on Account DropDown Button");
	}
	
	//Method will click Login ID link 
	public void loginIDLink() {
		this.loginIDLink.click(); 
		test.log(LogStatus.INFO, "Clicked on Login ID Link");
	}
	
	//Method will click Orders link 
	public void clickOrdersLink() {
		this.ordersLink.click(); 
		test.log(LogStatus.INFO, "Clicked on Orders Link");
	}
	
	
}
