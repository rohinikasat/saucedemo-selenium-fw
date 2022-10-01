package com.rohini.samples1;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.rohini.samples.core.BaseTest;

public class LoginTestSauceDemo extends BaseTest {

	@Test(priority = 1)
	public static void testLoginWithSuccessfulData() throws InterruptedException {

		String expectedText = "add-to-cart-sauce-labs-backpack";

		driver.findElement(By.name(loc.getProperty("username"))).sendKeys(loc.getProperty("std_user"));
		Thread.sleep(2000);
		driver.findElement(By.name(loc.getProperty("password"))).sendKeys(loc.getProperty("all_user_pwd"));
		Thread.sleep(2000);
		driver.findElement(By.name(loc.getProperty("login_button"))).click();
		Thread.sleep(5000);
		String actualText = driver.findElement(By.xpath(loc.getProperty("bagpack"))).getAttribute("name");

		Assert.assertEquals(expectedText, actualText, "Text verification failed");

	}

	@Test(priority = 2)
	public static void testLoginWithBlankData() throws InterruptedException {

		String expectedText = "error";

		driver.findElement(By.name(loc.getProperty("login_button"))).click();
		Thread.sleep(5000);
		String actualText = driver.findElement(By.xpath(loc.getProperty("error_message"))).getAttribute("data-test");
		Assert.assertEquals(expectedText, actualText, "Text verification failed");
	}

	@Test(priority = 3)
	public static void testLoginWithLockedOutUser() throws InterruptedException {

		String expectedText = "error";

		driver.findElement(By.name(loc.getProperty("username"))).sendKeys(loc.getProperty("locked_user"));
		Thread.sleep(2000);
		driver.findElement(By.name(loc.getProperty("password"))).sendKeys(loc.getProperty("all_user_pwd"));
		Thread.sleep(2000);
		driver.findElement(By.name(loc.getProperty("login_button"))).click();
		Thread.sleep(5000);
		String actualText = driver.findElement(By.xpath(loc.getProperty("error_message"))).getAttribute("data-test");
		Assert.assertEquals(expectedText, actualText, "Text verification failed");
	}

	@Test(priority = 4)
	public static void testLoginWithProblemUser() throws InterruptedException {

		String expectedText = "https://www.saucedemo.com/static/media/sl-404.168b1cce.jpg";

		driver.findElement(By.name(loc.getProperty("username"))).sendKeys(loc.getProperty("problem_user"));
		Thread.sleep(2000);
		driver.findElement(By.name(loc.getProperty("password"))).sendKeys(loc.getProperty("all_user_pwd"));
		Thread.sleep(2000);
		driver.findElement(By.name(loc.getProperty("login_button"))).click();
		Thread.sleep(5000);
		String actualText = driver.findElement(By.xpath("//*[@id=\"item_4_img_link\"]/img")).getAttribute("src");
		
		Assert.assertEquals(expectedText, actualText, "Text verification failed");
	}

	@Test(priority = 5)
	public static void testLoginWithPerformanceGlitchUser() throws InterruptedException {

		driver.findElement(By.name(loc.getProperty("username"))).sendKeys(loc.getProperty("glitch_user"));
		Thread.sleep(2000);
		driver.findElement(By.name(loc.getProperty("password"))).sendKeys(loc.getProperty("all_user_pwd"));
		Thread.sleep(2000);
		driver.findElement(By.name(loc.getProperty("login_button"))).click();
		Thread.sleep(5000);
		
	}

}
