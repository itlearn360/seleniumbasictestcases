package com;

import org.openqa.selenium.WebElement;

public class CheckLogoRedirection {
	public static void main(String[] args) {
		CommonCodes.getDriver();
		CommonCodes.openBrowser("https://www.networksolutions.com/index.jsp");
		WebElement logoele = CommonCodes.getWebElement("css", "div.header > div.row > div.four > a");
		CommonCodes.click_element(logoele, "css", "div.header > div.row > div.four > a");
		String url = CommonCodes.getCurrentURL();
		if ("https://www.networksolutions.com/index.jsp".equals(url)) {
			System.out.println("Redirection has successed");
		} else {
			System.out.println("Redirect has failed");
		}
		CommonCodes.closeDriver();
	}
}