package com.selenium.ejercicios;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Ej2 {
	private static WebDriver driver;
	
	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/chromedriver/chromedriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://es.wikipedia.org/");
	}
	
	@Test
	public void testEjercicio2() {
		List<WebElement> enlaces = driver.findElement(By.id("p-navigation")).findElement(By.className("body")).findElements(By.tagName("li"));
		for (WebElement enlace: enlaces) {
			assertNotNull(enlace);
		}
		assertEquals(enlaces.size(), 9);
	}
	
	@AfterClass
	public static void tearDown() {
		driver.quit();
	}
}
