package com;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import junit.framework.Assert;

public class Assignment3Assertion {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "folder path of geckodriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get("http://www.training.qaonlinetraining.com/");
		String title = driver.getTitle();
		// the following line checks the title contains some text
		Assert.assertTrue("title is corect", title.contains("Infotek Solution"));
		// if the above assertion is correct then next line will be executed
		System.out.println(title);
		/*
		 * see also Assert.assertEquals(expected, actual);
		 * Assert.assertFalse(message, condition);
		 */

		// assertions at element level using isDisplayed, isEnabled and
		// isSelected
		if (driver.findElement(By.linkText("Your class sessions")).isDisplayed()) {
			System.out.println("class session existed in the page");
		} else {
			System.out.println("class text not this page element");
		}

		if (driver.findElement(By.linkText("Your class sessions")).isEnabled()) {
			System.out.println("class session is enabled on the page and we can clik it");
		} else {
			System.out.println("button is not enabled to clikc");
		}
		// we use isSelected to for check box, combobox and list box to assure
		// that the specified element is selected or not

	}
}