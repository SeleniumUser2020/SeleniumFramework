package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPagePOM {
	
private WebDriver driver; 
	
	public ProductPagePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="input-name")
	private WebElement pNameTextBox; 
	
	@FindBy(id="input-price")
	private WebElement priceTextBox; 
	
	@FindBy(id="input-status")
	private WebElement statusDrop; 
	
	@FindBy(id="input-model")
	private WebElement modelTextBox; 
	
	@FindBy(id="input-quantity")
	private WebElement quantityTextBox; 
	
	@FindBy(id="input-image")
	private WebElement imageDrop; 

	@FindBy(id="button-filter")
	private WebElement filterBtn; 
	
	@FindBy(xpath="//a[@data-original-title='Add New']")
	private WebElement addNewLink; 

	@FindBy(xpath="//button[@data-original-title='Delete']")
	private WebElement deleteLink; 

	@FindBy(xpath="//input[@id='input-name1']")
	private WebElement newProdNameTextBox; 

	@FindBy(xpath="//input[@id='input-meta-title1']")
	private WebElement newProdTitleTextBox; 

	@FindBy(xpath="//a[text()='Data']")
	private WebElement dataLink; 

	@FindBy(xpath="//a[text()='Links']")
	private WebElement linkTab; 

	@FindBy(xpath="//i[contains(@class,'fa fa-save')]")
	private WebElement saveLink; 
	
	@FindBy(xpath="//input[@id='input-model']")
	private WebElement dModelTextBox; 

	@FindBy(xpath="//input[@id='input-price']")
	private WebElement dPriceTextBox; 

	@FindBy(xpath="//input[@id='input-quantity']")
	private WebElement dQuantityTextBox; 

	@FindBy(xpath="//input[@id='input-category']")
	private WebElement lCategoryTextBox; 

	@FindBy(xpath="//label[@for='input-category']/following-sibling::div/ul//li[1]/a[text()='Electronic']")
	private WebElement lCategoryValue; 

	@FindBy(xpath="//table/tbody/tr[1]/td[8]/a")
	private WebElement prodEditLink; 
	
	@FindBy(xpath="//table/thead/tr/td[1]/input")
	private WebElement prodAllCheckBox; 


	public void EnterName(String name) {
		this.pNameTextBox.clear(); 
		this.pNameTextBox.sendKeys(name); 
	}
	
	public void EnterPrice(String priceVal) {
		this.priceTextBox.clear(); 
		this.priceTextBox.sendKeys(priceVal); 
	}
	
	public void EnterStatus() {
		this.statusDrop.click(); 
	}
	
	public void EnterModel(String model) {
		this.modelTextBox.clear(); 
		this.modelTextBox.sendKeys(model); 
	}

	public void EnterQuantity(String quant) {
		this.quantityTextBox.clear(); 
		this.quantityTextBox.sendKeys(quant); 
	}

	public void EnterImage() {
		this.imageDrop.click(); 
	}

		
	public void ClickFilterButton() {
		this.filterBtn.click();
	}
	
	public void ClickAddNewLink() {
		this.addNewLink.click();
	}

	public void ClickDeleteLink() {
		this.deleteLink.click();
	}
	
	public void EnterNewProdName(String prodName) {
		this.newProdNameTextBox.clear(); 
		this.newProdNameTextBox.sendKeys(prodName); 
	}
	
	public void EnterNewProdTitle(String prodTitle) {
		this.newProdTitleTextBox.clear(); 
		this.newProdTitleTextBox.sendKeys(prodTitle); 
	}

	public void ClickDataTab() {
		this.dataLink.click();
	}

	public void ClickLinkTab() {
		this.linkTab.click();
	}

	public void EnterDataModel(String dataModel) {
		this.dModelTextBox.clear(); 
		this.dModelTextBox.sendKeys(dataModel); 
	}

	public void EnterDataPrice(String dataPrice) {
		this.dPriceTextBox.clear(); 
		this.dPriceTextBox.sendKeys(dataPrice); 
	}

	public void EnterDataQuantity(String dataQuant) {
		this.dQuantityTextBox.clear(); 
		this.dQuantityTextBox.sendKeys(dataQuant); 
	}

	public void ClickCatTextBox() {
		this.lCategoryTextBox.click();
	}

	public void ClickCatValue() {
		this.lCategoryValue.click();
	}

	public void ClickSave() {
		this.saveLink.click();
	}

	public void ClickProdEdit() {
		this.prodEditLink.click();
	}

	public void ClickAllCheckBox() {
		this.prodAllCheckBox.click();
	}


}
