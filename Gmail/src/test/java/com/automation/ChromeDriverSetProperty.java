package com.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverSetProperty {

	public static void main(String[] args) {

		System.setProperty("webDriver.chrome.driver",
				"C://Users//K C K//Downloads//browser drivers//chromedriver//chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.google.com/");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.out.println(e.toString());
		}

		driver.quit();
	}

}
