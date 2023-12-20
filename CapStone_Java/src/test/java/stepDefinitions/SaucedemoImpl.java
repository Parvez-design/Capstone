package stepDefinitions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import utilities.BaseTest;
import utilities.ReadExcel;
import utilities.TestContextSetup;

public class SaucedemoImpl {
	public TestContextSetup testContextSetup;
	public HomePage homepage;
	public LoginPage loginPage;
	public ReadExcel readExcel;
	public BaseTest baseTest;
	public SaucedemoImpl(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.homepage = testContextSetup.pom.homePage();
		this.loginPage = testContextSetup.pom.loginPage();
		this.readExcel = testContextSetup.readexcel;
		this.baseTest = testContextSetup.baseTest;
	}
	@Given("Launch url and verify the title of the page")
	public void launch_url_and_verify_the_title_of_the_page() {
	    String title = baseTest.getTitle();
	    System.out.println(title);
	    baseTest.sa.assertTrue(title.contains("Swag Labs"));
	}
	@When("Enter multiple {string} username and password and submit")
	public void enter_username_and_password_and_submit(String index) throws FileNotFoundException, IOException, InterruptedException {
		String excelPath = baseTest.getExcelPath();
		Object[] arr = readExcel.Read(new FileInputStream(excelPath),index);
		loginPage.setUserNamePassword(arr[0].toString(), arr[1].toString());
		
//		for(int i=1; i<arr.length-1;i++) {
//			loginPage.setUserNamePassword(arr[i][0], arr[i][1]);
//			loginPage.clickSubmit();
//			String title = baseTest.getTitle();
//			if(baseTest.getUrl().contains("inventory")) {
//				baseTest.navigateBack();
//				baseTest.sa.assertTrue(title.contains("Swag Labs"));
//				System.out.println(title);
//			}
//			else {
//				String errormsg = loginPage.errorMsg();
//				System.out.println(arr[i][0]+" "+arr[i][1]+" has msg: "+errormsg);
//			}
//			
//		}
	}
	@Then("verify the login is successful or not")
	public void verify_the_login_is_successful_or_not() {
		loginPage.clickSubmit();
		String title = baseTest.getTitle();
		if(baseTest.getUrl().contains("inventory")) {
//			baseTest.navigateBack();
			baseTest.sa.assertTrue(title.contains("Swag Labs"));
			System.out.println(title);
			System.out.println("Login Passed");
		}
		else {
			String errormsg = loginPage.errorMsg();
			System.out.println("Login Failed");
//			System.out.println(arr[i][0]+" "+arr[i][1]+" has msg: "+errormsg);
		}
		
		baseTest.closeBrowser();
	    baseTest.sa.assertAll();
	}
	
}
