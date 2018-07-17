package com;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Assignment8MultiBrowser {

	public static void main(String[] args) throws IOException {
		// This example shows to open flight reservation on Firefox, IE and
		// Chrome browser
		// Let as make this program to prompt us a which browser to use to open
		// our page
		System.out.print("Which browser you want to use:\n Firefox, Chrome, ie?\n type the one here: ");
		System.out.println();
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		String browser = br.readLine();
		WebDriver driver = null;
		if (browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "folder path of geckodriver\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("Chrome")) {
			// java uses '\' as a skip keyword so to use '\' in our path we add
			// another '\' on the front
			System.setProperty("webdriver.chrome.driver", "folder path of chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "folder path of IEdriver\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else {
			System.out.println("Browser you typed '" + browser + "' is not supported\n try agian\n system quite ");
			System.exit(0);
		}
		driver.get("http://www.google.com");
        driver.close();
	}

}