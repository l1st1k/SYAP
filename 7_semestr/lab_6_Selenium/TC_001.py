from selenium import webdriver
from selenium.webdriver.common.by import By

from cfg import username, password


browser = webdriver.Firefox()
browser.get('http://localhost:8080/login')

username_field = browser.find_element(by=By.ID, value='username')
password_field = browser.find_element(by=By.ID, value='password')

username_field.send_keys(username)
password_field.send_keys(password)

submit_button = browser.find_element(by=By.CSS_SELECTOR, value='button.btn-primary')
submit_button.click()
