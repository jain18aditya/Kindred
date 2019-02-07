package com.kindred.pages;

import org.openqa.selenium.By;

public class LoginPage extends PageBase {

	By loginEmail_input = By.xpath("//input[@type='email']");
	By password_input = By.xpath("//input[@type='password']");
	By login_button = By.xpath("//button[@data-test-name='btn-login']");
	By logout_button = By.xpath("//span[@class='Log Out']");
	By userOptions_dropdown = By.xpath("//span[@class='balance-type']");

	private void enterUsername(String userName) {
		enter(loginEmail_input, userName);
	}

	private void enterPassword(String password) {
		enter(password_input, password);
	}

	private void clickLoginButton() {
		click(login_button);
	}

	private void clickLogoutButton() {
		click(logout_button);
	}

	///////////////////// Consolidate Methods/////////////////////

	public void launchApplication(String url) {
		getWebDriver().get(url);
	}

	public void login(String userName, String password) {
		enterUsername(userName);
		enterPassword(password);
		clickLoginButton();
	}

	public void logout() {
		clickLogoutButton();
	}
}
