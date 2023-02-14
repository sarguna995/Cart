package com.automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IFramesAndAlerts {

	public static void main(String[] args) throws Exception {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));

//		driver.get("http://secure.smartbearsoftware.com/samples/testcomplete14/dialogs/#");
//		driver.findElement(By.linkText("Show Confirm")).click();
//		Alert alert = driver.switchTo().alert();
//		Thread.sleep(2000);
//		System.out.println(alert.getText());
//		alert.accept();
//		alert.dismiss();

//		driver.findElement(By.linkText("Show Prompt")).click();
//		Alert alert = driver.switchTo().alert();
//		System.out.println(alert.getText());
//		alert.sendKeys("Hi chandra");
//		alert.accept();

		driver.get("https://hamcrest.org/JavaHamcrest/javadoc/2.2/");

		driver.switchTo().frame("packageListFrame");

		Thread.sleep(3000);

		driver.findElement(By.linkText("org.hamcrest.core")).click();

		driver.switchTo().defaultContent();

		driver.switchTo().frame("packageFrame");

		Thread.sleep(3000);

		driver.findElement(By.linkText("IsNull")).click();

		driver.switchTo().defaultContent();

		driver.switchTo().frame("classFrame");

		Thread.sleep(3000);

		driver.findElement(By.linkText("SelfDescribing")).click();

		driver.switchTo().parentFrame();

		Thread.sleep(4000);

		driver.quit();
	}

}
