package com.selenium.ejemplos;


import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTestNG {
	private static WebDriver driver;
	
	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://localhost:8080");
	}
	
	@DataProvider
	public Object[][] testData() {
		return new Object[][] {
			{"1", "2", "3"},
			{"3", "10", "13"},
			{"4", "6", "10"},
			{"8", "1", "9"}
		};
	}
	
	@Test(dataProvider = "testData")
	public void testSuma(String num1, String num2, String res) {
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
