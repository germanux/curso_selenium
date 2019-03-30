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
	private static final String RUTA_HTML = "file:///D:/Trabajo/Formacion/_CURSO_SELENIUM/curso_selenium/com.selenium/src/test/resources/index.html";
	private static final String RUTA_HTML_2 = "file:///D:/Trabajo/Formacion/_CURSO_SELENIUM/curso_selenium/com.selenium/src/test/resources/index2.html";

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
		WebElement button1 = driver.findElement(By.xpath("//input[@type='submit' and @value='Login']"));
//		WebElement button1 = driver.findElement(By.xpath("//input[@type='submit' and @value='Logout']"));
		assertEquals(button1.getAttribute("value"), "Login");
		WebElement button2 = driver.findElement(By.xpath("//input[@type='submit' or @value='Logout']"));
//		WebElement button2 = driver.findElement(By.xpath("//input[@type='button' or @value='Logout']"));
		assertEquals(button2.getAttribute("value"), "Login");
		List<WebElement> imagesWithAlt = driver.findElements(By.xpath("//img[not(@alt)]"));
		assertEquals(imagesWithAlt.size(), 1);
	}
	
	@Test
	public void byXPath5() {
		driver.get(RUTA_HTML);
		WebElement input = driver.findElement(By.xpath("//input[@*='password']"));
		assertEquals(input.getAttribute("placeholder"), "Un ejemplo...");
		
		List<WebElement> imagesWithAlt = driver.findElements(By.xpath("//*[@*='password']"));
		assertEquals(imagesWithAlt.size(), 2);
	}
	
	@Test
	public void byCssSelector1() {
		driver.get(RUTA_HTML);
		WebElement username1 = driver.findElement(By.cssSelector("html body form div label"));
		assertEquals(username1.getText(), "Username:");
		WebElement username2 = driver.findElement(By.cssSelector("html > body > form > div > label"));
		assertEquals(username2.getText(), "Username:");
	}
	
	@Test
	public void byCssSelector2() {
		driver.get(RUTA_HTML);
		WebElement username = driver.findElement(By.cssSelector("label"));
		assertEquals(username.getText(), "Username:");
	}
	
	@Test
	public void byCssSelector3() {
		driver.get(RUTA_HTML);
		WebElement username = driver.findElement(By.cssSelector(".in-user"));
		assertNotNull(username);
		
		WebElement pass1 = driver.findElement(By.cssSelector("input#input-pass"));
		assertEquals(pass1.getAttribute("placeholder"), "Un ejemplo...");

		WebElement pass2 = driver.findElement(By.cssSelector("#input-pass"));
		assertEquals(pass2.getAttribute("placeholder"), "Un ejemplo...");
	}
	
	@Test
	public void byCssSelector4() {
		driver.get(RUTA_HTML);
		WebElement password = driver.findElement(By.cssSelector("input[name='password']"));
		assertEquals(password.getAttribute("placeholder"), "Un ejemplo...");
		
		WebElement img = driver.findElement(By.cssSelector("img[alt='Imagen1']"));
		assertEquals(img.getAttribute("name"), "img1");
	}
	
	@Test
	public void byCssSelector5() {
		driver.get(RUTA_HTML);
		WebElement input1 = driver.findElement(By.cssSelector("div#lista-items > ul > li:first-child > input"));
		assertEquals(input1.getAttribute("value"), "Item 1");

		WebElement input2 = driver.findElement(By.cssSelector("div#lista-items > ul > li:nth-child(2) > input"));
		assertEquals(input2.getAttribute("value"), "Item 2");

		WebElement input3 = driver.findElement(By.cssSelector("div#lista-items > ul > li:last-child > input"));
		assertEquals(input3.getAttribute("value"), "Item 3");
	}
	
	@Test
	public void byCssSelector6() {
		driver.get(RUTA_HTML);
		WebElement inputAutofocus = driver.findElement(By.cssSelector("input:focus"));
		assertEquals(inputAutofocus.getAttribute("value"), "Item 1");

		WebElement inputDisabled = driver.findElement(By.cssSelector("input:disabled"));
		assertEquals(inputAutofocus.getAttribute("value"), "Item 1");		
	}
	
	@Test
	public void byJQuery() {
		driver.get(RUTA_HTML_2);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		List<WebElement> elemChecked = (List<WebElement>) js.executeScript("return jQuery.find('#paises-visitados > :checked');");
		assertEquals(elemChecked.size(), 3);
		
		List<WebElement> elemNotChecked = (List<WebElement>) js.executeScript("return jQuery.find('#paises-visitados > input:checkbox:not(:checked)')");
		assertEquals(elemNotChecked.size(), 2);		
	}
	
	
	@AfterClass
	public static void tearDown() {
		driver.quit();
	}
}




