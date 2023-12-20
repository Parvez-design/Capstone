import pytest
from selenium import webdriver
from webdriver_manager.chrome import ChromeDriverManager
from selenium.webdriver.chrome.service import Service as ChromeService



# def setup():
#     print("Hey, I am setup")
@pytest.fixture()
def setup(request):
    driver = webdriver.Chrome(service=ChromeService(ChromeDriverManager().install()))
    driver.implicitly_wait(10)
    driver.get("https://www.saucedemo.com/")
    request.cls.driver = driver
    print("invoked...")
    yield
    driver.close()
