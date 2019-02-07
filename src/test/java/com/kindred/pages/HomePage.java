package com.kindred.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class HomePage extends PageBase {

	By cookieSettings = By.xpath("//a[@id='CybotCookiebotDialogBodyButtonDetails']");
	By cookieDeclaration = By.xpath("//a[@id='CybotCookiebotDialogDetailBodyContentTabsOverview']");
	By cookieAbout = By.xpath("//a[@id='CybotCookiebotDialogDetailBodyContentTabsAbout']");
	By cookieAcceptButton = By.xpath("//a[@id='CybotCookiebotDialogBodyButtonAccept']");
	By register_button = By.xpath("//span[text()='Register']");
	By sideBarExpand_image = By.xpath("//g[@class='svg-icon']");
	By blogHome_link = By.xpath("//span[text()='Blog Home']");
	By football_link = By.xpath("//span[text()='Football']");
	By horseRiding_link = By.xpath("//span[text()='Horse Racing']");
	By searchBlog_input = By.xpath("//input[@placeholder='Search in blog']");
	By countryselector_button = By.xpath("//div[@class='widget country-selector header']");
//	By selectCountryLanguage_
	
	//////////////// Consolidate functions//////////////

	public void acceptCookie(String productName) {
		waitTillElementVisible(cookieAcceptButton);
		click(cookieAcceptButton);
	}

	public String getCurrentURL() {
		return getWebDriver().getCurrentUrl();
	}
	
	public void expandSidebar() {
		waitTillElementVisible(sideBarExpand_image);
		hover(sideBarExpand_image);
	}
	
	public void verifySideBardMenu() {
		isDisplayed(blogHome_link);
		isDisplayed(football_link);
		isDisplayed(horseRiding_link);
	}
	
	public void searchBlog(String blogTitle) {
		waitTillElementVisible(searchBlog_input);
		enter(searchBlog_input, blogTitle);
		findElement(searchBlog_input).sendKeys(Keys.ENTER);
	}
	
	public boolean isBlogDisplyed(String blogTitle) {
		return isDisplayed(By.xpath("//span[text()='"+blogTitle+"']"));
	}
	
	public void selectBlog(String blogTitle) {
		click(By.xpath("//span[text()='"+blogTitle+"']"));
	}
}