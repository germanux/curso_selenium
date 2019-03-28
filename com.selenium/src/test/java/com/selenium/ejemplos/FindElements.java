package com.selenium.ejemplos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class FindElements {
	private static WebDriver driver;
	private static final String RUTA_HTML = "file:///D:/Trabajo/Formacion/_CURSO_SELENIUM/com.selenium/src/test/resources/index.html";

	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.gecko.driver",
				"src/test/resources/drivers/geckodriver/geckodriver.exe");
		driver = new FirefoxDriver();
	}
	@Test
	public void byId() {
		driver.get(RUTA_HTML);
		WebElement username=driver.findElement(By.id("input-user"));
		WebElement passwd=driver.findElement(By.id("input-pass"));
		assertNotNull(username);
		assertNotNull(passwd);
	}
	@Test
	public void byName() {
		driver.get(RUTA_HTML);
		WebElement username=driver.findElement(By.name("username"));
		WebElement passwd=driver.findElement(By.name("password"));
		assertNotNull(username);
		assertNotNull(passwd);
	}
	@Test
	public void byClassName() {
		driver.get(RUTA_HTML);
		WebElement username=driver.findElement(By.className("in-user"));
		WebElement passwd=driver.findElement(By.className("in-pass"));
		assertNotNull(username);
		assertNotNull(passwd);
	}

	@Test
	public void byClassName2_Hijos() {
		driver.get(RUTA_HTML);
		WebElement username=driver.findElement(By.id("loginForm"))
				.findElement(By.className("in-user"));
		WebElement passwd=driver.findElement(By.id("loginForm"))
				.findElement(By.className("in-pass"));
		assertNotNull(username);
		assertNotNull(passwd);
	}
	@Test
	public void byTagName() {
		driver.get(RUTA_HTML);
		List<WebElement> labels = driver.findElements(By.tagName("label"));
		for (WebElement label : labels) {
			assertNotNull(label);
		}
		assertEquals(labels.size(), 2);
	}

	@Test
	public void byLinkText() {
		driver.get("https://www.google.com/");
		WebElement gmailLink = driver.findElement(By.linkText("Gmail"));
		assertEquals(gmailLink.getAttribute("href"), 
				"https://mail.google.com/mail/?tab=wm");
	}
	@Test
	public void byPartialLinkText() {
		driver.get("https://www.google.com/");
		WebElement gmailLink = driver.findElement(By.partialLinkText("Gma"));
		assertEquals(gmailLink.getAttribute("href"), 
				"https://mail.google.com/mail/?tab=wm");
	}
	@Test
	public void byXPath_1() {
		driver.get(RUTA_HTML);
		WebElement boton = driver.findElement(By.xpath("/html/body/form/input"));
		assertEquals(boton.getAttribute("value"), "Login");
	}
	@Test
	public void byXPath_2() {
		driver.get(RUTA_HTML);
		WebElement boton = driver.findElement(By.xpath("//input[@type='submit']"));
		assertEquals(boton.getAttribute("value"), "Login");
	}
	@Test
	public void byXPath_3() {
		driver.get(RUTA_HTML);
		WebElement boton = driver.findElement(By.xpath("/html/body/form/div[2]/input[@name='password']"));
		assertEquals(boton.getAttribute("placeholder"), "Un ejemplo...");
	}

	@Test
	public void byXPath_4() {
		driver.get(RUTA_HTML);
	}
	
	@AfterClass
	public static void tearDown() {
		driver.quit();
	}
}




