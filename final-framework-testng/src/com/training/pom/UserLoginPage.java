package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class UserLoginPage {
	private WebDriver driver; 
	private ExtentTest test;	
		public UserLoginPage(WebDriver driver, ExtentTest test) {
			this.driver = driver; 
			this.test = test;
			PageFactory.initElements(driver, this);
		}
	
	@FindBy(xpath="//*[@name = 'email']")
	private WebElement username; 
	
	@FindBy(xpath="//*[@name = 'password']")
	private WebElement password; 

	@FindBy(xpath="//*[@value = 'Login']")
	private WebElement loginBtn; 

	public void sendUserName(String username) {
		this.username.clear();
		this.username.sendKeys(username);
		test.log(LogStatus.INFO, "User Name  has been entered");
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
		test.log(LogStatus.INFO, "Password has been entered");
	}
	public void clickLoginBtn() {
		this.loginBtn.click(); 
		test.log(LogStatus.INFO, "Clicked on Login Button");
	}
}
