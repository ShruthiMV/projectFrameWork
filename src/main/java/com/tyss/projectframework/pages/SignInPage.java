package com.tyss.projectframework.pages;

import java.util.concurrent.TimeoutException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tyss.projectframework.lib.GenericLib;

public class SignInPage {
	
	
	WebDriver driver;

	
	@FindBy(id="exampleInputEmail1")
	private WebElement unTxtBox;
	
	
	@FindBy(id="exampleInputPassword1")
	private WebElement pwdTxtBox;
	
	@FindBy(name="login")
	private WebElement loginBtn;
	
	
	public SignInPage(WebDriver driver) {
	
	   this.driver=driver;
	   PageFactory.initElements(driver, this);
	   
	}
	
	public void doLogin(String username,String password) throws TimeoutException {
	
	GenericLib.enterText(driver, unTxtBox, username, "Username Textbox");
	GenericLib.enterText(driver, pwdTxtBox, password, "Password Textbox");
    GenericLib.clickElement(driver, loginBtn , "Login Btn");
	
	

  }
}