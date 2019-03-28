package com.selenium.ejercicios;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Ej5 {
	private static WebDriver driver;
	
	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
	}
	
	@Test
	public void testEjercicio5() {
		WebElement table = driver.findElement(By.xpath("//*[@id='customers']"));
		assertNotNull(table);
		
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		assertEquals(rows.size(), 7);
		
//		List<WebElement> lastRowCells = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr[last()]/td"));
		List<WebElement> lastRowCells = rows.get(rows.size() - 1).findElements(By.xpath("./td"));
		assertEquals(lastRowCells.size(), 3);
		
//		List<WebElement> last2Rows = driver.findElements(By.xpath("//*[@id='customers']/tbody/tr[position()>5]"));
		List<WebElement> last2Rows = table.findElements(By.xpath("./tbody/tr[position()>5]"));
		assertEquals(last2Rows.size(), 2);

//		List<WebElement> cells = table.findElements(By.tagName("td"));
		List<WebElement> cells = table.findElements(By.xpath(".//td"));
		assertEquals(cells.size(), 18);
		for (WebElement cell : cells) {
			assertFalse(cell.getText().length() == 0);
		}
	}
	
	@AfterClass
	public static void tearDown() {
		driver.quit();
	}
}
