package com.automation;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenShot {

	public static void main(String[] args) throws Exception {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		driver.get("https://datatables.net/extensions/select/examples/initialisation/checkbox.html");

		// webelement screenshot(to take screenshot of particular element)

		WebElement table = driver.findElement(By.id("example"));
		// to get the table into view.
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", table);
		File sc = table.getScreenshotAs(OutputType.FILE);
		File dest = new File("D:\\Image1.png");
		FileHandler.copy(sc, dest);

		// full-screen screenshot
//		File sc = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		File dest = new File("D:\\Image1.png");
//		FileHandler.copy(sc, dest);

		// Full-page screenshot using shutterbug.
		// Shutterbug.shootPage(driver, Capture.FULL).save("D:\\Image2.png");

		Thread.sleep(4000);

		driver.quit();

	}

}
