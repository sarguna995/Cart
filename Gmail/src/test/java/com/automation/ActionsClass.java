package com.automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsClass {

	public static void main(String[] args) throws Exception {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		// mouse actions.

//		driver.get("https://www.timesjobs.com/candidate/contact.html");
//		WebElement element = driver.findElement(By.id("uploadResume_basic"));
//		Actions actions = new Actions(driver);
//		actions.click(element).perform();

//		driver.get("https://api.jquery.com/dblclick/");
//		driver.switchTo().frame(0);
//		WebElement element = driver.findElement(By.tagName("div"));
//		Actions actions = new Actions(driver);
//		actions.moveToElement(element).perform();
//		Thread.sleep(2000);
//		actions.doubleClick(element).perform();

//		driver.get("https://jqueryui.com/droppable/");
//		driver.switchTo().frame(0);
//		WebElement source = driver.findElement(By.id("draggable"));
//		WebElement target = driver.findElement(By.id("droppable"));
//		Actions actions = new Actions(driver);
//		actions.dragAndDrop(source, target).perform();

//		driver.get("https://www.dtdc.com/");
//		driver.findElement(By.id("cboxClose")).click();
//		WebElement element = driver.findElement(By.linkText("Services"));
//		Actions actions = new Actions(driver);
//		actions.moveToElement(element).perform();
//		Thread.sleep(4000);
//		driver.findElement(By.linkText("Integrated Technology Platform")).click();

		// keyBoard actions

//		driver.get("https://www.goibibo.com/");
//		Actions actions = new Actions(driver);
//		actions.sendKeys(Keys.PAGE_DOWN).perform();
//		actions.sendKeys(Keys.END).perform();
//		actions.sendKeys(Keys.PAGE_UP).perform();
//		actions.sendKeys(Keys.HOME).perform();

		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");
		driver.switchTo().frame("iframeResult");

		Actions actions = new Actions(driver);

		actions.keyDown(Keys.CONTROL).perform();
		actions.click(driver.findElement(By.xpath("//option[@value='volvo']"))).perform();
		actions.click(driver.findElement(By.xpath("//option[@value='audi']"))).perform();
		actions.keyUp(Keys.CONTROL).perform();

		Thread.sleep(4000);

		driver.quit();

	}

}
