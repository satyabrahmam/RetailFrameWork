package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ProductReturnPage {
	
	private WebDriver driver; 
	private ExtentTest test;	
	public ProductReturnPage(WebDriver driver, ExtentTest test) 
	{
			this.driver = driver; 
			this.test = test;
			PageFactory.initElements(driver, this);
	}
	
	//WebElement for Reason for Return Button
	@FindBy(xpath = "//*[@name = 'return_reason_id' and @value = '1']")
	private WebElement reasonForReturnBtn;

	//WebElement for Product Name Text Box
	@FindBy(xpath = "//*[@name = 'product']")
	private WebElement productNameTextBox;
		
	//WebElement for Product Code Text Box
	@FindBy(xpath = "//*[@name = 'model']")
	private WebElement productCodeTextBox;
			
	//WebElement for Product IS Opened As Yes Button
	@FindBy(xpath = "//*[@name = 'opened' and @value = '1']")
	private WebElement productIsOpenedAsYesBtn;
	
	//WebElement for Falty Comments Text Box
	@FindBy(name = "comment")
	private WebElement faultyCommentsTxtBox;
	
	//WebElement for Submit Button
	@FindBy(xpath = "//*[@value = 'Submit']")
	private WebElement submitBtn;
	
	//WebElement for Product Return Thank Message
	@FindBy(xpath = "//*[contains(text(), 'Thank you for submitting your return request')]")
	private WebElement productReturnThankYouMsg;
	
	//Method will click On Reason for Return Button
	public void clickOnReasonForReturnBtn()
	{
		reasonForReturnBtn.click();
		test.log(LogStatus.INFO, "User clicked on One Of The Reason For Return Radio Button");
	}
	
	//Method will enter the Product Name in Product Name Text Box
	public void sendProductName(String productName)
	{				
		this.productNameTextBox.clear();
		this.productNameTextBox.sendKeys(productName);
		test.log(LogStatus.INFO, "Product Name has been entered in Product Name Text Box");			
			
	}
	
	//Method will enter the Product Code in Product Code Text Box
	public void sendProductCode(String productCode)
	{				
		this.productCodeTextBox.clear();
		this.productCodeTextBox.sendKeys(productCode);
		test.log(LogStatus.INFO, "Product Code has been entered in Product Code Text Box");			
			
	}
	
	//Method will click on Product is Opened As Yes Button
	public void clickedOnproductIsOpenedAsYesBtn()
	{
		productIsOpenedAsYesBtn.click();
		test.log(LogStatus.INFO, "User clicked on Yes for Product is Opended Radio Button");
	}
	
	//Method will enter Comments in Falty Comments Text Box
	public void sendFaultyCommentsTextBox(String comment) {
		this.faultyCommentsTxtBox.clear();
		this.faultyCommentsTxtBox.sendKeys(comment);
		test.log(LogStatus.INFO, "Comments Entered in Faulty or Other Details Text Box");
	}
	
	//Method will click on Submit Button
	public void clickedOnSubmitBtn()
	{
		submitBtn.click();
		test.log(LogStatus.INFO, "User clicked on Submitted Button");
	}
	
	//Method will return True or False for Product Return Thank Message
	public boolean productReturnThankMsgDisplayed()
	{
		test.log(LogStatus.INFO, "Product Return Thank You Message has been Displayed");
		return this.productReturnThankYouMsg.isDisplayed();
		
	}
}
