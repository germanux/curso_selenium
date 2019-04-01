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
	
	//@Test
	public void testDoubleClick() {
		driver.get("http://cookbook.seleniumacademy.com/DoubleClickDemo.html");

		WebElement mensaje = driver.findElement(By.id("message"));
		Actions builder = new Actions(driver);

		builder.doubleClick(mensaje).perform();
		assertEquals(mensaje.getCssValue("background-color"), "rgb(255, 255, 0)");
		
	}
	
	//@Test
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
	
	//@Test
	public void testJavascript() {
		driver.get(RUTA_HTML_API);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("saludar();");

		Alert alert = driver.switchTo().alert();
		assertEquals(alert.getText(), "Hola Babel!!!");
		Pausador.pausa(1);
		alert.accept();
		Pausador.pausa(1);
	}
	
	//@Test
	public void testScreenshots() throws IOException {
		driver.get("http://cookbook.seleniumacademy.com/DragDropDemo.html");

		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		
		File srcFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("src/test/resources/pantallazos/antesDelDragAndDrop.png"));
		
		
		Pausador.pausa(1);
		Actions builder = new Actions(driver);
		builder.dragAndDrop(source, target).perform();
		assertEquals(target.getText(), "Dropped!");

		srcFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("src/test/resources/pantallazos/despuesDelDragAndDrop.png"));
		
		Pausador.pausa(1);
	}
	
	@Test
	public void testEventosWebDriver() {
		EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);
		TraceListener listener = new TraceListener();
		eventDriver.register(listener);		
		
		eventDriver.get("https://es.wikipedia.org/w/index.php?title=Especial:Buscar&search=&fulltext=Buscar&profile=advanced");
		Pausador.pausa(2);
		List<WebElement> checkboxes = eventDriver.findElements(By.cssSelector("input[type='checkbox']"));
		for (WebElement check : checkboxes) {
			if ( ! check.isSelected()) {
				check.click();
			}
		}
		WebElement searchTextBox = eventDriver.findElement(By.cssSelector(".oo-ui-inputWidget-input"));
		searchTextBox.clear();
		searchTextBox.sendKeys("Selenium");
		Pausador.pausa(2);
		searchTextBox.submit();
		// Ahora también provocamos un error:
		eventDriver.findElement(By.cssSelector("QUE no existe"));
				
	}
	
	@AfterClass
	public static void tearDown() {
		driver.quit();
	}
}
