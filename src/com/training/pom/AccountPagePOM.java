package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPagePOM {
	public AccountPagePOM(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
		
	@FindBy(xpath="//a[text()='Change your password']")
	private WebElement changePwdLink;
	
		
	public void clickChangePwdLink() {
	this.changePwdLink.click(); }
		
	
}