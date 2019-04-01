package com.selenium.ejemplos;

import static org.junit.Assert.assertEquals;

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

@RunWith(Parameterized.class)
public class DataDrivenJUnit {
	private static WebDriver driver;
	private String num1;
	private String num2;
	private String res;
	
	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://localhost:8080");
	}
	
	@Parameters
	public static List<String[]> testData() {
		return Arrays.asList(new String[][] {
			{"1", "2", "3"},
			{"3", "10", "13"},
			{"4", "6", "10"},
			{"8", "1", "9"}
		});
	}
	
	public DataDrivenJUnit(String num1, String num2, String res) {
		this.num1 = num1;
		this.num2 = num2;
		this.res = res;
	}
	
	@Test
	public void testSuma() {
		WebElement campo1 = driver.findElement(By.id("n1"));
		WebElement campo2 = driver.findElement(By.id("n2"));
		campo1.clear();
		campo2.clear();
		campo1.sendKeys(num1);
		campo2.sendKeys(num2);
		
		WebElement btnSuma = driver.findElement(By.id("btn-suma"));
		btnSuma.click();
		
		WebElement campoRes = driver.findElement(By.id("res"));
		assertEquals(campoRes.getText(), res);
	}
	
	@AfterClass
	public static void tearDown() {
		driver.quit();
	}
}
