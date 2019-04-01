package ejercicios;

import static org.testng.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Ej17 {
	private static WebDriver driver;
	
	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get(Ej17WikipediaMainPage.url);
	}

	@Test
	public void testSearch() {
		Ej17WikipediaMainPage page = new Ej17WikipediaMainPage(driver);
		assertEquals(page.getPlaceholderText(), "Buscar en Wikipedia");
		
		page.setSearchText("Selenium");
		page.search();
		
		assertEquals(driver.getTitle(), "Selenium - Wikipedia, la enciclopedia libre");
	}

	
	@AfterClass
	public static void tearDown() {
		driver.quit();
	}
}
