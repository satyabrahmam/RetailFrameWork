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
	
	
	//WebElement for New Password Text Box
	@FindBy(xpath="//*[@name = 'password']")
	private WebElement newPassword; 
	
	//WebElement for Confirm Password Text Box
	@FindBy(xpath="//*[@name = 'confirm']")
	private WebElement confirmPassword; 

	//WebElement for Continue Button 
	@FindBy(xpath="//*[@value = 'Continue']")
	private WebElement continueBtn; 

	//Method will Enter New Password in New password Text Box 
	public void sendNewPassword(String newPassword) {
		this.newPassword.clear();
		this.newPassword.sendKeys(newPassword);
		test.log(LogStatus.INFO, "New Password has been entered");
	}
	
	//Method will Enter Confirm Password in Confirm password Text Box 
	public void sendConfirmPassword(String confirmPassword) {
		this.confirmPassword.clear(); 
		this.confirmPassword.sendKeys(confirmPassword); 
		test.log(LogStatus.INFO, "Confirm Password has been entered");

	}
	
	//Method will click on Continue Button
	public void clickcontinueBtn() {
		this.continueBtn.click(); 
		test.log(LogStatus.INFO, "Clicked on Continue button");

	}

}
