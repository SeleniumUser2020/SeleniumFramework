package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPagePOM {
	private WebDriver driver; 
	private HomePagePOM home1;

	public LoginPagePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
		
	@FindBy(id="input-email")
	private WebElement email; 
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginButton;
	
	@FindBy(id="input-username")
	private WebElement userid; 

	@FindBy(xpath="//button[@type='submit']")
	private WebElement adminLoginButton;

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
		
	public void sendUserId(String user) {
		this.userid.clear();
		this.userid.sendKeys(user);
	}

	public void clickAdminLoginBtn() {
		this.adminLoginButton.click(); }

	public void LoginPage(String name, String pwd)
	{
		home1= new HomePagePOM(driver);
		
		// Entering username and password
		this.sendUserName(name);
		this.sendPassword(pwd);

		// Clicking on "Sign In" button
		this.clickLoginBtn();
	}

	public void AdminLoginPage(String name, String pwd)
	{
		// Entering username and password
		this.sendUserId(name);
		this.sendPassword(pwd);

		// Clicking on "Sign In" button
		this.clickAdminLoginBtn();
	}
	
}