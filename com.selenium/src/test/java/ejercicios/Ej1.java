package ejercicios;

import static org.testng.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Ej1 {
	private static WebDriver driver;
	
	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://es.wikipedia.org/");
	}
	
	@Test
	public void testEjercicio1() {
		WebElement portada = driver.findElement(By.id("n-mainpage-description"));
		assertEquals(portada.getText(), "Portada");
		
		WebElement portal = driver.findElement(By.id("n-portal"));
		assertEquals(portal.getText(), "Portal de la comunidad");
		
		WebElement ayuda = driver.findElement(By.id("n-help"));
		assertEquals(ayuda.getText(), "Ayuda");
		
		WebElement donaciones = driver.findElement(By.id("n-sitesupport"));
		assertEquals(donaciones.getText(), "Donaciones");
	}
	
	@AfterClass
	public static void tearDown() {
		driver.quit();
	}
}
