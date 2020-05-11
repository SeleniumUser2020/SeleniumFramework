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
	
	@FindBy(xpath = "//*[@id=\"System_nyHsmShk\"]/align/ul/li[2]/a")
	private WebElement clickonChangePassword;
	
	
	@FindBy(id="input-password")
	private WebElement pwd; 
	
	@FindBy(id="input-confirm")
	private WebElement confirmPwd; 

	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueButton;
	
	
	
	
	
//######################################################################################
//  Secound Test CASe
//######################################################################################
	
	//@FindBy(xpath ="//*[@id=\"Menu_Wmt3OMY3\"]/nav/ul/li[2]/a")
	//private WebElement clickLoginPage; 

	

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
	
	public void clickChangePassword() {
		this.clickonChangePassword.click();	
	}
	
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
	
	
//######################################################################################
//  Secound  Test Case
//######################################################################################	
	
	/*public void clickOnLoginPage() {
		this.clickLoginPage.click();		
	}*/
	
	
}