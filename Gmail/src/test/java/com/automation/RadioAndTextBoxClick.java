package com.automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioAndTextBoxClick {

	private static Select select;

	public static void main(String[] args) throws Exception {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		driver.get("https://www.thepancard.com/newpancard.php");

//		driver.findElement(By.linkText("Apply New PAN Card for Minor")).click();

		driver.findElement(By.id("rblCategory_3")).click();

		driver.findElement(By.name("DOB")).sendKeys("11/09/1994");

		driver.findElement(By.name("gender")).click();

		WebElement DocProofDOB = driver.findElement(By.id("proof_dob"));

		select = new Select(DocProofDOB);

		select.selectByValue("7");

		Thread.sleep(2000);

		WebElement DocProofIdentity = driver.findElement(By.id("ddlPOI"));

		select = new Select(DocProofIdentity);

		select.selectByValue("3");
		
//		Thread.sleep(3000);
//		not working to click radio button
//		((JavascriptExecutor)driver).executeScript("document.getElementById('prefix_1').click()");

		Thread.sleep(3000);
		
		driver.findElement(By.id("rbOthers_0")).click();

		driver.findElement(By.id("agree_check")).click();

		Thread.sleep(3000);

		driver.quit();

	}

}
