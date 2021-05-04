 package com.qa.testscript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.qa.Page.AmazonPrime;


public class AmazonTestBase {
	WebDriver driver;
	AmazonPrime prime;
	
	@Parameters({"Browser","Url"})
	@BeforeClass
	public void setup(String Browser, String Url)
	{
		if(Browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "G:\\automation\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			prime=new AmazonPrime(driver);
			
		}
		driver.get(Url);
		
	}
	@AfterClass
	public void tearDown()
	{
		driver.close();
	}
	
	

}
