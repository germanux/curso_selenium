package ejercicios;

import static org.testng.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Ej8 {
	private static WebDriver driver;
	
	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://es.wikipedia.org/wiki/Wikipedia:Portada");
	}
	
	@Test
	public void testEjercicio8() {
		WebElement searchBox = driver.findElement(By.id("searchInput"));
		WebElement sendButton = driver.findElement(By.id("searchButton"));
		
		String placeholderSearch = searchBox.getAttribute("placeholder");
		assertEquals(placeholderSearch, "Buscar en Wikipedia");
		
		String fontSizeSearch = searchBox.getCssValue("font-size");
		assertEquals(fontSizeSearch, "13px");		
		
		searchBox.clear();
		searchBox.sendKeys("Selenium");
		sendButton.click();
		
		assertEquals(driver.getTitle(), "Selenium - Wikipedia, la enciclopedia libre");
	}
	
	@AfterClass
	public static void tearDown() {
		driver.quit();
	}
}
