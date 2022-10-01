package com.rohini.samples1;


import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.rohini.samples.core.BaseTest;
import com.rohini.utilities.ReadXLSXdata;


public class DataProviderLogin extends BaseTest{
	
	
	@Test(dataProviderClass = ReadXLSXdata.class, dataProvider = "testData")
	public void loginTest(String username, String password) throws InterruptedException {
		
		
		driver.findElement(By.name(loc.getProperty("username"))).sendKeys(username);
		Thread.sleep(2000);
		driver.findElement(By.name(loc.getProperty("password"))).sendKeys(password);
		Thread.sleep(2000);
		driver.findElement(By.name(loc.getProperty("login_button"))).click();
		Thread.sleep(5000);
		
	}
	
}
