package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	WebDriver driver;
	public Properties prop;
	public FileInputStream fis;
	public SoftAssert sa;

	public WebDriver initializeDriver() {
		if (driver == null) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			sa = new SoftAssert();
		}
		driver.get("https://www.saucedemo.com/");
		return driver;
	}
	public String getExcelPath() throws IOException {
		prop = new Properties();
		fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\featureFiles\\base.properties");
		prop.load(fis);
		return prop.getProperty("excelPath");
	}
	public String getTitle() {
		return driver.getTitle();
	}
	public String getUrl() {
		return driver.getCurrentUrl();
	}
	public void navigateBack() {
		driver.navigate().back();
	}
	public void closeBrowser() {
		driver.quit();
	}
}
