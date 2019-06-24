package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AdminLoginPage {
	
	private WebDriver driver; 
	private ExtentTest test;	
		public AdminLoginPage(WebDriver driver, ExtentTest test) {
			this.driver = driver; 
			this.test = test;
			PageFactory.initElements(driver, this);
		}

		//WebElement for User Name Text Box in Login Page
		@FindBy(name="username")
		private WebElement adminUsername; 
		
		//WebElement for Password Text Box in Login Page
		@FindBy(name="password")
		private WebElement adminPassword; 

		//WebElement for Login Button in Login Page
		@FindBy(xpath="//*[@class = 'btn btn-primary']")
		private WebElement adminLoginBtn; 
		
		//Method will Enter User Name in UserName Box 
		public void sendAdminUserName(String username) {
			this.adminUsername.clear();
			this.adminUsername.sendKeys(username);
			test.log(LogStatus.INFO, "Admin User Name  has been entered");
		}
		
		//Method will Enter Password in password Box 
		public void sendAdminPassword(String password) {
			this.adminPassword.clear(); 
			this.adminPassword.sendKeys(password); 
			test.log(LogStatus.INFO, "Admin Password has been entered");
		}
		
		//Method will click on Login Button
		public void clickAdminLoginBtn() {
			this.adminLoginBtn.click(); 
			test.log(LogStatus.INFO, "Clicked on Login Button");
		}
		
}
