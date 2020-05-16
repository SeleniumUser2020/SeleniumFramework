package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.training.generics.GenericMethods;
import com.training.generics.ScreenShot;
import com.training.pom.HomePagePOM;
import com.training.pom.LoginPagePOM;
import com.training.pom.AccountPagePOM;
import com.training.pom.ChangePwdPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AssignmentTest {
	private WebDriver driver;
	private String baseUrl;
	private HomePagePOM homePage;
	private LoginPagePOM login;
	private AccountPagePOM account;
	private ChangePwdPOM changePwd;
	private static Properties properties;
	private ScreenShot screenShot;
	private GenericMethods generic;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		homePage = new HomePagePOM(driver);
		login = new LoginPagePOM(driver);
		account= new AccountPagePOM(driver);
		changePwd = new ChangePwdPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		generic = new GenericMethods(driver);
		// open the browser
		driver.get(baseUrl);
		Thread.sleep(5000L);
		
		// Asserting if correct page has been launched or not
		generic.AssertTitle("Retail");
	}

	// To verify whether application displays error message upon mis matching password & confirm password of Change Your Password page
	@Test
	public void Scenario1() throws InterruptedException {
		System.out.println("Test Scenario1 starts");
		
		driver.findElement(By.id("  "));
		driver.findElement(By.xpath("");
		
	
		// Clicking on "Blog" link
		homePage.ClickLoginLink();

		// Asserting if correct url has been launched or not
		generic.AssertUrl("http://retail.upskills.in/account/login");

		// Entering fields of login page
		login.LoginPage("pamiljain@gmail.com","gurgaon123");
		
		// Asserting if correct page has been launched or not
		generic.AssertTitle("My Account");

		// Clicking on Change Password Link
		account.clickChangePwdLink();

		// Asserting if correct page has been launched or not
		generic.AssertTitle("Change Password"); 
	
		// Enter new password in Password textbox
		changePwd.EnterEmail("pamiljain");

		// Enter new password in Confirm Password textbox
		changePwd.ReEnterEmail("pamilibm");
	
		// Click on Continue button
		changePwd.ClickContinueButton();

		// Asserting if correct confirmation message is displayed or not
		String expectedConfirmationMessage = "Password confirmation does not match password!";

		// Getting webelement to pass on to assertion for text verification
		WebElement element = generic.getElement("//div[@class='text-danger']", "xpath");

		// Asserting if we have error message on the page or not
		generic.AssertText(expectedConfirmationMessage, element);
		
		System.out.println("Test Scenario1 ends");
	}

	@AfterMethod
	public void TestStatus(ITestResult result) throws Exception {
		int status = result.getStatus();

		if (status == result.SUCCESS) {
			System.out.println("Test " + result.getName() + " is PASSED");
		} else if (status == result.FAILURE) {
			System.out.println("Test " + result.getName() + " is FAILED");
		} else if (status == result.SKIP) {
			System.out.println("Test " + result.getName() + " is SKIPPED");
		}

		if (status == result.FAILURE) {
			screenShot.captureScreenShot(result.getName());
		}

		Thread.sleep(1000);
		driver.quit();
	}
}

