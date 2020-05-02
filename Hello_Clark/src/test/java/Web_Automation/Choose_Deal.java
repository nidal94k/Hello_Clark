package Web_Automation;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;

import PageObject.FunctionalTest;
import Pages.Deals;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Choose_Deal extends FunctionalTest{
	@Given("^user clicks Angebote$")
	public void user_clicks_Angebote() throws Throwable {
	     deal.clickDeals();
	}

	@Given("^user clicks Privathaftpflicht$")
	public void user_clicks_Privathaftpflicht() throws Throwable {
	    
	     deal.clickPrivathaftpflicht();

	}

	@Given("^user accept agreement$")
	public void user_accept_agreement() throws Throwable {
	    
	     deal.clickAgreement();
	}

	@When("^user cicks requeste a quote$")
	public void user_cicks_requeste_a_quote() throws Throwable {
	    
	     deal.clickAngebotAnfordern_01();	    
	}

	@When("^answers first question (.*)$")
	public void answers_first_question(String arg1) throws Throwable {
	    
	     deal.AnswerFirstQ(Integer.parseInt(arg1));
	}

	@When("^answers second question (.*)$")
	public void answers_second_question(String arg1) throws Throwable {
	    
		deal.AnswerSecondQ(Integer.parseInt(arg1));
	}

	@When("^answers third question (.*)$")
	public void answers_third_question(String arg1) throws Throwable {
	    
		deal.AnswerThirdQ(Integer.parseInt(arg1));
	}

	@When("^sets fourth question as (.*)$")
	public void sets_fourth_question_as_NA(String answer) throws Throwable {
	    
		deal.AnswerFourthQ(answer);
	}

	@When("^user clicks Requte Quote$")
	public void user_clicks_Requte_Quote() throws Throwable {
		deal.ClickAngebotAnfordern_02();	    
	}

	@Then("^Offer is ready$")
	public void offer_is_ready() throws Throwable {
	    
		assertTrue("User has not been offerred a contract!", deal.ConfirmationContract());
		deal.MoveToOffer();
	}
}
