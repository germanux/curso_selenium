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
	public static final String RUTA_HTML_API = "file:///D:/Trabajo/Formacion/_CURSO_SELENIUM/curso_selenium/com.selenium/src/test/resources/index_api.html";

	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver/geckodriver.exe");
		driver = new FirefoxDriver();
	}
	
	@Test
	public void testDoubleClick() {
		driver.get("http://cookbook.seleniumacademy.com/DoubleClickDemo.html");

		WebElement mensaje = driver.findElement(By.id("message"));
		Actions builder = new Actions(driver);

		builder.doubleClick(mensaje).perform();
		assertEquals(mensaje.getCssValue("background-color"), "rgb(255, 255, 0)");
		
	}
	
	@Test
	public void testDragAndDrop() {
		driver.get("http://cookbook.seleniumacademy.com/DragDropDemo.html");

		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		Pausador.pausa(1);
		Actions builder = new Actions(driver);
		builder.dragAndDrop(source, target).perform();
		assertEquals(target.getText(), "Dropped!");
		Pausador.pausa(1);
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
		
		// eventDriver.get("https://es.wikipedia.org/w/index.php?title=Especial:Buscar&search=&fulltext=Buscar&profile=advanced");

		
		// List<WebElement> checkboxes = eventDriver.findElements(By.cssSelector("div.oo-ui-multiselectWidget-group input[type='checkbox']"));
		//TODO: Añadir ejemplo
	}
	
	@AfterClass
	public static void tearDown() {
		driver.quit();
	}
}
