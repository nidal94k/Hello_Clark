package Web_Automation;

import static org.junit.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import PageObject.FunctionalTest;
import Pages.Contracts;
import Pages.Deals;
import Pages.SignUp;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class StartPage extends FunctionalTest{
	@Given("^Testing page (.*)$")
	public void testing_page_https_www_clark_de_de_app_contracts_cv_utm_source_QA_engineersinterview_is_Lanuched(String URL) throws Throwable {
		FunctionalTest.setUp();
		    
	    driver.get(URL);
	    driver.manage().window().maximize();
	}

	@Then("^User is at Testing Page$")
	public void user_is_at_Testing_Page() throws Throwable {
	   wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("ember8"))));
	   assertTrue("Page Has not loaded yet", driver.findElements(By.id("ember8")).size()>0);// verifies that Logo exists
	}


}
