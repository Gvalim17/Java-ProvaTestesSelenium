package automatizados.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BaseTest {
	protected static WebDriver driver;
//	private static final String URL_BASE = "https://www.google.com";
	// private static final String URL_BASE = "file:///C:/Users/guilh/Downloads/sistema/login.html";
	private static final String URL_BASE = "file:///C:/Users/36124872022.2n/Downloads/sistema/produtos.html";
	private static final String PATH_DRIVE = "src/test/resources/chromedriver.exe";
	
	@BeforeClass
	public static void iniciar() {
		System.setProperty("webdriver.chrome.driver", PATH_DRIVE);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL_BASE);
	}
	
	// @AfterClass
	// public static void finalizar() {
	// 	driver.quit();
	// }

}
