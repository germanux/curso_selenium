package com.selenium.ejercicios;

import static org.junit.Assert.assertEquals;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Ej1 {
	private static WebDriver driver;
	
	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.gecko.driver",
				"src/test/resources/drivers/geckodriver/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://es.wikipedia.org");
	}
	@Test
	public void testEjercicio1() {
		WebElement portada = driver.findElement(By.id("n-mainpage-description"));
		assertEquals(portada.getText()	, "Portada");

		WebElement cambios = driver.findElement(By.id("n-recentchanges"));
		assertEquals(cambios.getText()	, "Cambios recientes");
	}
	@AfterClass
	public static void tearDown() {
		driver.quit();
	}
}
