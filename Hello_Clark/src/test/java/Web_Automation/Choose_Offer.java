package Web_Automation;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;

import PageObject.FunctionalTest;
import Pages.Contracts;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Choose_Offer extends FunctionalTest {
	@Given("^User is at Contract offer page$")
	public void user_is_at_Contract_offer_page() throws Throwable {

	}

	@When("^user choose contract (.*)$")
	public void user_choose_contract(String arg1) throws Throwable {
		contract.ChooseOffer(Integer.parseInt(arg1));
	}

	@Then("^user navigates to sign up page$")
	public void user_navigates_to_sign_up_page() throws Throwable {
		Thread.sleep(3000);
		assertTrue("User has not redirected to signup page", contract.Confirmation_redirectedToSignUp());
	}

}
