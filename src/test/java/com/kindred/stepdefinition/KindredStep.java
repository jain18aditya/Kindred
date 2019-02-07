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
}
