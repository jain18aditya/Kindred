package com.kindred.stepdefinition;

import java.util.HashMap;

import org.junit.Assert;

import com.kindred.pages.BlogDetails;
import com.kindred.pages.HomePage;
import com.kindred.pages.LoginPage;
import com.kindred.pages.RegistrationPage;
import com.kindred.utils.ConfigUtil;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class KindredStep {
	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
	RegistrationPage registrationPage = new RegistrationPage();
	BlogDetails blogDetails = new BlogDetails();

	@Given("^Launch browser with url \"([^\"]*)\"$")
	public void launchBrowser(String url) throws Throwable {
		loginPage.launchApplication(ConfigUtil.getProperty(url));
	}

	@When("^User log in with UserName \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void logIn(String userName, String password) throws Throwable {
		loginPage.login(ConfigUtil.getProperty(userName), ConfigUtil.getProperty(password));
		Assert.assertEquals("Unable to login", true, homePage.isUserLoggedIn());
	}

	@Then("^Accept cookies$")
	public void acceptCookies() throws Throwable {
		homePage.acceptCookie();
	}

	@Then("^close the browser$")
	public void terminateBrowser() throws Throwable {
		loginPage.cleanUP();
	}

	@Then("^Logout the user$")
	public void logoutUser() throws Throwable {
		homePage.expandCloseAccount();
		loginPage.logout();
		Assert.assertEquals("Unabble to logout user", true, homePage.isRegisterButtonDisplayed());
	}

	@When("^Register new user$")
	public void registerNewUser() throws Throwable {
		registrationPage.registerUser(getAddressDetails());
	}

	@Then("^User info should be displayed correctly$")
	public void verifyUserInfo() throws Throwable {
		homePage.expandCloseAccount();
		Assert.assertEquals("Invalid user name displayed",
				ConfigUtil.getProperty("first.name") + " " + ConfigUtil.getProperty("last.name"),
				homePage.getUserName());
		homePage.expandCloseAccount();
		homePage.waitTillMyAccountButtonDisabled();
	}

	@Then("^Sidebar option should be displayed correctly$")
	public void verifySidebarOptions() throws Throwable {
		homePage.expandSidebar();
		Assert.assertEquals("sidebar options not displayed", true, homePage.verifySideBardMenu());
	}

	@When("^User serach blog \"([^\"]*)\" using sidebar$")
	public void serachBlogUsingSidebar(String blogName) throws Throwable {
		homePage.expandSidebar();
		homePage.searchBlog(ConfigUtil.getProperty(blogName));
	}

	@Then("^Searched blog with title \"([^\"]*)\" should be displayed$")
	public void verifySearchedBlog(String blogName) throws Throwable {
		Assert.assertEquals("Searched blog not displayed", true,
				blogDetails.isBlogPresent(ConfigUtil.getProperty(blogName)));
	}

	@Then("^verify browser url after search$")
	public void verifyBrowserUrl() throws Throwable {
		loginPage.getCurrentURL().contains(ConfigUtil.getProperty("blog.title"));
		Assert.assertEquals("Invalid URL displayed", true,
				loginPage.getCurrentURL().contains(ConfigUtil.getProperty("blog.title")));
	}

	@When("^User select searched blog \"([^\"]*)\"$")
	public void selectSearchedBlog(String blogName) throws Throwable {
		blogDetails.selectBlog(ConfigUtil.getProperty(blogName));
	}

	@Then("^Blog details should be displayed correctly$")
	public void verifyBlogDetails() throws Throwable {
		Assert.assertEquals("Invalid blog displayed", ConfigUtil.getProperty("blog.title"),
				blogDetails.getBlogHeading());
	}

	@When("^open serach box using sidebar$")
	public void openSearchBox() throws Throwable {
		homePage.expandSidebar();
		homePage.searchBlog("a");
	}

	@When("^User serach blog with \"([^\"]*)\" by using search button$")
	public void serachBlogUsingSearchButton(String blogName) throws Throwable {
		blogDetails.searchBlog(ConfigUtil.getProperty(blogName));
	}

	@When("^User serach blog with \"([^\"]*)\" by using autosuggest options$")
	public void serachBlogUsingAutosuggest(String blogName) throws Throwable {
		blogDetails.searchBlogUsingAutoSuggest(ConfigUtil.getProperty(blogName));
	}

	@When("^clear search box using cross button and search$")
	public void clearSearchBox() throws Throwable {
		blogDetails.clearSearch();
		blogDetails.search();
	}

	@Then("^verify search result$")
	public void verifySearchResult() throws Throwable {
		Assert.assertEquals("Invalid result displayed", "No search results", blogDetails.getEmptyInvalidResultValue());
	}

	/////////// Consolidated function////////////////
	private HashMap<String, String> getAddressDetails() {
		HashMap<String, String> addressDetails = new HashMap<String, String>();
		addressDetails.put("firstName", ConfigUtil.getProperty("first.name"));
		addressDetails.put("lastName", ConfigUtil.getProperty("last.name"));
		addressDetails.put("userEmail", ConfigUtil.getProperty("new.email"));
		addressDetails.put("street", ConfigUtil.getProperty("street"));
		addressDetails.put("postcode", ConfigUtil.getProperty("postcode"));
		addressDetails.put("city", ConfigUtil.getProperty("city"));
		addressDetails.put("dob", ConfigUtil.getProperty("dob"));
		addressDetails.put("phoneNumber", ConfigUtil.getProperty("phone.number"));
		addressDetails.put("password", ConfigUtil.getProperty("password"));
		addressDetails.put("securityAnswer", ConfigUtil.getProperty("security.answer"));
		addressDetails.put("gender", ConfigUtil.getProperty("gender"));
		return addressDetails;
	}
}
