package com.tyss.projectframeworkscripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tyss.projectframework.init.IConstants;
import com.tyss.projectframework.lib.BaseLib;
import com.tyss.projectframework.lib.ExcelLib;
import com.tyss.projectframework.pages.HomePage;
import com.tyss.projectframework.pages.MyCartPage;
import com.tyss.projectframework.pages.SignInPage;

public class LoginTest extends BaseLib {
	
	
	
	/*  @Test(enabled=false)
	public void tc_01() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {

	
	driver.findElement(By.xpath("//a[contains(text(),'My Account')]")).click();
	FileInputStream fis=new FileInputStream(IConstants.dataExcelPath);	
	Workbook workbook = WorkbookFactory.create(fis);
	org.apache.poi.ss.usermodel.Sheet s=workbook.getSheet("Sheet1");
	String username=s.getRow(1).getCell(1).getStringCellValue();
	String password=s.getRow(1).getCell(2).getStringCellValue();
	
	driver.findElement(By.id("exampleInputEmail1")).sendKeys(username);
	driver.findElement(By.id("exampleInputPassword1")).sendKeys(password);
	Thread.sleep(2000);
    driver.findElement(By.name("login")).click();
	Thread.sleep(2000);	
	}  */

	@Test
	public void tc_02() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException, TimeoutException {
		HomePage hp=new HomePage(driver);
		hp.myAccountBtnClick();
		SignInPage sip=new SignInPage(driver);
		String un=ExcelLib.getData("Sheet1", 1, 1, IConstants.dataExcelPath);
		String pw=ExcelLib.getData("Sheet1", 1, 2, IConstants.dataExcelPath);
		sip.doLogin(un,pw);	
		MyCartPage mcp=new MyCartPage(driver);
		

		Assert.assertTrue(mcp.getWelcomeName().contains(ExcelLib.getData("Sheet1", 1, 3, IConstants.ExpectedExcelData)));
		Thread.sleep(2000);
		
	}
}	



