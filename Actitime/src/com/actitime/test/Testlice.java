package com.actitime.test;

import org.testng.annotations.Test;

import com.actitime.generic.BaseClass;
import com.actitime.generic.FWUtils;
import com.actitime.pom.ActitimeLoginPage;
import com.actitime.pom.EnterTimeTrackPage;
import com.actitime.pom.LicensePage;

public class Testlice extends BaseClass {
	@Test
	public void testlic() {
		ActitimeLoginPage lp = new ActitimeLoginPage(driver);
		String enterusername = FWUtils.getXLdata(DATA_PATH, "validinput", 1, 0);
		String enterpassword = FWUtils.getXLdata(DATA_PATH, "validinput", 1, 1);
		lp.getcredential(enterusername, enterpassword);
		lp.Clicklogin();
		EnterTimeTrackPage et=new EnterTimeTrackPage(driver);
		et.setting();
		et.lice();
		LicensePage l=new LicensePage(driver);
		String expected = FWUtils.getXLdata(DATA_PATH, "otherdata", 1, 0);
		l.varifylicVer(expected);
		
		
		

	}
}
