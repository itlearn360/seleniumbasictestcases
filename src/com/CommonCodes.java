package com;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonCodes {
	private static WebDriver driver;

	public static void getDriver() {
		System.setProperty("webdriver.gecko.driver", "folder path of geckodriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public static void openBrowser(String url) {
		driver.get(url);
	}

	public static List getWebElements(String locatortype, String locator) {
		List webelements = null;
		if (locatortype.equals("name")) {
			webelements = driver.findElements(By.name(locator));
		} else if (locatortype.equals("css")) {
			webelements = driver.findElements(By.cssSelector(locator));
		} else if (locatortype.equals("id")) {
			webelements = driver.findElements(By.id(locator));
		} else if (locatortype.equals("classname")) {
			webelements = driver.findElements(By.className(locator));
		} else if (locatortype.equals("link")) {
			webelements = driver.findElements(By.linkText(locator));
		} else if (locatortype.equals("tagname")) {
			webelements = driver.findElements(By.tagName(locator));
		} else if (locatortype.equals("xpath")) {
			webelements = driver.findElements(By.xpath(locator));
		}
		return webelements;
	}

	public static WebElement getWebElement(String locatortype, String locator) {
		WebElement webelement = null;
		if (locatortype.equals("name")) {
			webelement = driver.findElement(By.name(locator));
		} else if (locatortype.equals("css")) {
			webelement = driver.findElement(By.cssSelector(locator));
		} else if (locatortype.equals("id")) {
			webelement = driver.findElement(By.id(locator));
		} else if (locatortype.equals("classname")) {
			webelement = driver.findElement(By.className(locator));
		} else if (locatortype.equals("link")) {
			webelement = driver.findElement(By.linkText(locator));
		} else if (locatortype.equals("tagname")) {
			webelement = driver.findElement(By.tagName(locator));
		} else if (locatortype.equals("xpath")) {
			webelement = driver.findElement(By.xpath(locator));
		}
		return webelement;
	}

	public static void closeDriver() {
		// TODO Auto-generated method stub
		driver.close();
	}

	public static boolean verifyTitle(String title) {
		String pagetitle = driver.getTitle();
		System.out.println(pagetitle);
		pagetitle = pagetitle.trim();
		if (title.equals(pagetitle)) {
			return true;
		} else {
			return false;
		}
	}

	public static String getCurrentURL() {
		return driver.getCurrentUrl();
	}

	public static void click_element(WebElement logoele, String locatortype, String locator) {
		// TODO Auto-generated method stub
		logoele.click();
		WebDriverWait pageload = new WebDriverWait(driver, 10);
		if (locatortype.equals("css"))
			pageload.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator)));
		else if (locatortype.equals("id"))
			pageload.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
		else if (locatortype.equals("name"))
			pageload.until(ExpectedConditions.visibilityOfElementLocated(By.name(locator)));
		else if (locatortype.equals("xpath"))
			pageload.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		else if (locatortype.equals("tagname"))
			pageload.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(locator)));
		else if (locatortype.equals("link"))
			pageload.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(locator)));
		else if (locatortype.equals("classname"))
			pageload.until(ExpectedConditions.visibilityOfElementLocated(By.className(locator)));

	}

	public static void waitforElement(String locatortype, String locator) {
		WebDriverWait pageload = new WebDriverWait(driver, 10);
		if (locatortype.equals("css"))
			pageload.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(locator)));
		else if (locatortype.equals("id"))
			pageload.until(ExpectedConditions.presenceOfElementLocated(By.id(locator)));
		else if (locatortype.equals("name"))
			pageload.until(ExpectedConditions.presenceOfElementLocated(By.name(locator)));
		else if (locatortype.equals("xpath"))
			pageload.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
		else if (locatortype.equals("tagname"))
			pageload.until(ExpectedConditions.presenceOfElementLocated(By.tagName(locator)));
		else if (locatortype.equals("link"))
			pageload.until(ExpectedConditions.presenceOfElementLocated(By.linkText(locator)));
		else if (locatortype.equals("classname"))
			pageload.until(ExpectedConditions.presenceOfElementLocated(By.className(locator)));

	}

	public static Actions getActions() {
		// TODO Auto-generated method stub
		return new Actions(driver);
	}

	public static void switchToNewWindow() {
		// TODO Auto-generated method stub
		driver.switchTo().activeElement();
		System.out.println(driver.getTitle());
	}

}