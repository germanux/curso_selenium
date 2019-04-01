package ejercicios;

import static org.junit.Assert.assertNotNull;
import static org.testng.Assert.assertEquals;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Ej3 {
	private static WebDriver driver;
	
	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/chromedriver/chromedriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://es.wikipedia.org/");
	}
	
	@Test
	public void testEjercicio3() {
		WebElement discussion = driver.findElement(By.linkText("Discusión"));
		WebElement contributions = driver.findElement(By.linkText("Contribuciones"));
		WebElement account = driver.findElement(By.linkText("Crear una cuenta"));
		WebElement access = driver.findElement(By.linkText("Acceder"));
		
		assertNotNull(discussion);
		assertNotNull(contributions);
		assertNotNull(account);
		assertNotNull(access);
		
		WebElement mes = driver.findElement(By.partialLinkText("mayo"));
		assertNotNull(mes);
	}
	
	@AfterClass
	public static void tearDown() {
		driver.quit();
	}
}
