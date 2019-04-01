package ejercicios;

import static org.testng.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Ej7 {
	private static WebDriver driver;
	
	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://es.wikipedia.org/wiki/Wikipedia:Portada");
	}
	
	@Test
	public void testEjercicio7() {
		WebElement searchBox = driver.findElement(By.id("searchInput"));
		searchBox.clear();
		searchBox.sendKeys("Selenium");
		
		WebElement sendButton = driver.findElement(By.id("searchButton"));
		sendButton.click();
		
		assertEquals(driver.getTitle(), "Selenium - Wikipedia, la enciclopedia libre");
	}
	
	@AfterClass
	public static void tearDown() {
		driver.quit();
	}

}
