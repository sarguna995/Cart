package com.automation.testng;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AllLinks {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));

		driver.get("https://www.google.co.in");
		
		String origianlwindow =		driver.getWindowHandle();

		List<WebElement> list = driver.findElements(By.tagName("a"));

		for (WebElement l : list) {
			System.out.println(l.getText());
			System.out.println(l.getAttribute("href"));
			String link = l.getAttribute("href");
			driver.switchTo().newWindow(WindowType.TAB);
			driver.get(link);
			driver.close();
			driver.switchTo().window(origianlwindow);
			
		}

		driver.quit();
	}

}
