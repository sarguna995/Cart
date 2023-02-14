package com.automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectClassMethods {

	public static void main(String[] args) throws Exception {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));

//		driver.get("https://electoralsearch.in/");
//		driver.findElement(By.id("continue")).click();
//		driver.findElement(By.id("nameStateList")).sendKeys("Assam");

		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");

		driver.switchTo().frame("iframeResult");

		WebElement lstCars = driver.findElement(By.id("cars"));

		Select select = new Select(lstCars);

		System.out.println(select.isMultiple());

		select.selectByIndex(0);
		select.selectByValue("opel");
		select.selectByVisibleText("Audi");

		System.out.println("All selected options = " + select.getAllSelectedOptions().size());
		
		System.out.println("Total no.of options = " + select.getOptions().size());

		Thread.sleep(2000);
		select.deselectByIndex(3);
		select.deselectByValue("volvo");
		select.deselectByVisibleText("Opel");

		Thread.sleep(4000);

		driver.quit();

	}

}
