package ejercicios;

import static org.junit.Assert.assertFalse;
import static org.testng.Assert.fail;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Ej12 {
	private static WebDriver driver;
	
	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://es.wikipedia.org/w/index.php?title=Especial:Crear_una_cuenta");
	}
	
	@Test
	public void testEjercicio12() {
		if (!isElementPresent(By.id("noExist"))) {
			System.out.println("Lo sabia!!!");
		}
		
		if (!isElementPresent(By.id("noExist"))) {
			fail("El elemento #userLoginForm no se encuentra en la página");
		}
		
		if (!isElementPresent(By.id("wpEditToken"))) {
			WebElement editToken = driver.findElement(By.id("wpEditToken"));
			assertFalse(editToken.isDisplayed());
		}
	}
	
	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@AfterClass
	public static void tearDown() {
		driver.quit();
	}
}
