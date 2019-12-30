package com.actitime.test;

import org.testng.annotations.Test;

import com.actitime.generic.BaseClass;
import com.actitime.generic.FWUtils;
import com.actitime.pom.ActitimeLoginPage;

public class TestInvalidlogin extends BaseClass {
	
	@Test
	public void InvalidTC1() {
		int count = FWUtils.getLastRownumber(DATA_PATH, "invalidinput");
		int count1 = FWUtils.getlastCellnumber(DATA_PATH, "invalidinput", 0);
		
		for (int i = 1; i <=count; i++) {
			for (int j = 0; j <=count1; j++) {
				
			
			FWUtils.getXLdata(DATA_PATH, "invalidinput", i,j );
				
		}
			ActitimeLoginPage lp = new ActitimeLoginPage(driver);
			
			lp.Clicklogin();
			
		}
	}
}
		
		
		
	
	
	


