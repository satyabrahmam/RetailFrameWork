package com.training.sanity.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.readexcel.ApachePOIExcelRead;

public class ExcelReadingDemo {
	WebDriver driver;
	ApachePOIExcelRead aa ;
	@BeforeClass
	
	  public void beforeClass() 
	  {

		  	System.setProperty("webdriver.chrome.driver", "C:\\Users\\AmbavarapuSatyabrahm\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("http://elearning.upskills.in/");
				  
	  }
	@Test
	public void login() throws IOException
	{
		
		aa = new ApachePOIExcelRead();
		
		
		String [][] as = aa.getExcelContent("C:\\Users\\AmbavarapuSatyabrahm\\Videos\\java\\Complex cases data.xlsx");
		
		driver.get("http://elearning.upskills.in/");
		
		for(int i = 2 ;i<as.length;i++)
		{
			
			
			driver.findElement(By.xpath("//*[text() = ' Sign up! ']")).click();
			driver.findElement(By.id("registration_firstname")).sendKeys(as[i][2]);
			driver.findElement(By.id("registration_lastname")).sendKeys(as[i][3]);
			driver.findElement(By.id("registration_email")).sendKeys(as[i][4]);
			driver.findElement(By.name("username")).sendKeys(as[i][5]);
			driver.findElement(By.name("pass1")).sendKeys(as[i][6]);
			driver.findElement(By.name("pass2")).sendKeys(as[i][7]);
			driver.findElement(By.id("registration_phone")).sendKeys(as[i][8]);
			driver.findElement(By.id("registration_submit")).click();
		
			driver.findElement(By.xpath("//*[@class = 'img-circle']")).click();
			
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(By.id("logout_button"))).click();
			
			
			if(i == 3)
			{
				break;
			}
			//driver.findElement(By.id("input-username")).sendKeys(as[i][0]);
			//driver.findElement(By.id("input-password")).sendKeys(as[i][1]);
			//driver.findElement(By.xpath("//*[@class = 'btn btn-primary']")).click();
			
			
		/*
		
		String[][] list = null;
		File file = new File("C:\\Users\\AmbavarapuSatyabrahm\\Videos\\java\\asd.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		XSSFWorkbook workBook = new XSSFWorkbook(fileInputStream);
		XSSFSheet sheet = workBook.getSheetAt(0);		
		
		int rowNum = sheet.getLastRowNum();
		//System.out.println(sheet.getLastRowNum());
		
		System.out.println("row "+rowNum);
		if(rowNum > 0)
		{
			for(int i = 0 ; i<=rowNum; i++)
			{
				Row row = sheet.getRow(i);
				int colNum = row.getLastCellNum();
				System.out.println("col : "+colNum);
				list = new String[rowNum+1][colNum];
				
				for(int j = 0; j<colNum; j++)
				{
					 String value = sheet.getRow(i).getCell(j).toString();
					 System.out.println(value);
					 list[i][j] = value;
				}
			}
		}
		
		*/
		
	}
	}
}
