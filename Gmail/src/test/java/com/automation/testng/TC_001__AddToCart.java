package com.automation.testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_001__AddToCart {

	private WebDriver driver = null;

	// open browser
	@Parameters({ "browser" })
	@BeforeTest
	public void openBrowser(@Optional("chrome") String browser) {

		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		}

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		driver.manage().window().maximize();
	}

	@BeforeMethod()
	public void login() {
		// login

		driver.get("https://www.saucedemo.com/");

		driver.findElement(By.id("user-name")).sendKeys("standard_user");

		driver.findElement(By.id("password")).sendKeys("secret_sauce");

		driver.findElement(By.id("login-button")).click();
	}

	@Test
	public void addToCart() throws Exception {

		// add to cart

		Thread.sleep(2000);

		driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();

	}

	@AfterMethod
	public void logout() throws Exception {

		// logout

		Thread.sleep(2000);

		driver.findElement(By.id("react-burger-menu-btn")).click();

		driver.findElement(By.id("logout_sidebar_link")).click();
	}

	@AfterTest
	public void closeBrowser() throws Exception {
		// close Browser

		Thread.sleep(4000);

		driver.quit();
	}

	public static void main(String[] args) throws Exception {

		TC_001__AddToCart tc1 = new TC_001__AddToCart();
		tc1.openBrowser("chrome");
		tc1.login();
		tc1.addToCart();
		tc1.logout();
		tc1.closeBrowser();
	}

}
