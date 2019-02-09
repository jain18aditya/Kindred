package com.kindred.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class HomePage extends PageBase {

	By cookieSettings = By.xpath("//a[@id='CybotCookiebotDialogBodyButtonDetails']");
	By cookieDeclaration = By.xpath("//a[@id='CybotCookiebotDialogDetailBodyContentTabsOverview']");
	By cookieAbout = By.xpath("//a[@id='CybotCookiebotDialogDetailBodyContentTabsAbout']");
	By cookieAcceptButton = By.xpath("//a[@id='CybotCookiebotDialogBodyButtonAccept']");
	By register_button = By.xpath("//span[text()='Register']");
	By sideBarExpand_image = By.xpath("//a[@class='_32MnHnqDy7abNV8KbR66fS']/div/i");
	By blogHome_link = By.xpath("//span[text()='Blog Home']");
	By football_link = By.xpath("//span[text()='Football']");
	By horseRiding_link = By.xpath("//span[text()='Horse Racing']");
	By searchBlog_input = By.xpath("//input[@placeholder='Search in blog']");
	By countryselector_button = By.xpath("//div[@class='widget country-selector header']");
	By mainBalance_label = By.xpath("//span[@data-test-name='balance-cash-amount']");
	By bonusBalance_label = By.xpath("//span[@data-test-name='balance-bonus-amount']");
	By accountExpand_button = By.xpath("//a[contains(@class,'account-box-button')]");
	By userName_label = By.xpath("//div[@data-test-name='userInfoName']");
	By myAccount_button = By.xpath("//span[text()='Account']");

	//////////////// Consolidate functions//////////////

	public void waitTillMyAccountButtonDisabled() {
		waitTillElementDisable(myAccount_button);
	}

	public void acceptCookie() {
		if (isDisplayed(cookieAcceptButton)) {
			click(cookieAcceptButton);
		}
	}

	public void expandSidebar() {
		waitTillElementVisible(sideBarExpand_image);
		clickJS(findElements(sideBarExpand_image).get(0));
	}

	public boolean verifySideBardMenu() {
		waitTillElementVisible(blogHome_link);
		return isDisplayed(blogHome_link) && isDisplayed(football_link) && isDisplayed(horseRiding_link);
	}

	public void searchBlog(String blogTitle) {
		waitTillElementVisible(searchBlog_input);
		enter(searchBlog_input, blogTitle);
		findElement(searchBlog_input).sendKeys(Keys.ENTER);
	}

	public boolean isUserLoggedIn() {
		waitTillElementVisible(mainBalance_label);
		waitTillElementVisible(bonusBalance_label);
		return (isDisplayed(mainBalance_label)) && (isDisplayed(bonusBalance_label));
	}

	public void expandCloseAccount() {
		waitTillElementVisible(accountExpand_button);
		click(accountExpand_button);
	}

	public String getUserName() {
		waitTillElementVisible(userName_label);
		return getText(userName_label);
	}

	public boolean isRegisterButtonDisplayed() {
		waitTillElementVisible(register_button);
		return isDisplayed(register_button);
	}
}