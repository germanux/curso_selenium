package ejercicios;

import static org.junit.Assert.assertNotNull;
import static org.testng.Assert.assertEquals;

import java.util.Set;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Ej14 {
	private static WebDriver driver;
	
	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://es.wikipedia.org/wiki/Wikipedia:Portada");
	}
	
	@Test
	public void testEjercicio14() {
		Cookie geoIPCookie = driver.manage().getCookieNamed("GeoIP");
		assertNotNull(geoIPCookie);
		
		Set<Cookie> cookies = driver.manage().getCookies();
		assertEquals(cookies.size() > 0, true);
		
		driver.manage().deleteAllCookies();
		
		cookies = driver.manage().getCookies();
		assertEquals(cookies.size(), 0);
	}
	
	@AfterClass
	public static void tearDown() {
		driver.quit();
	}
}
