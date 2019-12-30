package com.actitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnterTimeTrackPage {
	@FindBy(xpath="(//div[@class='menu_icon'])[1]")
	private WebElement settingbtn;
	@FindBy(linkText="Licenses")
	private WebElement licenselink;
	@FindBy(linkText="Logout")
	private WebElement logoutlink;
	
	public EnterTimeTrackPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void setting() {
		settingbtn.click();
	}
	public void lice() {
		licenselink.click();
	}
	
			

}
