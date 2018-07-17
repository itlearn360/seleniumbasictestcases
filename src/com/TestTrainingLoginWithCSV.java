package com;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestTrainingLoginWithCSV {
	public static void main(String[] args) {
		CommonCodes.getDriver();
		CommonCodes.openBrowser("http://www.training.qaonlinetraining.com/wp-login.php");
		String logindetails = getDataFromFile();
		String logins[] = logindetails.split(",");
		System.out.println(logins[0]);
		WebElement email = CommonCodes.getWebElement("id", "user_login");
		email.sendKeys(logins[0]);
		WebElement pass = CommonCodes.getWebElement("id", "user_pass");
		pass.sendKeys(logins[1]);
		pass.submit();
		// CommonCodes.waitforElement("xpath", "//div[@id='topnav']/ul//li//a");
		WebElement logouta = CommonCodes.getWebElement("xpath", "//div[@id='topnav']//ul//li//a");
		CommonCodes.click_element(logouta, "xpath", "//a[contains(text(),'Log out')]");
		WebElement lg = CommonCodes.getWebElement("xpath", "//a[contains(text(),'Log out')]");
		CommonCodes.click_element(lg, "xpath", "//a[contains(text(),'log out')]");
		WebElement lgfinal = CommonCodes.getWebElement("xpath", "//a[contains(text(),'log out')]");
		CommonCodes.click_element(lgfinal, "id", "user_login");
		CommonCodes.closeDriver();
	}

	private static String getDataFromFile() {
		String strLine = null;
		try {
			FileInputStream fstream = new FileInputStream("datafordb.csv");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			strLine = br.readLine();

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return strLine;
	}
}