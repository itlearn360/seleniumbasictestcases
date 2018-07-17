package com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment9FileUploading {

public static void main(String[] args) {
/* By the time when you uplaod a file a windows directory explorer opens to choose your file
whihc is out of the controle of Selenium. To solve this problem there are two methods
1. use your own sendkyes() tricks
2. if sendkyes() is not active, we will be forced to use external tracking tools in the middle like 'autoit'
in this example I will show you how to use your own tricks to uplaod to a website*/
System.setProperty("webdriver.gecko.driver", "folder path of geckodriver\\geckodriver.exe");
WebDriver driver = new FirefoxDriver();
driver.get("https://www.megaupload.us/");
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
WebElement upload = driver.findElement(By.id("add_files_btn"));
upload.sendKeys("C:\\Users\\jayan\\Pictures\\Screenshots\\Screenshot.png");
WebDriverWait wait = new WebDriverWait(driver, 15);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uploadButton")));
driver.findElement(By.id("uploadButton")).click();
System.out.println("File uploaded successfully");
}

}