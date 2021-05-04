package com.qa.testscript;


import java.io.IOException;

//import java.io.IOException;

import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.Utility.ExcelUtility;

public class TC_AmazonPrime extends AmazonTestBase
{
	@Test
	public void login()
	{
		prime.getLoginButton().click();
	}
	
	@Test(priority=1)
	public void signin() throws InterruptedException 
	{
		prime.getemail().sendKeys("rahulfrankenstain333@gmail.com");
		prime.getpassword().sendKeys("Amazon@2021");
		prime.getsignin().click();
		Thread.sleep(2000);
	}
	
	@Test(priority=2,dataProvider="supplyData")  
	public void search(String input1) throws InterruptedException
	{
		
		prime.getsearchBox().sendKeys(input1,Keys.ENTER);
		prime.getsearchBox().click();
		prime.getsearchBox().clear();
		Thread.sleep(2000);
		prime.getMovie().click();
		Thread.sleep(2000);

		 
//		prime.getsearchBox().click();
//		prime.getsearchBox().clear();
//		prime.getsearchBox().sendKeys(input1,Keys.ENTER);
//		prime.getMovie().click();
		
//		prime.WatchList().click();
//		
//		prime.getDropDown().click();
//		
//		prime.getWatchList().click();
	}
	
		@DataProvider
	public String[][] supplyData() throws IOException
	{
		String xlPath = "C:\\Users\\Rahul\\selenium\\SeleniumAutomation\\src\\test\\java\\com\\qa\\testdata\\TestData.xlsx";
		String xlSheet = "Sheet1";
		int rowCount =ExcelUtility.getRowCount(xlPath, xlSheet);
		int cellCount = ExcelUtility.getCellCount(xlPath, xlSheet, rowCount);
		String[][] data = new String[rowCount][cellCount];
		for(int i=1;i<=rowCount;i++)
		{
		for(int j=0;j<cellCount;j++)
			{
				data[i-1][j] =ExcelUtility.getCellData(xlPath, xlSheet, i, j);
			}
		}
		return data;
		
	}
	
		
	
//	@DataProvider
//	public Object[][] getData()
//	{
//		Object[][] data=new Object[3][1];
//		data[0][0]="Roberrt";
//		data[1][0]="Dia";
//		data[2][0]="Odeya";
//		return data;
//		
//		
//	}
	
	
}