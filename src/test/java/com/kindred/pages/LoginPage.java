package com.kindred.pages;

import java.net.URISyntaxException;

import org.openqa.selenium.By;

public class LoginPage extends PageBase {

	By loginEmail_input = By.xpath("//input[@type='email']");
	By password_input = By.xpath("//input[@type='password']");
	By login_button = By.xpath("//button[@data-test-name='btn-login']");
	By logout_button = By.xpath("//span[text()='Log Out']");
	By userOptions_dropdown = By.xpath("//span[@class='balance-type']");

	///////////////////// Consolidate Methods/////////////////////

	public void launchApplication(String url) {
		getWebDriver().get(url);
	}

	public void login(String userName, String password) {
		enter(loginEmail_input, userName);
		enter(password_input, password);
		click(login_button);
	}

	public void logout() {
		waitTillElementVisible(logout_button);
		click(logout_button);
	}

	public String getCurrentURL() throws URISyntaxException {
		return new java.net.URI(getWebDriver().getCurrentUrl()).getPath();
	}
}
