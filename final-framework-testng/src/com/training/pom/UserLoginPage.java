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
	
	//WebElement for UserName Text Box
	@FindBy(xpath="//*[@name = 'email']")
	private WebElement username; 
	
	//WebElement for Password Text Box
	@FindBy(xpath="//*[@name = 'password']")
	private WebElement password; 

	//WebElement for Login Button
	@FindBy(xpath="//*[@value = 'Login']")
	private WebElement loginBtn; 
	
	//WebElment for Invalid UserName or Password Error Message
	@FindBy(xpath = "//*[contains(text(), 'No match for E-Mail Address')]")
	private WebElement invalidUsrOrPwdMsg;
	
	//Method will return True or False for Invalid UserName or Password Error Message
	public boolean isUsrOrPwdInvalid()
	{
		test.log(LogStatus.INFO, "No match for E-Mail Address and/or Password");
		return this.invalidUsrOrPwdMsg.isDisplayed();
		
	}
	
	//Method will Enter User Name in UserName Box
	public void sendUserName(String username) {
		this.username.clear();
		this.username.sendKeys(username);
		test.log(LogStatus.INFO, "User Name  has been entered");
	}
	
	//Method will Enter Password in password Box 
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
		test.log(LogStatus.INFO, "Password has been entered");
	}
	
	//Method will click on Login Button
	public void clickLoginBtn() {
		this.loginBtn.click(); 
		test.log(LogStatus.INFO, "Clicked on Login Button");
	}
}
