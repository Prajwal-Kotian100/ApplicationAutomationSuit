package stepdefinitions.AdminScreenScenarios;

import io.cucumber.java.en.*;


import org.testng.Assert;
import hooks.Hooks;
import pages.LocatorLoginPage;
import pages.LocatorsAdminPage;

public class UserManagement_AdminSearch {

	LocatorsAdminPage adminPage;

	@Given("User login and navigates to the admin module")
	public void user_login_and_navigates_to_the_admin_module() {
		adminPage = new LocatorsAdminPage(Hooks.driver);
		adminPage.openAdmin();

	}

	@When("User enters the following details {string} {string} {string} and {string}")
	public void user_enters_the_following_details(String username, String userRole, String employeeName, String status) {
		adminPage.enterDetails(username, userRole, employeeName, status);

	}

	@When("User clicks on Search User")
	public void user_clicks_on_search_user() {
		adminPage.clickSearch();

	}

	@Then("User should be able to see the User details successfully")
	public void user_should_be_able_to_see_the_user_details_successfully() {
		 Assert.assertTrue(adminPage.isResultDisplayed());
	}

	@And("User enters the following details {string} {string} {string} and {string} and clicks on Reset")
	public void user_enters_the_following_details_and_reset(String username, String userRole, String employeeName, String status) {
		adminPage.enterDetails(username, userRole, employeeName, status);
		adminPage.clickReset();

	}

	@Then("User should be able to see the details removed successfully")
	public void User_should_be_able_to_see_the_details_removed_successfully() {
		Assert.assertTrue(adminPage.isFieldsCleared());

	}
}