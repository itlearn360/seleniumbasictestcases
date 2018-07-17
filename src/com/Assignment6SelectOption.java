package com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment6SelectOption {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "folder path of geckodriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.newtours.demoaut.com");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.name("userName")).sendKeys("training124");
		driver.findElement(By.name("password")).sendKeys("training124");
		driver.findElement(By.name("login")).click();
		// To prevent exception we need to add wait command and keep control
		// upto 20
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("tripType")));
		// to select one way flight using cssselector, you can also select by
		// name only
		driver.findElement(By.cssSelector("input[type='radio'][name='tripType'][value='oneway']")).click();
		// to fill number of passengers into 2 person using cssselector
		driver.findElement(By.cssSelector("select>option[value='2']")).click();
		// to change departure to London using sendkey to the list box
		driver.findElement(By.name("fromPort")).sendKeys("London");

		// to change departure month to 'May' using using Selenium Select Class.
		Select oSelect = new Select(driver.findElement(By.name("fromMonth")));
		oSelect.selectByVisibleText("May");// use also index and value to select
		// Exercise do the same above for the day part

		// to select depart
	}

}