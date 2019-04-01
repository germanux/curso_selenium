package com.selenium.ejemplos;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SeleniumGridParalelos {
	WebDriver driver;
	String nodeUrl, baseUrl;
	
	@BeforeTest
	@Parameters("browser")
	public void setUp(String browser) throws MalformedURLException {
		nodeUrl = "http://localhost:4444/wd/hub";
		if (browser.equalsIgnoreCase("Firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			options.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
			driver = new RemoteWebDriver(new URL(nodeUrl), options);
		} else if (browser.equalsIgnoreCase("IE")) {
			InternetExplorerOptions options = new InternetExplorerOptions();
			options.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
			driver = new RemoteWebDriver(new URL(nodeUrl), options);
		} else {
			ChromeOptions options = new ChromeOptions();
			options.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
			driver = new RemoteWebDriver(new URL(nodeUrl), options);
		}
		driver.get("http://www.google.com");
	}
	
	@Test
	public void f() {
		assertEquals(driver.getTitle(), "Google");
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}