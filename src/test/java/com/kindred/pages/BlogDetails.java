package com.kindred.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.kindred.utils.ConfigUtil;

public class BlogDetails extends PageBase {
	By blogList_label = By.xpath("//div[@class='qq-Pyd4MklQfqSfWC1B5j']//h1");
	By blogHeader_label = By.xpath("//h1[@class='_2JIJQ7GO9E4XOiVuXZRAnA']");
	By searchBox_input = By.xpath("//input[@class='_3Hr3qONzU09D2EpcszWrzd']");
	By search_button = By.xpath("//div[@class='_2lZ5TMrGhPdwbRTu6KEV0C']");
	By autoSuggestList = By.xpath("//ul[@class='_1p7av0gr']/li");
	By clearSearch_button = By.xpath("//span[@class='_19GYT_92JLty2kMUxLkxVO']");
	By emptyInvalidResult = By.xpath("//h1[@class='_3j1YMd3zjL1xNt87XF8hqO']");

	/////////////////////// Consolidated functions///////////////////////
	public boolean isBlogPresent(String blogName) {
		List<WebElement> blogList = new ArrayList<WebElement>();
		waitTillElementVisible(blogList_label);
		blogList = findElements(blogList_label);
		for (int i = 0; i < blogList.size(); i++) {
			if (blogList.get(i).getText().contains(blogName)) {
				return true;
			}
		}
		return false;
	}

	public void selectBlog(String blogName) {
		List<WebElement> blogList = new ArrayList<WebElement>();
		blogList = findElements(blogList_label);
		for (int i = 0; i < blogList.size(); i++) {
			if (blogList.get(i).getText().contains(blogName))
				blogList.get(i).click();
		}
	}

	public String getBlogHeading() {
		waitTillElementVisible(blogHeader_label);
		return getText(blogHeader_label);
	}

	public void searchBlog(String blogName) {
		waitTillElementVisible(searchBox_input);
		enter(searchBox_input, blogName);
		search();
	}

	public void searchBlogUsingAutoSuggest(String blogName) throws InterruptedException {
		waitTillElementVisible(searchBox_input);
		enter(searchBox_input, blogName);
		List<WebElement> suggestList = new ArrayList<WebElement>();
		waitTillElementVisible(autoSuggestList);
		suggestList = findElements(autoSuggestList);
		for (int i = 0; i < suggestList.size(); i++) {
			if (ConfigUtil.getProperty("blog.title").contains(suggestList.get(i).getText())) {
				suggestList.get(i).click();
				break;
			}
		}
	}

	public void clearSearch() {
		waitTillElementVisible(clearSearch_button);
		click(clearSearch_button);
	}

	public void search() {
		waitTillElementVisible(search_button);
		click(search_button);
	}

	public String getEmptyInvalidResultValue() {
		waitTillElementVisible(emptyInvalidResult);
		return getText(emptyInvalidResult);
	}
}
