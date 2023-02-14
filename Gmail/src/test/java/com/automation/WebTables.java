package com.automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTables {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		driver.get("https://datatables.net/extensions/select/examples/initialisation/checkbox.html");

		System.out.println("no.of Tables  = " + driver.findElements(By.xpath("//table")).size());

		System.out.println("Total rows  = " + driver.findElements(By.xpath("//table[@id='example']//tr")).size());

		System.out.println(
				"Total Body rows =" + driver.findElements(By.xpath("(//table[@id='example']//tbody)//tr")).size());

		System.out.println(
				"Total columns =" + driver.findElements(By.xpath("((//table[@id='example']//thead)//tr)//th")).size());

		System.out.println("entire row data = "
				+ driver.findElement(By.xpath("(//table[@id='example']//tbody//tr)[2]")).getText());

		System.out.println("paticular row content = "
				+ driver.findElement(By.xpath("((//table[@id='example']//tbody//tr)[4]//td)[3]")).getText());

		driver.quit();

	}

}
