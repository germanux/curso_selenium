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

@RunWith(Parameterized.class)
public class Ej16 {
	private static WebDriver driver;
	private String username;
	private String pass;
	private String confirmPass;
	private String email;
	private String captcha;
	
	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://es.wikipedia.org/w/index.php?title=Especial:Crear_una_cuenta");
	}
	
	@Parameters
	public static List<String[]> testData() {
		return Arrays.asList(new String[][] {
			{"robb", "1234", "1234", "robb.st@gmail.com", "yuasd"},
			{"rickon", "3333", "3333", "rickon.st@gmail.com", "jsdks"},
			{"arya", "1010", "1010", "arya.st@gmail.com", "sdsko"},
			{"sansa", "1777", "1777", "sansa.st@gmail.com", "lpijd"},
			{"bran", "0001", "0001", "bran.st@gmail.com", "tsdun"}
		});
	}
	
	public Ej16(String username, String pass, String confirmPass, String email, String captcha) {
		this.username = username;
		this.pass = pass;
		this.confirmPass = confirmPass;
		this.email = email;
		this.captcha = captcha;
	}
	
	@Test
	public void testEjercicio16() {
		WebElement usernameElem = driver.findElement(By.id("wpName2"));
		WebElement passElem = driver.findElement(By.id("wpPassword2"));
		WebElement confirmPassElem = driver.findElement(By.id("wpRetype"));
		WebElement emailElem = driver.findElement(By.id("wpEmail"));
		WebElement captchaElem = driver.findElement(By.id("mw-input-captchaWord"));
		
		usernameElem.clear();
		usernameElem.sendKeys(username);
		passElem.clear();
		passElem.sendKeys(pass);
		confirmPassElem.clear();
		confirmPassElem.sendKeys(confirmPass);
		emailElem.clear();
		emailElem.sendKeys(email);
		captchaElem.clear();
		captchaElem.sendKeys(captcha);
		
		WebElement submitButton = driver.findElement(By.id("wpCreateaccount"));
		submitButton.click();
		
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(Exception.class);
		
		WebElement errorElem = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("error")));
		assertTrue(errorElem.isDisplayed());
		
//		WebElement errorElem = wait.until(new Function<WebDriver, WebElement>() {
//			public WebElement apply(WebDriver arg0) {
//				WebElement elem = arg0.findElement(By.className("error"));
//				if (elem != null) {
//					return elem;
//				} else {
//					return null;
//				}
//			}
//		});
		
		assertNotNull(errorElem);
	}
	
	@AfterClass
	public static void tearDown() {
		driver.quit();
	}
}
