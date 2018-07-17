package com;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Assignment7TableSelection {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "folder path of geckodriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://www.united.com/ual/en/us/flight-search/book-a-flight");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//*[@id='roundTripOption']/div[4]/div[1]/label")).click();
		// driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/div/a")).click();
		String month = driver.findElement(By.className("ui-datepicker-month")).getText();
		String year = driver.findElement(By.className("ui-datepicker-year")).getText();
		DateFormat monthdf = new SimpleDateFormat("MMMM");
		DateFormat yeardf = new SimpleDateFormat("YYYY");
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, 1); // adding a month directly - gives the start
									// of next month.
		String month1 = monthdf.format(c.getTime());
		String year1 = yeardf.format(c.getTime());
		while (!(month.contains(month1) && year.contains(year1))) {
			// go to next month
			driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/div/a")).click();
			month = driver.findElement(By.className("ui-datepicker-month")).getText();
			year = driver.findElement(By.className("ui-datepicker-year")).getText();
		}
		List<WebElement> tableDays = (List<WebElement>) driver
				.findElements(By.xpath("//*[@id='ui-datepicker-div']/div[2]/table/tbody/tr/td/a"));
		for (WebElement trDay : tableDays) {
			if (trDay.getText().contains("21")) {
				trDay.click();
				System.out.println("I clicked 21 date");
				System.exit(0);
			}
		}

	}

}