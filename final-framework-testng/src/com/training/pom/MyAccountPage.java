package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class MyAccountPage {
	
	private WebDriver driver; 
	private ExtentTest test;	
		public MyAccountPage(WebDriver driver, ExtentTest test) {
			this.driver = driver; 
			this.test = test;
			PageFactory.initElements(driver, this);
		}
	
		
	//WebElement for Edit Information Link
	@FindBy(xpath="//*[contains(text(), 'Edit your')]")
	private WebElement editInformationLink; 
	
	//WebElement for Change Password Link
	@FindBy(xpath="//*[contains(text(), 'Change')]")
	private WebElement ChangePasswordLink; 

	//WebElement for password Change Success Message
	@FindBy(xpath = "//*[contains(text(), 'Success: Your password')]")
	private WebElement passwordChangeMessage;
	
	
	//Method will click on Edit Information Link
	public void clickEditInfoLink()
	{
		this.editInformationLink.click();
		test.log(LogStatus.INFO, "Clicked on Edit Info Link");
	}
	
	//Method will click on Change Password Link
	public void clickChangePasswordLink() {
		this.ChangePasswordLink.click(); 
		test.log(LogStatus.INFO, "Clicked on Change Password Link");
	}
	
	//Method will return True or False for Passwrod Change Message 
	public boolean isPasswordChangeMessageDisplay()
	{
		test.log(LogStatus.INFO, "Password Change Message has been displayed");
		return this.passwordChangeMessage.isDisplayed();
		
	}
	
	

}
