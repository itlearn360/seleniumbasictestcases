package com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment4Alerts {

public static void main(String[] args) {
// working with 3 types of alerts. This code uses my own simple html
// to run it you need to run the html code I have as well and
// you need to change the url path accordingly
System.setProperty("webdriver.gecko.driver", "folder path of geckodriver\\geckodriver.exe");	
String url="http://www.training.qaonlinetraining.com/testPage.php";
WebDriver driver= new FirefoxDriver();
driver.get(url);
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//alert witching
driver.findElement(By.id("alert")).click();
Alert alert= driver.switchTo().alert();
System.out.println(alert.getText());
alert.accept(); // change by alert.dismiss() and see the difference

//confirmation popup switching
driver.findElement(By.xpath("//button[@onclick='confirmMe()']")).click();
alert = driver.switchTo().alert();
//canceling the request, means press "Cancel" on the alert
alert.dismiss();// chenge by alert.accept() and see the difference

// working with popup prompts
driver.findElement(By.xpath("//button[@onclick='promptMe()']")).click();
alert=driver.switchTo().alert();
alert.sendKeys("infotek solution");
alert.accept();// change by alert.cancle() and see the difference

Select oSelect = new Select(driver.findElement(By.name("country")));

oSelect.selectByIndex(2);
//driver.close();
}

}