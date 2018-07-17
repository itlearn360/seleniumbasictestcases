package com;

public class CheckTitle {
	public static void main(String[] args) {
		CommonCodes.getDriver();
		CommonCodes.openBrowser("https://www.networksolutions.com");
		boolean titlestatus = CommonCodes
				.verifyTitle("Website Design and Hosting | Domains | Website Builder | NetworkSolutions.com");
		if (titlestatus) {
			System.out.println("Title has matched");
		} else {
			System.out.println("Page Title did not match");
		}
		CommonCodes.closeDriver();
	}
}