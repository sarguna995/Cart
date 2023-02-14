package com.automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutorTest {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		driver.get("https://emicalculator.net/");

		WebElement txtInterestRate = driver.findElement(By.id("loaninterest"));

//		Actions actions = new Actions(driver);
//		actions.click(txtInterestRate).perform();
//		actions.sendKeys(Keys.BACK_SPACE).build().perform();
//		actions.sendKeys("12").perform();

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].style.border='solid red',arguments[0].style.backgroundColor='Yellow'",
				txtInterestRate);

		js.executeScript("arguments[0].value='12.9'", txtInterestRate);

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			System.out.println(e.toString());
		}

		driver.quit();

	}

}
