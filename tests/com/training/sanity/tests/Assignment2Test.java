package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.training.generics.GenericMethods;
import com.training.generics.ScreenShot;
import com.training.pom.LoginPagePOM;
import com.training.pom.DashboardPagePOM;
import com.training.pom.ProductPagePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Assignment2Test {
	private WebDriver driver;
	private String baseUrl;
	private LoginPagePOM login;
	private DashboardPagePOM dashboard;
	private ProductPagePOM product;
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
		login = new LoginPagePOM(driver);
		dashboard= new DashboardPagePOM(driver);
		product= new ProductPagePOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		generic = new GenericMethods(driver);
		
		// open the browser
		driver.get(baseUrl);
		Thread.sleep(5000L);
		
		login.AdminLoginPage("admin","admin@123");
		// Asserting if correct page has been launched or not
		generic.AssertTitle("Dashboard");
	}

	
	// To verify whether application displays error message upon mis matching password & confirm password of Change Your Password page
	/*@Test
	public void Scenario1() throws InterruptedException {
		System.out.println("Test Scenario1 starts");
	
		// Step # 1
		dashboard.ClickCatalogLink();
		
		// Step # 2
		dashboard.ClickProductLink();
		// Asserting if correct page has been launched or not
		generic.AssertTitle("Products");
		
		// Step # 3
		product.EnterName("Integer vitae iaculis massa");
		
		//Step # 4
		product.ClickFilterButton();
		// Getting webelement to pass on to assertion for text verification
		WebElement element1 = generic.getElement("//table/tbody/tr[1]/td[3]", "xpath");
		String expectedConfirmationMessage1 = "Integer vitae iaculis massa";
		// Asserting if we have error message on the page or not
		generic.AssertText(expectedConfirmationMessage1, element1);
		
		//Step #5
		product.EnterPrice("515");
		
		// Step # 6
		product.ClickFilterButton();
		WebElement element2 = generic.getElement("//table/tbody/tr[1]/td[5]", "xpath");
		String expectedConfirmationMessage2 = "515.0000";
		// Asserting if we have error message on the page or not
		generic.AssertText(expectedConfirmationMessage2, element2);
		
		// Step # 7
		WebElement we1= driver.findElement((By.id("input-status")));
		Select sel= new Select(we1);
		sel.selectByValue("1");
		
		// Step # 8
		product.ClickFilterButton();
		WebElement element3 = generic.getElement("//table/tbody/tr[1]/td[7]", "xpath");
		String expectedConfirmationMessage3 = "Enabled";
		// Asserting if we have error message on the page or not
		generic.AssertText(expectedConfirmationMessage3, element3);
		
		// Step # 9
		product.EnterModel("SKU-003");
		
		// Step # 10
		product.ClickFilterButton();
		WebElement element4 = generic.getElement("//table/tbody/tr[1]/td[4]", "xpath");
		String expectedConfirmationMessage4 = "SKU-003";
		// Asserting if we have error message on the page or not
		generic.AssertText(expectedConfirmationMessage4, element4);
		
		// Step # 11
		product.EnterQuantity("49");
		
		// Step # 12
		product.ClickFilterButton();
		WebElement element5 = generic.getElement("//table/tbody/tr[1]/td[6]/span", "xpath");
		String expectedConfirmationMessage5 = "49";
		// Asserting if we have error message on the page or not
		generic.AssertText(expectedConfirmationMessage5, element5);

		// Step # 13
		product.EnterImage();
		WebElement we2= driver.findElement((By.id("input-image")));
		Select sel1= new Select(we2);
		sel1.selectByValue("1");
		
		// Step # 14
		product.ClickFilterButton();
		WebElement element6 = generic.getElement("//table/tbody/tr[1]/td[2]/img", "xpath");
		// Asserting if we have error message on the page or not
		generic.AssertAttributeValue("img-thumbnail", "class",element6);
		
		// Logging out from application
		WebElement element7 = generic.getElement("//a/span[text()='Logout']", "xpath");
		element7.click();
		Thread.sleep(5000L);
		
		System.out.println("Test Scenario1 ends");
		
	}*/
	

	// To Verify whether application allows admin to add product by entering valid credentials in mandatory fields only
	@Test
	public void Scenario2() throws InterruptedException {
		System.out.println("Test Scenario2 starts");
		
		// Step # 1
		dashboard.ClickCatalogLink();
		
		Thread.sleep(5000);
		
		// Step # 2
		dashboard.ClickProductLink();
		// Asserting if correct page has been launched or not
		generic.AssertTitle("Products");
		Thread.sleep(5000);
		
		// Step # 3
		product.ClickAddNewLink();
		WebElement element1 = generic.getElement("//div[@id='content']/div[2]/div/div[1]/h3", "xpath");
		String expectedConfirmationMessage1="Add Product";
		// Asserting if we have error message on the page or not
		generic.AssertText(expectedConfirmationMessage1, element1);
		Thread.sleep(5000);
		 
		// Step # 4
		product.EnterNewProdName("Television");
		Thread.sleep(5000);
		
		// Step # 5
		product.EnterNewProdTitle("Samsung LED TV");
		Thread.sleep(5000);
		
		
		// Step # 6
		product.ClickDataTab();
		Thread.sleep(5000);
				
		// Step # 7
		product.EnterDataModel("SU123");
		
		// Step # 8
		product.EnterDataPrice("10000");
		
		// Step # 9
		product.EnterDataQuantity("1");	
		
				
		// Step # 10
		product.ClickLinkTab();
		
		// Step # 11
		product.ClickCatTextBox();
		
		// Step # 12
		product.ClickCatValue();
		
		// Step # 14
		product.ClickSave();
		WebElement element2 = generic.getElement("//div[@id='content']/div[2]/div[contains(@class,'alert alert-success')]", "xpath");
		String expectedConfirmationMessage2="Success: You have modified products!";
		
		String str=element2.getText();
		str= str.substring(0, expectedConfirmationMessage2.length());
		
		
		if (str.equals(expectedConfirmationMessage2) )
		{
			System.out.println("Assertion is successful and hence test case is passed");	
		}
		else 
		{
			System.out.println("Assertion is failed and hence the test case");	
		}
		
		System.out.println("Test Scenario2 ends");		
		
	}		
	

	// To verify whether application allows admin to edit Quantity details of a product
	/*@Test
	public void Scenario3() throws InterruptedException {
		System.out.println("Test Scenario3 starts");
		
		// Step # 1
		dashboard.ClickCatalogLink();
				
		// Step # 2
		dashboard.ClickProductLink();
		// Asserting if correct page has been launched or not
		generic.AssertTitle("Products");
		
		// Step # 3
		product.ClickProdEdit();
		WebElement element1 = generic.getElement("//div[@id='content']/div[2]/div/div[1]/h3", "xpath");
		String expectedConfirmationMessage1="Edit Product";
		// Asserting if we have error message on the page or not
		generic.AssertText(expectedConfirmationMessage1, element1);
		
		// Step # 4
		product.ClickDataTab();
		
		// Step 5 and 6
		product.EnterDataQuantity("45");
		
		// Step # 8
		product.ClickSave();
		WebElement element2 = generic.getElement("//div[@id='content']/div[2]/div[contains(@class,'alert alert-success')]", "xpath");
		String expectedConfirmationMessage2="Success: You have modified products!";
		
		String str=element2.getText();
		str= str.substring(0, expectedConfirmationMessage2.length());
		
		if (str.equals(expectedConfirmationMessage2) )
		{
			System.out.println("Assertion is successful and hence test case is passed");	
		}
		else 
		{
			System.out.println("Assertion is failed and hence the test case");	
		}
		
		System.out.println("Test Scenario3 ends");		
	}*/

	

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
		
		// Logging out from application
		WebElement element7 = generic.getElement("//a/span[text()='Logout']", "xpath");
		element7.click();
		

		Thread.sleep(1000);
		driver.quit();
	}
}
