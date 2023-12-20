package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	By userName = By.xpath("//input[@id='user-name']");
	By password = By.xpath("//input[@id='password']");
	By errorMsg = By.cssSelector("h3[data-test='error']");
	By submit = By.xpath("//input[@id='login-button']");
	
	public void setUserNamePassword(String username, String pass) {
		driver.findElement(userName).clear();
		driver.findElement(userName).sendKeys(username);
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys(pass);
	}
	public String errorMsg() {
		new WebDriverWait(driver, Duration.ofSeconds(10)).
		until(ExpectedConditions.visibilityOfAllElementsLocatedBy(errorMsg));
		return driver.findElement(errorMsg).getText();
	}
	public void clickSubmit() {
		driver.findElement(submit).click();
	}
}
