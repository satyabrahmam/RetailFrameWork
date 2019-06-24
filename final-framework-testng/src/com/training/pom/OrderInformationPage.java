package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class OrderInformationPage {
	
	private WebDriver driver; 
	private ExtentTest test;	
	public OrderInformationPage(WebDriver driver, ExtentTest test) 
	{
			this.driver = driver; 
			this.test = test;
			PageFactory.initElements(driver, this);
	}
	
	//WebElement for Order Return Image 
	@FindBy(xpath = "//*[@class = 'fa fa-reply']")
	private WebElement orderReturnImg;
	
	//Method will click on Order Return Image
	public void clickOnOrderReturnImg()
	{
		orderReturnImg.click();
		test.log(LogStatus.INFO, "User clicked on OrderReturnImg");
	}
	

}
