package com.tyss.projectframework.lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.google.common.io.Files;
import com.tyss.projectframework.init.IConstants;

public class GenericLib {
	
	
	public static String getPropData(String key) {
		
		String data="";
		try {
			FileInputStream fis=new FileInputStream(IConstants.propFilePath);
			Properties prop=new Properties();
			prop.load(fis);
			data=prop.getProperty(key);
			
		}                                                        
		                                                   
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return data;
	}
	
	public static void clickElement(WebDriver driver,WebElement ele,String eleName) throws TimeoutException {
	
   WebDriverWait wait=new WebDriverWait(driver,10);
	wait.until(ExpectedConditions.visibilityOf(ele)).click();
	Reporter.log("Clicked on "+eleName);
	
	}

	
public static void enterText(WebDriver driver,WebElement ele,String text,String eleName) {


	   WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(ele)).sendKeys(text);
		Reporter.log("Entered text \" "+text+  "\"In the "+eleName );

    }

public static void saveScreenShot(WebDriver driver,String fileName) {

  TakesScreenshot ts=(TakesScreenshot) driver;
  
  DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd-MM-yyyy hh-mm-ss");
  String timeCurrent=LocalDateTime.now().format(dtf);
  
  File src=ts.getScreenshotAs(OutputType.FILE);
  File desc=new File(IConstants.screenShotPath+fileName+" "+timeCurrent+"_Failed.png");

 try {
	Files.copy(src, desc);
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
 
}

}