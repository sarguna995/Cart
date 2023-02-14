package com.automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWait {

	public static void main(String[] args) throws Exception {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

//		driver.get("https://my.microfocus.com/");
//		driver.findElement(By.partialLinkText("Login")).click();
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
//		driver.findElement(By.id("username")).sendKeys("chandra");

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		driver.get("https://github.com/");

		driver.findElement(By.partialLinkText("Sign up")).click();

		driver.findElement(By.id("email")).sendKeys("Test123@github.com");

		Thread.sleep(4000);

		driver.quit();

	}

}
