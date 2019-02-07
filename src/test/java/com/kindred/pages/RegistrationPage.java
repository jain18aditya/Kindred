package com.kindred.pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends PageBase {
	By fname_input = By.xpath("//input[@id='firstName']");
	By lname_input = By.xpath("//input[@id='lastName']");
	By email_input = By.xpath("//input[@id='email']");
	By day_input = By.xpath("//select[@name='day']");
	By month_input = By.xpath("//input[@id='month']");
	By year_input = By.xpath("//input[@id='year']");
	By male_radio = By.xpath("//label[@data-test-name='gender-1']");
	By female_radio = By.xpath("//label[@data-test-name='gender-2']");
	By address_input = By.xpath("//input[@id='address-lookup']");
	By phoneNumber_input = By.xpath("//input[@name='phoneNumber']");
	By continue_button = By.xpath("//button[@name='continue-registration']");
	By password_button = By.xpath("//input[@name='password']");
	By securityAnswer_input = By.xpath("//input[id='securityAnswer']");
	By accept_radio = By.xpath("//label[@data-test-name='directMarketing-true']");
	By termsCondition_checkbox = By.xpath("//label[@data-test-name='termsAndConditionsAcceptDate']/span[@class='custom-checkbox']");
	By submit_button = By.xpath("//button[@name='submit-registration']");
	
	public void selectAddress(String address) {
		click(By.xpath("//span/strong['"+address+"']"));
	}
	
	public void registerUser(HashMap<String, String> userInfo) {
		enter(fname_input, userInfo.get("firstName"));
		enter(lname_input, userInfo.get("lastName"));
		enter(email_input, userInfo.get("userEmail"));
		String arr[] = userInfo.get("dob").split("-");  //Format 02-January-2018
		Select day = new Select(getWebDriver().findElement(day_input));
		day.selectByVisibleText(arr[0]);
		Select month = new Select(getWebDriver().findElement(month_input));
		month.selectByVisibleText(arr[1]);
		Select year = new Select(getWebDriver().findElement(year_input));
		year.selectByValue(arr[2]);
		if (userInfo.get("Gender").contains("Mrs"))
			click(female_radio);
		else
			click(male_radio);
		click(continue_button);
		enter(address_input, userInfo.get("address"));
		selectAddress(userInfo.get("address"));
		enter(phoneNumber_input, userInfo.get("phoneNumber"));
		click(continue_button);
		enter(password_button, userInfo.get("password"));
		enter(securityAnswer_input, userInfo.get("securityAnswer"));
		click(accept_radio);
		click(termsCondition_checkbox);
		click(submit_button);
	}
}
