package com;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DownloadChrome {

	public static void main(String[] args) {
		//path of chromedriver...
		System.setProperty("webdriver.chrome.driver", "E:\\Softwares\\chromedriver_win32\\chromedriver.exe");
		// Create a profile
		ChromeOptions options = new ChromeOptions();
		String downloadFilepath = "E:/uploads";
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		// Setting preferences and setting downloading path
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadFilepath);
		chromePrefs.put("safebrowsing.enabled", "false"); 
		// creating map of chrome options and setting preferences to chrome options.
		HashMap<String, Object> chromeOptionsMap = new HashMap<String, Object>();
		options.setExperimentalOption("prefs", chromePrefs);
		options.addArguments("--test-type");
		//creating desired capability and setting up capabilities 
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMap);
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		// Create Webdriver object
		WebDriver driver = new ChromeDriver(options);

		// Set implicit wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Maximize window
		driver.manage().window().maximize();

		// Open APP to download application
		driver.get("https://filehippo.com/download_aiseesoft-free-video-converter/");

		// Click on download
		driver.findElement(By.xpath("//div[@class='program-header-download-link-container']/a")).click();
		//driver.close();
	}

}