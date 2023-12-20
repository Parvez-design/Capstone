from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC


class LoginPage:

    def __init__(self, driver):
        self.driver = driver

    userName = (By.XPATH, "//input[@id='user-name']")
    password = (By.XPATH, "//input[@id='password']")
    submit = (By.XPATH, "//input[@id='login-button']")
    text = (By.CSS_SELECTOR, "h3[data-test='error']")

    def userNames(self):
        return self.driver.find_element(*LoginPage.userName)
    def passwords(self):
        return self.driver.find_element(*LoginPage.password)
    def submits(self):
        return self.driver.find_element(*LoginPage.submit)

    def texterror(self):
        element = WebDriverWait(self.driver, 10).until(EC.presence_of_element_located((By.CSS_SELECTOR,"h3[data-test='error']")))
        return element