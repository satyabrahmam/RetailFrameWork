package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ChangePasswordPage {
	
private ExtentTest test;	
private WebDriver driver; 
	
	public ChangePasswordPage(WebDriver driver, ExtentTest test) {
		this.driver = driver; 
		this.test = test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@name = 'password']")
	private WebElement newPassword; 
	
	@FindBy(xpath="//*[@name = 'confirm']")
	private WebElement confirmPassword; 

	@FindBy(xpath="//*[@value = 'Continue']")
	private WebElement continueBtn; 

	public void sendNewPassword(String newPassword) {
		this.newPassword.clear();
		this.newPassword.sendKeys(newPassword);
		test.log(LogStatus.INFO, "New Password has been entered");
	}
	
	public void sendConfirmPassword(String confirmPassword) {
		this.confirmPassword.clear(); 
		this.confirmPassword.sendKeys(confirmPassword); 
		test.log(LogStatus.INFO, "Confirm Password has been entered");

	}
	public void clickcontinueBtn() {
		this.continueBtn.click(); 
		test.log(LogStatus.INFO, "Clicked on Continue button");

	}

}
