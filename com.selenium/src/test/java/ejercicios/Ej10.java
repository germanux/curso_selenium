package ejercicios;

import static org.junit.Assert.assertFalse;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Ej10 {
	private static WebDriver driver;
	
	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/chromedriver/chromedriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://es.wikipedia.org/wiki/Especial:Contribuciones");
	}
	
	@Test
	public void testEjercicio10() {
		WebElement newbie = driver.findElement(By.id("newbie"));
		WebElement user = driver.findElement(By.id("user"));
		
		assertFalse(newbie.isSelected());
		assertTrue(user.isSelected());
		
		newbie.click();

		assertTrue(newbie.isSelected());
		assertFalse(user.isSelected());
	}
	
	@AfterClass
	public static void tearDown() {
		driver.quit();
	}
}
