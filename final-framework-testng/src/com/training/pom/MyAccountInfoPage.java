package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.training.generics.ExtentReport;

public class MyAccountInfoPage {
	
private WebDriver driver; 
private ExtentTest test;	
	public MyAccountInfoPage(WebDriver driver, ExtentTest test) {
		this.driver = driver; 
		this.test = test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name ="firstname")
	private WebElement firstname;
	
	@FindBy(id ="input-lastname")
	private WebElement lastname;
	
	@FindBy(name ="email")
	private WebElement email;
	
	@FindBy(id ="input-telephone")
	private WebElement phoneNumber;
	
	@FindBy(xpath ="//*[@class = 'btn btn-primary']")
	private WebElement continueBtn;
	
	@FindBy(xpath = "//*[contains(text(), 'Your account has been successfully updated.')]")
	private WebElement accountUpdatedMsg;
	
	public boolean isYourAccountUpdated()
	{
		test.log(LogStatus.INFO, "Your Account Updated Message has been displayed");
		return this.accountUpdatedMsg.isDisplayed();
		
	}
	public void sendFirstname(String firstname) {
		this.firstname.clear();
		this.firstname.sendKeys(firstname);
		test.log(LogStatus.INFO, "FirstName has been entered");
	}
	public void sendLastname(String lastname) {
		this.lastname.clear();
		this.lastname.sendKeys(lastname);
		test.log(LogStatus.INFO, "LastName has been entered");
	}
	public void sendEmail(String email) {
		this.email.clear();
		this.email.sendKeys(email);
		test.log(LogStatus.INFO, "Email has been entered");
	}
	public void sendPhoneNumber(String phoneNumber) {
		this.phoneNumber.clear();
		this.phoneNumber.sendKeys(phoneNumber);
		test.log(LogStatus.INFO, "PhoneNumber has been entered");
	}
	
	public void clickContinueBtn()
	{
		this.continueBtn.click();
		test.log(LogStatus.INFO, "Clicked on Continue Button");
	}
	
}
