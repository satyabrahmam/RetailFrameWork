package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AdminCategoriesPage {
	

	private WebDriver driver; 
	private ExtentTest test;	
	public AdminCategoriesPage(WebDriver driver, ExtentTest test) 
	{
			this.driver = driver; 
			this.test = test;
			PageFactory.initElements(driver, this);
	}
	
	//WebElement for Add Button 
	@FindBy(xpath="//*[@data-original-title = 'Add New']")
	private WebElement addBtn; 
	
	//WebElement for selection of category in Categories List
	@FindBy(xpath = "//*[@class = 'table table-bordered table-hover']/tbody/tr[1]/td/input" )
	private WebElement categorySelection;
	
	//WebElement for Edit Button
	@FindBy (xpath = "//*[@class = 'table table-bordered table-hover']/tbody/tr[1]/td[4]/a")
	private WebElement editBtn;
	
	//WebElement for Category Name Text Box 
	@FindBy(xpath="//*[@id = 'input-name1']")
	private WebElement categoryNameTxtbox; 
	
	//WebElement for Category Description Text Box 
	@FindBy(xpath="//*[@class = 'note-editable panel-body']")
	private WebElement categoryDescription; 
	
	//WebElement for Meta Tag Title Text Box 
	@FindBy(xpath="//*[@placeholder = 'Meta Tag Title']")
	private WebElement metaTagTitle; 
	
	//WebElement for Meta Tag Description Text Box
	@FindBy(xpath="//*[@placeholder = 'Meta Tag Description']")
	private WebElement metaTagDescription; 
	
	//WebElement for Save Button 
	@FindBy(xpath="//*[@class = 'fa fa-save']")
	private WebElement saveBtn; 
	
	//WebElement for "Category Added Success" Message 
	@FindBy(xpath = "//*[contains(text() ,'You have modified')]")
	private WebElement categoryAddedOrUpdatedMessage;
	
	
	
		
	//Method will click on Add Button
	public void clickOnAddBtn()
	{
		this.addBtn.click();
		test.log(LogStatus.INFO, "Clicked on Add Button in Categories Page");
	}
	
	//Method will enter Category Name in Category Name Text Box
	public void sendCategoryName(String categoryName)
	{
		this.categoryNameTxtbox.clear();
		this.categoryNameTxtbox.sendKeys(categoryName);
		test.log(LogStatus.INFO, "Added Category Name in Category Name Text Box");
	}
	
	//Method will enter Category Description in Category Description Text Box
	public void sendCategoryDescription(String description)
	{
		this.categoryDescription.clear();
		this.categoryDescription.sendKeys(description);
		test.log(LogStatus.INFO, "Added Category Description in Category Description Text Box");
	}
	
	//Method will enter Meta Tag Title in Meta Tag Title Text Box
	public void sendMetaTagTitle(String metaTagTitle)
	{
		this.metaTagTitle.clear();
		this.metaTagTitle.sendKeys(metaTagTitle);
		test.log(LogStatus.INFO, "Added Meta Tag Title in Meta Tag Title Text Box");
	}
	
	//Method will enter Meta Tag Description in Meta Tag Description Text Box
	public void sendMetaTagDesciption(String metaTagDescription)
	{
		this.metaTagDescription.clear();
		this.metaTagDescription.sendKeys(metaTagDescription);
		test.log(LogStatus.INFO, "Added Meta Tag Description in Meta Tag Description Text Box");
	}
	
	//Method will click on Save Button in Categories Page
	public void clickOnSaveBtn()
	{
		this.saveBtn.click();
		test.log(LogStatus.INFO, "Clicked on Save Button in Categories Page");
	}	
	
	//Method will click one of the Category in CategoryList
	public void clickOnCategorySelection()
	{
		this.categorySelection.click();
		test.log(LogStatus.INFO, "Selected one of the Category in CategoryList");
		
	}
	//Method will click on EditButton in CategoryList
	public void clickOnEditButton()
	{
		this.editBtn.click();
		test.log(LogStatus.INFO, "Clicked on EditButton in CategoryList");
	}
	//Method will return True or False for "Category Added or Modified Success" Message displayed in Categories Page
	public boolean isCategoryAddedMessageDisplay()
	{
		test.log(LogStatus.INFO, "Category Added or Modified Message has been displayed");
		return this.categoryAddedOrUpdatedMessage.isDisplayed();
		
	}
	
	
}
