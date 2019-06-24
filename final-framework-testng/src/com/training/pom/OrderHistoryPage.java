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
	
	//WebElement for View Icon Image
	@FindBy(xpath="//*[@class = 'table table-hover']/tbody/tr[1]/td[7]/a")
	private WebElement viewIconImg; 
	
	//Method will click on View Icon Image
	public void clickviewIconImg()
	{
		this.viewIconImg.click();
		test.log(LogStatus.INFO, "Clicked on View Order ICON Img");
	}
	
	//Method will return True or False for Order Information Page Title 
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
