package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class LoginPOM {
	public LoginPOM(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//######################################################################################
//  Applicaiton Login with Valid UserID and Password
//######################################################################################
	
	@FindBy(xpath ="//*[@id=\"Menu_Wmt3OMY3\"]/nav/ul/li[2]/a")
	private WebElement clickLoginPage; 
	
	@FindBy(id ="input-email")
	private WebElement enterUserId; 
	
	@FindBy(id ="input-password")
	private WebElement enterPassword;
	
	@FindBy(xpath ="//input[@type = 'submit']")
	private WebElement clickLogin;

	

//######################################################################################
//  Applicaiton Login with Valid UserID and Password
//######################################################################################
	public void clickOnLoginPage() {
		this.clickLoginPage.click();		
	}
	
	public void enterUserName(String enterUserId) {
		this.enterUserId.sendKeys(enterUserId);		
	}
	
	
	public void enterUserPassword(String enterPassword) {
		this.enterPassword.sendKeys(enterPassword);		
	}
	
	public void clickOnLogin() {
		this.clickLogin.click();		
	}
	
	
		
	
}