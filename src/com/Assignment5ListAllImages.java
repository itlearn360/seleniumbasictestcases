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

public class Assignment5ListAllImages {
public static void main(String[] args) throws InterruptedException {
System.setProperty("webdriver.gecko.driver", "folder path of geckodriver\\geckodriver.exe");
WebDriver driver = new FirefoxDriver();
driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
driver.get("http://www.training.qaonlinetraining.com/");
String title=driver.getTitle();

//finding all links and print down the sours page
List<WebElement> imageList = (List<WebElement>) driver.findElements(By.tagName("img"));

for(WebElement link: imageList){

System.out.println("----------------------");//to increase print readability
System.out.println("Image source: " + link.getAttribute("src"));
//to get the location of each link in the page
Point p= link.getLocation();
System.out.println("Location of the link is: ("+ p.x + "," + p.y + ")");

}
driver.close();
}
}