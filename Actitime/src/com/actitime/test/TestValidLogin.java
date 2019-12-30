package com.actitime.test;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.actitime.generic.BaseClass;
import com.actitime.generic.FWUtils;
import com.actitime.pom.ActitimeLoginPage;

public class TestValidLogin extends BaseClass{
	@Test
	public void testVTC1() {
		ActitimeLoginPage lp = new ActitimeLoginPage(driver);
		String enterusername = FWUtils.getXLdata(DATA_PATH, "validinput", 1, 0);
		String enterpassword = FWUtils.getXLdata(DATA_PATH, "validinput", 1, 1);
		lp.getcredential(enterusername, enterpassword);
		lp.Clicklogin();
		String expectedTitle = FWUtils.getXLdata(DATA_PATH, "otherdata", 2, 0);
		WebDriverWait wait=new WebDriverWait(driver, ETO);
		wait.until(ExpectedConditions.titleContains(expectedTitle));
		FWUtils.varifyTile(driver, expectedTitle);
	//	Assert.fail();
		
		
		
	}
	
	
	



}
