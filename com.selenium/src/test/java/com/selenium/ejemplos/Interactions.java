package com.selenium.ejemplos;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Interactions {
	private static WebDriver driver;
	private static final String RUTA_HTML_3 = "file:///D:/Trabajo/Formacion/_CURSO_SELENIUM/curso_selenium/com.selenium/src/test/resources/index3.html";

	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver/geckodriver.exe");
		driver = new FirefoxDriver();
	}
	
	@Test
	public void textBoxSubmit() {
		driver.get("http://www.google.com");
		// Pausador.pausa(1);
		//TODO: Añadir ejemplo
	}
	
	@Test
	public void textBoxClick() {
		driver.get("http://www.google.com");
		//TODO: Añadir ejemplo
	}
	
	@Test
	public void getTextFromElement() {
		driver.get(RUTA_HTML_3);
		//TODO: Añadir ejemplo
	}
	
	@Test
	public void getCssValueAndAttribute() {
		driver.get(RUTA_HTML_3);
		WebElement mensaje = driver.findElement(By.id("mensaje"));
		assertEquals(mensaje.getAttribute("value"), "Hola mundo!!!");
		assertEquals(mensaje.getCssValue("width"), "200px");
	}
	
	@Test
	public void testDropdown() {
		driver.get(RUTA_HTML_3);
		Select coches = new Select(driver.findElement(By.id("listaCoches")));

		//TODO: Añadir ejemplo
	}
	
	@Test
	public void testDropdownMultiple() {
		driver.get(RUTA_HTML_3);
		Select colores = new Select(driver.findElement(By.id("colores")));
		
		assertTrue(colores.isMultiple());
		assertEquals(colores.getOptions().size(), 4);
		
		colores.selectByVisibleText("Yellow");
		colores.selectByValue("red");
		assertEquals(colores.getAllSelectedOptions().size(), 2);

		//TODO: Añadir ejemplo
	}
	
	@Test
	public void testCorrectOptions() {
		driver.get(RUTA_HTML_3);
		
		ArrayList<String> listaMeses = new ArrayList<String>();
		listaMeses.add("Enero");
		listaMeses.add("Febrero");
		listaMeses.add("Marzo");
		listaMeses.add("Abril");
		listaMeses.add("Mayo");

		//TODO: Añadir ejemplo
	}
	
	@Test
	public void testRadioButtons() {
		driver.get(RUTA_HTML_3);
		WebElement radioMañana = driver.findElement(By.xpath("//input[@type='radio' and @value='mañana']"));
		//TODO: Añadir ejemplo
	}
	
	@Test
	public void testCheckBoxes() {
		driver.get(RUTA_HTML_3);
		
		WebElement checkMusica = driver.findElement(By.xpath("//input[@value='musica']"));
		assertFalse(checkMusica.isSelected());

		//TODO: Añadir ejemplo
	}
	
	@AfterClass
	public static void tearDown() {
		driver.quit();
	}
}
