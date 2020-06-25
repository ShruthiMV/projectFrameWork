package com.tyss.projectframework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;

	@FindBy(xpath="//a[contains(.,'My Account')]")
	private WebElement myAccountBtn;
	
	
	@FindBy(name="product")
	private WebElement searchBox;

	
	@FindBy(name="serach")
	private WebElement searchBtn;
	
	public HomePage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	public void myAccountBtnClick() {
		
		myAccountBtn.click();
		
	}
	
	
	
	
}
