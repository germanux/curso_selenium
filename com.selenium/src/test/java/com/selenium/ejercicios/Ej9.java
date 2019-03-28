package com.selenium.ejercicios;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Ej9 {
	private static WebDriver driver;
	
	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://es.wikipedia.org/wiki/Especial:Contribuciones");
	}
	
	@Test
	public void testEjercicio9() {
		Select namespace = new Select(driver.findElement(By.id("namespace")));
		
		assertFalse(namespace.isMultiple());
		assertEquals(namespace.getOptions().size(), 31);
		
		namespace.selectByVisibleText("Usuario");
		assertEquals(namespace.getFirstSelectedOption().getText(), "Usuario");
		
		namespace.selectByValue("8");
		assertEquals(namespace.getFirstSelectedOption().getText(), "MediaWiki");
		
		namespace.selectByIndex(13);
		assertEquals(namespace.getFirstSelectedOption().getText(), "Ayuda");
	}
	
	@AfterClass
	public static void tearDown() {
		driver.quit();
	}
}
