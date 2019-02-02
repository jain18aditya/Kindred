package com.hellofresh.pages;

import org.openqa.selenium.By;

public class HomePage extends PageBase {

	By SearchBox_input = By.xpath("//input[@id='search_query_top']");
	By SubmitSearch_Button = By.xpath("//button[@name='submit_search']");

	//////////////// Consolidate functions//////////////

	public void searchProduct(String productName) {
		waitTillElementVisible(SearchBox_input);
		enter(SearchBox_input, productName);
		waitUntilElementIsClickable(SubmitSearch_Button);
		click(SubmitSearch_Button);
	}

	public void selectProduct(String productName) {
		click(By.xpath("//h5[@itemprop='name']/a[@title='" + productName + "']"));
	}

	public void navigateToSubSectionTab(String section) {
		click(By.xpath("//a[@title='" + section + "']"));
	}

	public String getCurrentURL() {
		return getWebDriver().getCurrentUrl();
	}
}