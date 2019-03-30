package com.selenium.ejemplos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.FileReader;
import java.io.IOException;
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
import org.openqa.selenium.support.ui.FluentWait;

import com.google.common.base.Function;
import com.opencsv.CSVReader;

//TODO: Añadir ejemplo
public class DataDrivenCSV {
	private static WebDriver driver;
	private String username;
	private String password;
	private String confirmPassword;
	private String email;
	private String captcha;
	
	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://es.wikipedia.org/w/index.php?title=Especial:Crear_una_cuenta");
	}
	
	//TODO: Añadir ejemplo (funciones testData y getTestData

	
	public DataDrivenCSV(String username, String password, String confirmPassword, String email, String captcha) {
		this.username = username;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.email = email;
		this.captcha = captcha;
	}
	//TODO: Añadir ejemplo
	public void testSignUp() {
		WebElement usernameElement = driver.findElement(By.cssSelector("#wpName2"));
		usernameElement.clear();
		usernameElement.sendKeys(username);

		WebElement passElement = driver.findElement(By.cssSelector("#wpPassword2"));
		passElement.clear();
		passElement.sendKeys(password);

		WebElement confirmPassElement = driver.findElement(By.cssSelector("#wpRetype"));
		confirmPassElement.clear();
		confirmPassElement.sendKeys(confirmPassword);

		WebElement emailElement = driver.findElement(By.cssSelector("#wpEmail"));
		emailElement.clear();
		emailElement.sendKeys(email);

		WebElement captchaElement = driver.findElement(By.cssSelector("#mw-input-captchaWord"));
		captchaElement.clear();
		captchaElement.sendKeys(captcha);

		//TODO: Añadir ejemplo
	}
	
	@AfterClass
	public static void tearDown() {
		driver.quit();
	}

}
