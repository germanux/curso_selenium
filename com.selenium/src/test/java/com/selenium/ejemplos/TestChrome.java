package com.selenium.ejemplos;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestChrome {

	private static WebDriver driver;
	
	@BeforeClass
	public static void inicializacion()  {
		System.setProperty("webdriver.chrome.driver",
				"src/test/resources/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
	}
	@Test
	public void goToGoogle() {
		driver.get("http://www.google.com");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@AfterClass
	public static void cerrarDriver() {
		driver.quit();
	}
}
