package com.actitime.generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass implements IAutoConstants {
	public static WebDriver driver;
	{
		System.setProperty(CHROME_KEY, CHROME_VALUE);
	}
	@BeforeMethod
	
	public void launchapp()
	{
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(URL);
	}
	@AfterMethod
	public void teardown(ITestResult it)
	{if(it.getStatus()==2){
		String name = it.getName();
		FWUtils.getSnapshot(driver, SNAPSHOT+name+".png");
		
	}
		
		driver.quit();
	}

}
