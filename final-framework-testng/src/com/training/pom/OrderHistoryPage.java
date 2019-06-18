package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class OrderHistoryPage {
	
	private WebDriver driver; 
	private ExtentTest test;	
		public OrderHistoryPage(WebDriver driver, ExtentTest test) {
			this.driver = driver; 
			this.test = test;
			PageFactory.initElements(driver, this);
		}
	
	@FindBy(xpath="//*[@title = 'View']")
	private WebElement viewIconImg; 

	public void clickviewIconImg()
	{
		this.viewIconImg.click();
		test.log(LogStatus.INFO, "Clicked on View Order ICON Img");
	}
	public boolean orderInfoPageTitle(String pageTitle)
	{
		if(pageTitle.equalsIgnoreCase("Order Information"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
