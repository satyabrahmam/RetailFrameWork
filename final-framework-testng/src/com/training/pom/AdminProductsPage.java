package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AdminProductsPage {
	
	private WebDriver driver; 
	private ExtentTest test;	
	public AdminProductsPage(WebDriver driver, ExtentTest test) 
	{
			this.driver = driver; 
			this.test = test;
			PageFactory.initElements(driver, this);
	}
	//WebElement for Add Button 
	@FindBy(xpath="//*[@data-original-title = 'Add New']")
	private WebElement addBtn; 
		
	//WebElement for Product Name Text Box 
	@FindBy(xpath="//*[@id = 'input-name1']")
	private WebElement ProductNameTxtbox; 
	
	//WebElement for Meta Tag Title Text Box 
	@FindBy(xpath="//*[@id = 'input-meta-title1']")
	private WebElement metaTagTitle; 
	
	//WebElement for Data tab  
	@FindBy(xpath="//*[text() = 'Data']")
	private WebElement dataTab; 
		
	//WebElement for Model Text Box 
	@FindBy(xpath="//*[@id = 'input-model']")
	private WebElement modelTxtbox; 
	
	//WebElement for Price Text Box 
	@FindBy(xpath="//*[@id = 'input-price']")
	private WebElement priceTxtbox; 
	
	//WebElement for Quantity Text Box 
	@FindBy(xpath="//*[@id = 'input-quantity']")
	private WebElement quantityTxtbox; 
	
	//WebElement for Links tab  
	@FindBy(xpath="//*[text() = 'Links']")
	private WebElement linksTab; 
	
	//WebElement for Categories Text Box 
	@FindBy(xpath="//*[@name = 'category']")
	private WebElement categoryTxtbox; 
		
	//WebElement for Categories Dropdown
	@FindBy(xpath="//*[@name = 'category']/parent::div/ul/li[1]")
	private WebElement categoryDropDown;
		
	//WebElement for Save Button 
	@FindBy(xpath="//*[@class = 'fa fa-save']")
	private WebElement saveBtn; 
	
	//Method will click on Add Button
	public void clickOnAddBtn()
	{
			this.addBtn.click();
			test.log(LogStatus.INFO, "Clicked on Add Button in Products Page");
	}
	

	//Method will enter Product Name in Product Name Text Box
	public void sendProductName(String ProductName)
	{
		this.ProductNameTxtbox.clear();
		this.ProductNameTxtbox.sendKeys(ProductName);
		test.log(LogStatus.INFO, "Added Product Name in Product Name Text Box");
	}
	
	//Method will enter Meta Tag Title in Meta Tag Title Text Box
	public void sendMetaTagTitle(String metaTagTitle)
	{
		this.metaTagTitle.clear();
		this.metaTagTitle.sendKeys(metaTagTitle);
		test.log(LogStatus.INFO, "Added Meta Tag Title in Meta Tag Title Text Box");
	}
	
	//Method will click on Data tab
	public void clickDataTab()
	{
		this.dataTab.click();
		test.log(LogStatus.INFO, "Clicked on Data Tab in Products Page");
	}
	
	//Method will enter Model in Model Text Box
	public void sendModel(String model)
	{
		this.modelTxtbox.clear();
		this.modelTxtbox.sendKeys(model);
		test.log(LogStatus.INFO, "Added Model in Model Text Box");
	}
	
	//Method will enter Price in Price Text Box
	public void sendPrice(String price)
	{
		this.priceTxtbox.clear();
		this.priceTxtbox.sendKeys(price);
		test.log(LogStatus.INFO, "Added Price in Price Text Box");
	}
	
	//Method will enter Quantity in Quantity Text Box
	public void sendQuantity(String quantity)
	{
		this.quantityTxtbox.clear();
		this.quantityTxtbox.sendKeys(quantity);
		test.log(LogStatus.INFO, "Added Quantity in Quantity Text Box");
	}
	
	//Method will click on Data tab
	public void clickLinksTab()
	{
		this.linksTab.click();
		test.log(LogStatus.INFO, "Clicked on Links Tab in Products Page");
	}
	
	//Method will enter Category Name in Category Name Text Box
	public void sendCategoryName(String categoryName)
	{
		this.categoryTxtbox.clear();
		this.categoryTxtbox.sendKeys(categoryName);
		test.log(LogStatus.INFO, "Added Category Name in Category Name Text Box");
	}
	
	//Method will click on Category value in Products Page
	public void clickCategoryDropDownTab()
	{
		this.categoryDropDown.click();
		test.log(LogStatus.INFO, "Selected Category value in Products Page");
	}
	

	//Method will click on Save Button in Products Page
	public void clickOnSaveBtn()
	{
		this.saveBtn.click();
		test.log(LogStatus.INFO, "Clicked on Save Button in Products Page");
	}
	
}
