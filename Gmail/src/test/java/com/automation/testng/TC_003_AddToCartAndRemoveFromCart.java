package com.automation.testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_003_AddToCartAndRemoveFromCart {

	private WebDriver driver = null;

	// open browser
	@BeforeTest
	public void openBrowser() {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		driver.manage().window().maximize();
	}

	// login
	@BeforeMethod
	public void login() {
		driver.get("https://www.saucedemo.com/");

		driver.findElement(By.id("user-name")).sendKeys("standard_user");

		driver.findElement(By.id("password")).sendKeys("secret_sauce");

		driver.findElement(By.id("login-button")).click();
	}

	// add to cart
	@Test(priority = 1, groups = "Smoke"  )
	public void addToCart() throws Exception {

		Thread.sleep(2000);

		driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();

	}

	// remove from cart
	@Test(priority = 2, groups = "Regression")
	public void removeFromCart() throws Exception {

		Thread.sleep(2000);

		driver.findElement(By.id("remove-sauce-labs-bolt-t-shirt")).click();

	}

	@Test(priority = 3)
	public void assertions() {

		SoftAssert softAssert = new SoftAssert();

		String actualTitle = driver.getTitle();

		String ExpectedTitle = "Swag Labs"; // wrong title Captial S

		softAssert.assertEquals(actualTitle, ExpectedTitle);

		driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();

		softAssert.assertAll();

	}

	// logout
	@AfterMethod
	public void logout() throws Exception {

		Thread.sleep(2000);

		driver.findElement(By.id("react-burger-menu-btn")).click();

		driver.findElement(By.id("logout_sidebar_link")).click();

	}

	// close Browser
	@AfterTest
	public void closeBrowser() throws Exception {

		Thread.sleep(2000);

		driver.quit();

	}

	public static void main(String[] args) throws Exception {

		TC_003_AddToCartAndRemoveFromCart tc3 = new TC_003_AddToCartAndRemoveFromCart();
		tc3.addToCart();
		tc3.removeFromCart();

	}

}
