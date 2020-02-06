import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertEquals;

public class GoogleSearchTest {

	private WebDriver driver;

	By linkAutomation= By.partialLinkText("Quality stream introduccion a la automizacion de pruebas de ...");

	@Before
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "E:\\Training\\Curso git\\primer_repo\\invie\\src\\test\\resources\\chromedriver\\chromedriver.exe");
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com.co/");
	}
	@Test
	public void testGooglePage() {
		WebElement searchbox=driver.findElement(By.name("q"));
		searchbox.clear();
		searchbox.sendKeys("quality-stream Introducción a la automatización de pruebas de software");
		searchbox.submit();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.printf("ingresa al link");
		assertEquals("quality-stream Introducción a la automatización de pruebas de software - Buscar con Google",driver.getTitle());
		driver.findElement(linkAutomation).click();

		
	}
	@After
	public void tearDown() {
		driver.quit();
	}
}
