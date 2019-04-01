package ejercicios;

import static org.junit.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class Ej15 {
	private static WebDriver driver;
	
	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://es.wikipedia.org/wiki/Wikipedia:Portada");
	}
	
	@Test
	public void testEjercicio15() {
		WebElement searchButton = driver.findElement(By.id("searchButton"));
		searchButton.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.titleContains("Buscar"));
		
		WebElement multimedia = driver.findElements(By.cssSelector("#search .search-types li")).get(1);
		multimedia.click();
	
		WebElement searchBox = driver.findElement(By.cssSelector("#searchText .oo-ui-inputWidget-input"));
		searchBox.clear();
		searchBox.sendKeys("selenium");
		searchBox.submit();
		
		FluentWait<WebDriver> fWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofMillis(1000))
				.pollingEvery(Duration.ofMillis(200))
				.ignoring(Exception.class);
		
		
		WebElement resultsElem = fWait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver arg0) {
				WebElement elem = arg0.findElement(By.className("results-info"));
				if (elem != null) {
					return elem;
				} else {
					return null;
				}
			}
		});
		
		assertTrue(resultsElem.isDisplayed());
		
		assertTrue(driver.getTitle().endsWith("- Wikipedia, la enciclopedia libre"));
	}
	
	@AfterClass
	public static void tearDown() {
		driver.quit();
	}
}
