package Web_Automation;

import static org.junit.Assert.assertTrue;

import PageObject.FunctionalTest;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Finalize_Offer extends FunctionalTest{

@Given("^users adds bank accuunt details (.*)$")
public void users_adds_bank_accuunt_details_DE(String BankDetails) throws Throwable {	    
	contract.SetBankAccount(BankDetails);
}

@Given("^checks on agreement$")
public void checks_on_agreement() throws Throwable {	    
	contract.clickAgreement_AfterfillingBankAccount();
}


@When("^clicks on Tarif bestellen$")
public void clicks_on_Tarif_bestellen() throws Throwable {
	contract.clickcontinue_AfterfillingBankAccount();	    
}	

@Given("^user checks buying agrement$")
public void user_checks_buying_agrement() throws Throwable {
    contract.AceeptAgrementBeforeBuy();
}

@Given("^clicks Jetzt verbindlich kaufen$")
public void clicks_Jetzt_verbindlich_kaufen() throws Throwable {
    contract.ClickBuy();
}

@Then("^order is completed$")
public void order_is_completed() throws Throwable {
    contract.Confirmation_OrderCompleted();
    
}

@Then("^clicks back to review$")
public void clicks_back_to_review() throws Throwable {
    contract.click_backOverView();
    
}

@Then("^verify contract was added$")
public void verify_contract_was_added() throws Throwable {  
    assertTrue("Wrong contract has been added!", contract.Verify_contractAdded());
}


}
