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
	
	//WebElement for FirstName Text Box
	@FindBy(name ="firstname")
	private WebElement firstname;
	
	//WebElement for LastName Text Box
	@FindBy(id ="input-lastname")
	private WebElement lastname;
	
	//WebElement for Email Text Box
	@FindBy(name ="email")
	private WebElement email;
	
	//WebElement for Telephone Text Box
	@FindBy(id ="input-telephone")
	private WebElement phoneNumber;
	
	//WebElement for Continue Button
	@FindBy(xpath ="//*[@class = 'btn btn-primary']")
	private WebElement continueBtn;
	
	//WebElement for "Account updated" message
	@FindBy(xpath = "//*[contains(text(), 'Your account has been successfully updated.')]")
	private WebElement accountUpdatedMsg;
	
	//Method will return True or False for "Account updated" message
	public boolean isYourAccountUpdated()
	{
		test.log(LogStatus.INFO, "Your Account Updated Message has been displayed");
		return this.accountUpdatedMsg.isDisplayed();
		
	}
	
	//Method will enter the FirstName text in FirstName Text Box
	public void sendFirstname(String firstname) {
		this.firstname.clear();
		this.firstname.sendKeys(firstname);
		test.log(LogStatus.INFO, "FirstName has been entered");
	}
	
	//Method will enter the LastName text in LastName Text Box
	public void sendLastname(String lastname) {
		this.lastname.clear();
		this.lastname.sendKeys(lastname);
		test.log(LogStatus.INFO, "LastName has been entered");
	}
	
	//Method will enter the Email text in Email Text Box
	public void sendEmail(String email) {
		this.email.clear();
		this.email.sendKeys(email);
		test.log(LogStatus.INFO, "Email has been entered");
	}
	
	//Method will enter the PhoneNumber in PhoneNumber Text Box
	public void sendPhoneNumber(String phoneNumber) {
		this.phoneNumber.clear();
		this.phoneNumber.sendKeys(phoneNumber);
		test.log(LogStatus.INFO, "PhoneNumber has been entered");
	}
	
	//Method will click on Continue Button
	public void clickContinueBtn()
	{
		this.continueBtn.click();
		test.log(LogStatus.INFO, "Clicked on Continue Button");
	}
	
}
