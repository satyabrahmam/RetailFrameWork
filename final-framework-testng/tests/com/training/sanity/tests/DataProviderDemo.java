package com.training.sanity.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;

public class DataProviderDemo {
	
	WebDriver driver;
	@BeforeClass
	  public void beforeClass() 
	  {

		  	System.setProperty("webdriver.chrome.driver", "C:\\Users\\AmbavarapuSatyabrahm\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				  
	  }
	@Test(dataProvider = "excel-inputs" , dataProviderClass = LoginDataProviders.class )
	public void login(String Firstname, String Lastname)
	{
		
		driver.get("http://retail.upskills.in/admin");
		driver.findElement(By.id("input-username")).sendKeys(Firstname);
		driver.findElement(By.id("input-password")).sendKeys(Lastname);
		driver.findElement(By.xpath("//*[@class = 'btn btn-primary']")).click();
		
	
	}

}
