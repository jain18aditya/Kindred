package com.kindred.stepdefinition;

import com.kindred.pages.HomePage;
import com.kindred.pages.LoginPage;
import com.kindred.utils.ConfigUtil;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class KindredStep {
	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
	String email;

	@Given("^Launch browser with url \"([^\"]*)\"$")
	public void launchBrowser(String url) throws Throwable {
		loginPage.launchApplication(ConfigUtil.getProperty(url));
	}

	@When("^User log in with UserName \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void logIn(String userName, String password) throws Throwable {
		loginPage.login(ConfigUtil.getProperty(userName), ConfigUtil.getProperty(password));
	}

	@Then("^close the browser$")
	public void terminateBrowser() throws Throwable {
		loginPage.cleanUP();
	}

	@Then("^Logout the user$")
	public void logoutUser() throws Throwable {
		loginPage.logout();
	}
	
	@When("^Register new user$")
	public void registerNewUser() throws Throwable {
	}

	@Then("^User info should be displayed correctly$")
	public void verifyUserInfo() throws Throwable {
	}

	@Then("^Sidebar option should be displayed correctly$")
	public void verifySidebarOptions() throws Throwable {
	}

	@When("^User serach blog \"([^\"]*)\" using sidebar$")
	public void serachBlogUsingSidebar(String blogName) throws Throwable {
	}

	@Then("^Searched blog with title \"([^\"]*)\" should be displayed$")
	public void verifySearchedBlog(String arg1) throws Throwable {
	}

	@Then("^verify browser url after search$")
	public void verifyBrowserUrl() throws Throwable {
	}

	@When("^User select searched blog \"([^\"]*)\"$")
	public void selectSearchedBlog(String arg1) throws Throwable {
	}

	@Then("^Blog details should be displayed correctly$")
	public void verifyBlogDetails() throws Throwable {
	}

	@When("^open serach box using sidebar$")
	public void openSearchBox() throws Throwable {
	}

	@When("^User serach blog with \"([^\"]*)\" by using search button$")
	public void serachBlogUsingSearchButton(String arg1) throws Throwable {
	}

	@When("^User serach blog with \"([^\"]*)\" by using autosuggest options$")
	public void serachBlogUsingAutosuggest(String arg1) throws Throwable {
	}

	@When("^clear search box using cross button$")
	public void clearSearchBox() throws Throwable {
	}

	@Then("^verify search result$")
	public void verifySearchResult() throws Throwable {
	}
}
