package utilities;

import pageObjects.PageObjectManager;

public class TestContextSetup {
	public BaseTest baseTest;
	public PageObjectManager pom;
	public ReadExcel readexcel;
	public TestContextSetup() {
		baseTest = new BaseTest();
		pom = new PageObjectManager(baseTest.initializeDriver());
		readexcel = new ReadExcel();
	}
}
