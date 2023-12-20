import pytest

from PageObjects.HomePage import HomePage
from PageObjects.LoginPage import LoginPage
from utilites.BaseClass import BaseClass
from selenium.webdriver.common.by import By

from utilites.test_readExcel import readData

class TestvalidateLogin(BaseClass):
    @pytest.mark.parametrize("userName, password", readData())
    def test_loginValidation(self, userName, password):
        loginPage = LoginPage(self.driver)
        loginPage.userNames().send_keys(userName)
        loginPage.passwords().send_keys(password)
        loginPage.submits().click()
        curUrl = self.driver.current_url
        if "inventory" not in curUrl:
            print(curUrl)
            errorMsg = loginPage.texterror().text
            print(errorMsg)
        else:
            curUrl = self.driver.current_url
            title = self.driver.title
            print(title)
            assert "Swag Labs" in title
            assert "inventory" in curUrl

        # self.driver.find_element(By.XPATH, "//input[@id='user-name']").send_keys("abcd")
        # self.driver.find_element(By.XPATH, "//input[@id='password']").send_keys("abcd")
        # self.driver.find_element(By.XPATH, "//input[@id='login-button']").click()

