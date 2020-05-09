package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangePwdPOM {
	public ChangePwdPOM(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-password")
	private WebElement pwd; 
	
	@FindBy(id="input-confirm")
	private WebElement confirmPwd; 

	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueButton;
	
		
	public void EnterEmail(String password) {
		this.pwd.clear();
		this.pwd.sendKeys(password);
	}
	
	public void ReEnterEmail(String cPassword) {
		this.confirmPwd.clear();
		this.confirmPwd.sendKeys(cPassword);
	}
	

	public void ClickContinueButton() {
		this.continueButton.click();
	}
}
