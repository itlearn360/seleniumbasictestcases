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

public class Assignment1Commands {
	/*
	 * this is the first assignment of selenium
	 */
	public static void main(String[] args) throws InterruptedException {
		// to start a firefox driver
		System.setProperty("webdriver.gecko.driver", "folder path of geckodriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		// to make the driver wait until the any action taken to accomplish its
		// task
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		// Opening the URL on a given browser
		driver.get("http://www.yahoo.com/");
		driver.findElement(By.xpath("//*[@id='uh-search-box']")).sendKeys("halo");
		// To get the current URL, Some times while you click a link it
		// redirects you to a new URL, so that we can get the url and assert it
		String url = driver.getCurrentUrl();
		System.out.println(url);
		// Returns the title of the current web page
		String title = driver.getTitle();
		System.out.println(title);
		// Returns the whole HTML code of the page
		// that you may need to log and experiment on it
		String pageSource = driver.getPageSource();
		System.out.println(pageSource);
		/*
		 * WebDriver give a unique ID for every page. The following command
		 * helps you to get ID of the current page We use ID when we need to
		 * switch from one page to another page, alert iframe, or browser.
		 */
		String id = driver.getWindowHandle();
		System.out.println(id);

		// to find all pages controlled by the driver
		Set<String> ids = driver.getWindowHandles();
		System.out.println(ids);

		// three different ways to iterate through the ids
		// using forEach method
		ids.forEach(i -> {
			System.out.println("using forEach method:" + i);
		});
		// using simple for loop
		for (String s : ids) {
			System.out.println("Using simple for loop: " + s);
		}
		// using java iterator
		Iterator<String> i = ids.iterator();
		while (i.hasNext()) {
			System.out.println("Using iterator:" + i.next());
		}

		// Login logout from infotek solutions website
		// The following line clicks Login button and the login popup will be
		// open
		driver.findElement(By.partialLinkText("Sign in")).click();
		// insert user name and password.
		driver.findElement(By.id("login-username")).sendKeys("Solomon");
		driver.findElement(By.id("login-signin")).click();
		driver.findElement(By.id("login-passwd")).sendKeys("asrat2me");
		// now to login we can click the login button
		driver.findElement(By.id("login-signin")).click();
		driver.findElement(By.xpath("//*[@id='topnav']/ul/li/a/img")).click();
		driver.findElement(By.xpath("//*[@id='logged_box']/ul/li[3]/a")).click();
		driver.findElement(By.partialLinkText("log out")).click();

		// navigating back and forth

		driver.navigate().back(); // clicks the browser back button located on
									// top left
		driver.navigate().forward(); // clicks the browser forward button
		driver.navigate().refresh(); // refreshes the page, we use it by the
										// time when we need to refill a form
										// again.
		Thread.sleep(3000); // sleep for 300 milliseconds
		driver.quit(); // smooth close, waits the page until it finishes its
						// task and then close.

	}

}