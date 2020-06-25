package com.tyss.projectframework.lib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseLib {
	
static {
		
		System.setProperty(GenericLib.getPropData("browserKey"),GenericLib.getPropData("browserValue"));
	}


public WebDriver driver;

@BeforeMethod
public void setUp(ITestContext context) {
	
	if(GenericLib.getPropData("browserName").equalsIgnoreCase("chrome")) {
	
	ChromeOptions options=new ChromeOptions();
	
	options.addArguments("--disable notifications");
	driver=new ChromeDriver(options);
	}
	
	else
	{
	Assert.fail("Browser name not valid");
	
	}
	context.setAttribute("driver", driver);
    driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get(GenericLib.getPropData("url"));

}


@AfterMethod

public void tearDown()
{
	
	driver.close();
}
}
