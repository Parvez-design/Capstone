package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	public PageObjectManager(WebDriver driver){
		this.driver = driver;
	}
	public LoginPage loginPage() {
		return new LoginPage(driver);
	}
	public HomePage homePage() {
		return new HomePage(driver);
	}
}
