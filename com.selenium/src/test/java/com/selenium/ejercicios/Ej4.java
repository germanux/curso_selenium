package com.selenium.ejercicios;

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

public class Ej4 {
	private static WebDriver driver;
	
	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/chromedriver/chromedriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://es.wikipedia.org/");
	}
	
	@Test
	public void testEjercicio4() {
		//      //*[@id="p-coll-print_export-label"]
		WebElement print = driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[3]/h3"));
		WebElement otherProjects = driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[4]/h3"));
		WebElement tools = driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[5]/h3"));
		WebElement languages = driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[6]/h3"));
		
		assertNotNull(print);
		assertNotNull(otherProjects);
		assertNotNull(tools);
		assertNotNull(languages);
		
		print = driver.findElement(By.xpath("//*[@id='p-coll-print_export-label']"));
		otherProjects = driver.findElement(By.xpath("//*[@id='p-wikibase-otherprojects-label']"));
		tools = driver.findElement(By.xpath("//*[@id='p-tb-label']"));
		languages = driver.findElement(By.xpath("//*[@id='p-lang-label']"));
		
		assertNotNull(print);
		assertNotNull(otherProjects);
		assertNotNull(tools);
		assertNotNull(languages);
	}
	
	@AfterClass
	public static void tearDown() {
		driver.quit();
	}

}
