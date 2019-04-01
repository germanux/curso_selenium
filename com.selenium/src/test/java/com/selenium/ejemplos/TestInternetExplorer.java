package com.selenium.ejemplos;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestInternetExplorer {
	private static WebDriver driver;
	
	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.ie.driver", "src/test/resources/drivers/IEDriverServer/IEDriverServer.exe");
		driver = new InternetExplorerDriver();
	}
	
	@Test
	public void goToGoogle() {
		driver.get("http://www.google.com");		
	}
	
	@AfterClass
	public static void tearDown() {
		driver.quit();
	}
}
