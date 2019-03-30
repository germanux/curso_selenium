package com.selenium.ejemplos;

import static org.junit.Assert.assertNotNull;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;
import com.google.common.base.Predicate;

public class Sincronizacion {
	private static WebDriver driver;

	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver/geckodriver.exe");
		driver = new FirefoxDriver();
	}

//	@Test
	public void testSincroImplicita() {
		driver.get(SeleniumAPI.RUTA_HTML_API);
		;

		//TODO: Añadir ejemplo
		
		WebElement button = driver.findElement(By.cssSelector("#btn-1"));
		assertNotNull(button);
	}

//	@Test
	public void testWebDriverWait() {
		driver.get(SeleniumAPI.RUTA_HTML_API);
		WebElement button;
		try {
			button = driver.findElement(By.cssSelector("#btn-1"));
		} catch (Exception e) {
			System.out.println("     >>>>>>>>>       No ENCONTRADO");
			e.printStackTrace();
		}
		;

		//TODO: Añadir ejemplo
		
		
		button = driver.findElement(By.cssSelector("#btn-1"));
		assertNotNull(button);
	}

//	@Test
	@Test
	public void testFluentWait() {
		driver.get(SeleniumAPI.RUTA_HTML_API);
		;

		//TODO: Añadir ejemplo
	}

	@AfterClass
	public static void tearDown() {
		driver.quit();
	}
}
