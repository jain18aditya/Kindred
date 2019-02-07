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
	public void register_new_user() throws Throwable {
	}

	@Then("^User info should be displayed correctly$")
	public void user_info_should_be_displayed_correctly() throws Throwable {
	}

	@Then("^Sidebar option should be displayed correctly$")
	public void sidebar_option_should_be_displayed_correctly() throws Throwable {
	}

	@When("^User serach blog \"([^\"]*)\"$")
	public void user_serach_blog(String arg1) throws Throwable {
	}

	@Then("^Searched blog with title \"([^\"]*)\" should be displayed$")
	public void searched_blog_with_title_should_be_displayed(String arg1) throws Throwable {
	}

	@Then("^verify browser url after search$")
	public void verify_browser_url_after_search() throws Throwable {
	}

	@When("^User select searched blog \"([^\"]*)\"$")
	public void user_select_searched_blog(String arg1) throws Throwable {
	}

	@Then("^Blog details should be displayed correctly$")
	public void blog_details_should_be_displayed_correctly() throws Throwable {
	}

	@When("^open serach box using sidebar$")
	public void open_serach_box_using_sidebar() throws Throwable {
	}

	@When("^User serach blog with\"([^\"]*)\" by using search button$")
	public void user_serach_blog_with_by_using_search_button(String arg1) throws Throwable {
	}

	@When("^User serach blog with\"([^\"]*)\" by using autosuggest options$")
	public void user_serach_blog_with_by_using_autosuggest_options(String arg1) throws Throwable {
	}

	@When("^clear search box using cross button$")
	public void clear_search_box_using_cross_button() throws Throwable {
	}

	@Then("^verify search result$")
	public void verify_search_result() throws Throwable {
	}

	@When("^User serach blog \"([^\"]*)\" by using search button$")
	public void user_serach_blog_by_using_search_button(String arg1) throws Throwable {
	}
}
