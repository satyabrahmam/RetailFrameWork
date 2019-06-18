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
	
	@FindBy(xpath="//*[contains(text(), 'Edit your')]")
	private WebElement editInformationLink; 
	
	@FindBy(xpath="//*[contains(text(), 'Change')]")
	private WebElement ChangePasswordLink; 

	@FindBy(xpath = "//*[contains(text(), 'Success: Your password')]")
	private WebElement passwordChangeMessage;
	
	
	
	public void clickEditInfoLink()
	{
		this.editInformationLink.click();
		test.log(LogStatus.INFO, "Clicked on Edit Info Link");
	}
	
	public void clickChangePasswordLink() {
		this.ChangePasswordLink.click(); 
		test.log(LogStatus.INFO, "Clicked on Change Password Link");
	}
	
	public boolean isPasswordChangeMessageDisplay()
	{
		test.log(LogStatus.INFO, "Password Change Message has been displayed");
		return this.passwordChangeMessage.isDisplayed();
		
	}
	
	

}
