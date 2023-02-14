package com.automation;

import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverMethods {

	public static void main(String[] args) throws Exception {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		Thread.sleep(2000);

		driver.get("https://www.google.com/");

		Thread.sleep(2000);

		driver.navigate().back();

		Thread.sleep(2000);

		driver.navigate().forward();

		Thread.sleep(2000);

		driver.navigate().refresh();

		System.out.println(driver.getCurrentUrl());

		System.out.println(driver.getTitle());

		Thread.sleep(2000);
		
		driver.switchTo().newWindow(WindowType.TAB);
		
		Thread.sleep(2000);
		
		driver.navigate().to("https://www.selenium.dev/");
		
		Thread.sleep(2000);
		
		driver.close();
		
		Thread.sleep(2000);

		driver.quit();

	}

}
