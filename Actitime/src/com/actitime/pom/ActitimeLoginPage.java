package com.actitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActitimeLoginPage {
	@FindBy(id="username")
	private WebElement unTB;
	@FindBy(name="pwd")
	private WebElement pwTB;
	@FindBy(xpath="//div[text()='Login ']")
	private WebElement lgBT;
	@FindBy(xpath="//span[contains(text(),'invalid')]")
	private WebElement errMsg;
	
	public ActitimeLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
public void getcredential(String enterusername,String enterpassword ) {
	unTB.sendKeys(enterusername);
	pwTB.sendKeys(enterpassword);
}
public void Clicklogin() {
	lgBT.click();
}
	
}
