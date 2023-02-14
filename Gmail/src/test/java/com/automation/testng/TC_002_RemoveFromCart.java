package com.automation.testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_002_RemoveFromCart {

	@Test(dataProvider = "getTestData")
	public void removeFromCart(String username, String password) throws Exception {

		// open browser

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		driver.manage().window().maximize();

		// login

		driver.get("https://www.saucedemo.com/");

		driver.findElement(By.id("user-name")).sendKeys(username);

		driver.findElement(By.id("password")).sendKeys(password);

		driver.findElement(By.id("login-button")).click();

		// add to cart

		Thread.sleep(2000);

		driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();

		// remove from cart

		Thread.sleep(2000);

		driver.findElement(By.id("remove-sauce-labs-bolt-t-shirt")).click();

		// logout

		Thread.sleep(2000);

		driver.findElement(By.id("react-burger-menu-btn")).click();

		driver.findElement(By.id("logout_sidebar_link")).click();

		// close Browser

		Thread.sleep(4000);

		driver.quit();
	}

	@DataProvider(name = "getTestData")
	public Object[][] getTestData() {
		Object[][] testData = { { "standard_user", "secret_sauce" } };
		return testData;
	}

	public static void main(String[] args) throws Exception {

		TC_002_RemoveFromCart tc2 = new TC_002_RemoveFromCart();
		tc2.removeFromCart("standard_user", "secret_sauce");
	}

}
