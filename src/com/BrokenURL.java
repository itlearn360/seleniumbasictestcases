package com;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

public class BrokenURL {
	public static void main(String[] args) {

		List<String> validlinks = new ArrayList<String>();
		List<String> invalids = new ArrayList<String>();
		CommonCodes.getDriver();
		CommonCodes.openBrowser("http://www.qaonlinetraining.com");
		List<WebElement> elements = CommonCodes.getWebElements("css", "a");

		for (int i = 0; i < elements.size(); i++) {
			WebElement element = elements.get(i);
			String hyperlink = element.getAttribute("href");

			boolean valid_status = getlinkStatus(hyperlink);
			if (valid_status) {
				System.out.println("valid");
				validlinks.add(element.getText() + " : hyperlink " + hyperlink);
			} else {
				invalids.add(element.getText() + " : hyperlink " + hyperlink + "\n");
			}

		}

		System.out.println("Total links which are on active status" + validlinks.size());
		System.out.println("Total links which are not on active status" + invalids.size() + invalids);
		CommonCodes.closeDriver();
	}

	private static boolean getlinkStatus(String hyperlink) {
		// TODO Auto-generated method stub
		try {
			HttpURLConnection.setFollowRedirects(true);

			HttpURLConnection con = (HttpURLConnection) new URL(hyperlink).openConnection();
			con.setRequestMethod("HEAD");
			boolean statuscode = con.getResponseCode() == HttpURLConnection.HTTP_OK;
			if (!statuscode) {

				con = (HttpURLConnection) new URL(hyperlink).openConnection();
				statuscode = con.getResponseCode() == HttpURLConnection.HTTP_OK;
			}
			return statuscode;
		} catch (ClassCastException e) {

			return false;
		} catch (MalformedURLException e) {

			return false;
		} catch (IOException e) {
			return false;

		}

	}
}