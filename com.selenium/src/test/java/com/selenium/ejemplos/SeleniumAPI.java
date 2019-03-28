package com.selenium.ejemplos;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class SeleniumAPI {
	private static WebDriver driver;
	private static final String RUTA_HTML_API = "file:///D:/Trabajo/Formacion/_CURSO_SELENIUM/curso_selenium/com.selenium/src/test/resources/index_api.html";

	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver/geckodriver.exe");
		driver = new FirefoxDriver();
	}
	
	@Test
	public void testDoubleClick() {
		driver.get("http://cookbook.seleniumacademy.com/DoubleClickDemo.html");
		
		//TODO: Añadir ejemplo
	}
	
	@Test
	public void testDragAndDrop() {
		driver.get("http://cookbook.seleniumacademy.com/DragDropDemo.html");
		//TODO: Añadir ejemplo
	}
	
	@Test
	public void testJavascript() {
		driver.get(RUTA_HTML_API);

		//TODO: Añadir ejemplo
	}
	
	@Test
	public void testScreenshots() throws IOException {
		driver.get("http://cookbook.seleniumacademy.com/DragDropDemo.html");
		//TODO: Añadir ejemplo
	}
	
	@Test
	public void testEventosWebDriver() {
		//TODO: Añadir ejemplo
	}
	
	@AfterClass
	public static void tearDown() {
		driver.quit();
	}
}
