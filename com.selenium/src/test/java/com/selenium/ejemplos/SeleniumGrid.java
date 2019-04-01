package com.selenium.ejemplos;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumGrid {
	WebDriver driver;
	String nodeUrl;
	
	@BeforeTest
	public void setUp() throws MalformedURLException {
		nodeUrl = "http://localhost:4444/wd/hub";
//		System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver/geckodriver.exe");
//		FirefoxOptions options = new FirefoxOptions();
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
		driver = new RemoteWebDriver(new URL(nodeUrl), options);
		driver.get("http://www.google.com");
	}
	
	@Test
	public void searchReact() {
		WebElement input = driver.findElement(By.id("lst-ib"));
		input.sendKeys("React");
		input.submit();
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
