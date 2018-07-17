package com;

import java.util.logging.Level;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestLogs {
public static void main(String[] args) {
	DesiredCapabilities d = DesiredCapabilities.chrome();
    LoggingPreferences logPrefs = new LoggingPreferences();
    logPrefs.enable(LogType.SERVER, Level.ALL);
    d.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
    System.setProperty("webdriver.chrome.driver", "E:\\Softwares\\chromedriver_win32\\chromedriver.exe");
    WebDriver driver = new ChromeDriver(d);
    driver.get("http://www.talentspiral.com");
    LogEntries les = driver.manage().logs().get(LogType.SERVER);
    for (LogEntry le : les) {
        System.out.println(le.getMessage());
    }
    driver.close();
}
}
