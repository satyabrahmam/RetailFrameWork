package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

public class UserShopPage {
	
	private WebDriver driver; 
	private ExtentTest test;	
	public UserShopPage(WebDriver driver, ExtentTest test) 
	{
			this.driver = driver; 
			this.test = test;
			PageFactory.initElements(driver, this);
	}
	
	//WebElement for list
	@FindBy(xpath="//*[@class = 'row tb_gut_xs_10']/div/h4/a")
	private WebElement listInNecklace;
	
	//Method will get the List in NECKLACE Table
	public WebElement getListInNecklace() {
		return listInNecklace;
	} 
	
	

}
