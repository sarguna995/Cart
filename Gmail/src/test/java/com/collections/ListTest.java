package com.collections;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ListTest {

	public static void main(String[] args) throws Exception {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		driver.get("https://www.cypress.io/");

		driver.findElement(By.partialLinkText("Log In")).click();

		Set<String> set = driver.getWindowHandles();

		List<String> list = new ArrayList<>(set);

		driver.switchTo().window(list.get(1));

		driver.findElement(By.xpath("(//span[@class='pull-left'])[4]")).click();

		Thread.sleep(4000);

		driver.quit();
	}

}
