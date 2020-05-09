package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPagePOM {
	public LoginPagePOM(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
		
	@FindBy(id="input-email")
	private WebElement email; 
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginButton;
	
		
	public void sendUserName(String emailid) {
		this.email.clear();
		this.email.sendKeys(emailid);
	}
	
	public void sendPassword(String pwd) {
		this.password.clear(); 
		this.password.sendKeys(pwd); 
	}
	
	public void clickLoginBtn() {
		this.loginButton.click(); }
		
	
	public void LoginPage(String name, String pwd)
	{
		new HomePagePOM();
		
		// Entering username and password
		this.sendUserName(name);
		this.sendPassword(pwd);

		// Clicking on "Sign In" button
		this.clickLoginBtn();
	}
	
}
