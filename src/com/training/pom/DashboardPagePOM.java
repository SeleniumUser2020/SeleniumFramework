package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPagePOM {
	
private WebDriver driver; 
	
	public DashboardPagePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//i[@class='fa fa-tags fw']")
	private WebElement catalog;
	
	@FindBy(xpath="//li[@id='menu-catalog']/ul/li[2]/a[contains(@href,'http://retail.upskills.in/admin/index.php?route=catalog/product&token')]")
	private WebElement productLink; 
	
	@FindBy(xpath="//a[@href='edit-tags.php?taxonomy=category' and text()='Categories']")
	private WebElement categoryLink;
	
	@FindBy(xpath="//a[@href='edit.php' and text()='All Posts']")
	private WebElement allPostsLink;
	
	@FindBy(xpath="//div[@class='wp-menu-name' and text()='Comments ']")
	private WebElement commentsLink;
	
	@FindBy(xpath="//div[@class='wp-menu-name' and text()='Properties']")
	private WebElement propertiesLink;
	
	@FindBy(xpath="//a[@href='edit-tags.php?taxonomy=property_feature&post_type=property' and text()='Features']")
	private WebElement featuresLink;
	
	@FindBy(xpath="//a[@href='post-new.php?post_type=property' and text()='Add New']")
	private WebElement addNewPropLink;
	
	@FindBy(xpath="//a[@class='ab-item' and text()='Log Out']")
	private WebElement logOutLink;
	
//	public String GetDashboardText() {
	////	return(this.dashText.getText());
//	}

	public void ClickCatalogLink() {
		this.catalog.click();
	}
	
	public void ClickProductLink() {
		this.productLink.click();
	}
	
	public void ClickAllPostsLink() {
		this.allPostsLink.click();
	}
	
	public void ClickCommentsLink() {
		this.commentsLink.click();
	}
	
	public void ClickPropertiesLink() {
		this.propertiesLink.click();
	}
	
	public void ClickFeaturesLink() {
		this.featuresLink.click();
	}
	
	public void ClickAddNewPropLink() {
		this.addNewPropLink.click();
	}
	
	public void ClickLogOutLink() {
		this.logOutLink.click();
	}
}
