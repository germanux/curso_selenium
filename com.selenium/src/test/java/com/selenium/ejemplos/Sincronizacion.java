package com.selenium.ejemplos;

import static org.junit.Assert.assertNotNull;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;
import com.google.common.base.Predicate;

public class Sincronizacion {
	private static WebDriver driver;

	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver/geckodriver.exe");
		driver = new FirefoxDriver();
	}

	// @Test
	public void testSincroImplicita() {
		driver.get(SeleniumAPI.RUTA_HTML_API);
		
		driver.manage().timeouts().implicitlyWait(8000, TimeUnit.MILLISECONDS);
				
		WebElement button = driver.findElement(By.cssSelector("#btn-1"));
		assertNotNull(button);
	}

	// @Test
	public void testWebDriverWait() {
		driver.get(SeleniumAPI.RUTA_HTML_API);
		WebElement button;
		try {
			button = driver.findElement(By.cssSelector("#btn-1"));
		} catch (Exception e) {
			System.out.println("     >>>>>>>>>       No ENCONTRADO");
			e.printStackTrace();
		}
		WebDriverWait wait = new WebDriverWait(driver, 8);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#btn-1")));
		
		button = driver.findElement(By.cssSelector("#btn-1"));
		assertNotNull(button);
	}

	@Test
	public void testFluentWait() {
		driver.get(SeleniumAPI.RUTA_HTML_API);

		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofMillis(8000))
				.pollingEvery(Duration.ofMillis(600))
				.ignoring(Exception.class);
		
		WebElement button = wait.until(new Function<WebDriver, WebElement>() {

			public WebElement apply(WebDriver inputDriver) {
				WebElement boton = driver.findElement(By.cssSelector("#btn-1"));
				System.out.println("    >>>>>>> " + boton.getText());
				if (boton.getText().equalsIgnoreCase("Pulsar")) {
					System.out.println("    >>>>>>> Encontrado");
					return boton;
				} else {
					System.out.println("    >>>>>>> NO Encontrado!!");
					return null;
				}
			}			
		});		
	}

	@AfterClass
	public static void tearDown() {
		driver.quit();
	}
}
