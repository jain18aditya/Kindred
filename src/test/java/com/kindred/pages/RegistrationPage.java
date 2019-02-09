package com.kindred.pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends PageBase {
	By register_button = By.xpath("//span[text()='Register']");
	By fname_input = By.xpath("//div[@data-test-name='firstName']//input");
	By lname_input = By.xpath("//input[@id='lastName']");
	By email_input = By.xpath("//input[@id='email']");
	By day_input = By.xpath("//select[@name='day']");
	By month_input = By.xpath("//select[@name='month']");
	By year_input = By.xpath("//select[@name='year']");
	By male_radio = By.xpath("//label[@data-test-name='gender-1']/span[@class='custom-radio']");
	By female_radio = By.xpath("//label[@data-test-name='gender-2']/span[@class='custom-radio']");
	By manualAddress_button = By.xpath("//a[@data-type='manual']");
	By postcode_input = By.xpath("//input[@id='postalCode']");
	By city_input = By.xpath("//input[@id='city']");
	By street_input = By.xpath("//input[@id='street']");
	By phoneNumber_input = By.xpath("//input[@name='phoneNumber']");
	By continue_button = By.xpath("//button[@name='continue-registration']");
	By password_button = By.xpath("//input[@name='password']");
	By securityAnswer_input = By.xpath("//input[@id='securityAnswer']");
	By accept_radio = By.xpath("//label[@data-test-name='directMarketing-true']//span[@class='custom-radio']");
	By termsCondition_checkbox = By
			.xpath("//label[@data-test-name='termsAndConditionsAcceptDate']/span[@class='custom-checkbox']");
	By submit_button = By.xpath("//button[@name='submit-registration']");

	private void selectAddress(HashMap<String, String> userInfo) {
		waitTillElementVisible(manualAddress_button);
		waitUntilElementIsClickable(manualAddress_button);
		JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
		js.executeScript("arguments[0].click();", getWebDriver().findElement(manualAddress_button));
		waitTillElementVisible(street_input);
		enter(street_input, userInfo.get("street"));
		enter(postcode_input, userInfo.get("postcode"));
		enter(city_input, userInfo.get("city"));
	}

	private void continueRegistration() {
		waitTillElementVisible(continue_button);
		waitUntilElementIsClickable(continue_button);
		click(continue_button);
	}

	public void registerUser(HashMap<String, String> userInfo) {
		waitTillElementVisible(register_button);
		click(register_button);
		waitTillElementVisible(fname_input);
		waitUntilElementIsClickable(fname_input);
		enter(fname_input, userInfo.get("firstName"));
		enter(lname_input, userInfo.get("lastName"));
		enter(email_input, userInfo.get("userEmail"));
		String arr[] = userInfo.get("dob").split("-"); // Format 2-January-2018
		Select day = new Select(getWebDriver().findElement(day_input));
		day.selectByVisibleText(arr[0]);
		Select month = new Select(getWebDriver().findElement(month_input));
		month.selectByVisibleText(arr[1]);
		Select year = new Select(getWebDriver().findElement(year_input));
		year.selectByValue(arr[2]);
		if (userInfo.get("gender").contains("Male"))
			click(female_radio);
		else
			click(male_radio);
		continueRegistration();
		selectAddress(userInfo);
		enter(phoneNumber_input, userInfo.get("phoneNumber"));
		findElements(continue_button).get(1).click();
		enter(password_button, userInfo.get("password"));
		enter(securityAnswer_input, userInfo.get("securityAnswer"));
		clickJS(findElements(continue_button).get(2));
		clickJS(findElement(accept_radio));
		clickJS(findElement(termsCondition_checkbox));
		click(submit_button);
	}
}
