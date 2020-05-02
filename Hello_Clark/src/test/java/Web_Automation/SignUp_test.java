package Web_Automation;

import static org.junit.Assert.assertTrue;

import java.util.Random;

import Helper.Common_help;
import PageObject.FunctionalTest;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SignUp_test extends FunctionalTest{


@Given("^user sets email as (.*)$")
public void user_sets_email_as_yopmail_com(String email) throws Throwable {
	String email_temp=Common_help.generateString(new Random(),8);
	email=email_temp+email;
	signup.setEmail(email);
    
}

@Given("^password as (.*)$")
public void password_as_W_lcome(String password) throws Throwable {
	signup.setPassword(password);
    
}

@When("^user clicks Jetzt registrieren$")
public void user_clicks_Jetzt_registrieren() throws Throwable {
	signup.clickSignUpButton();
    
}

@When("^picks Anrede as (.*)$")
public void picks_Anrede_as_Male(String sex) throws Throwable {
	if(sex.equalsIgnoreCase("male"))
		signup.clickMale();
	if(sex.equalsIgnoreCase("female"))
		signup.clickFemale();
    
}

@When("^sets firstname as (.*)$")
public void sets_firstname_as_Nidal(String first_name) throws Throwable {
	signup.setFirstName(first_name);
    
}

@When("^sets lastname as (.*)$")
public void sets_lastname_as_Knaneh(String last_name) throws Throwable {  
	signup.setLastName(last_name);
	
}

@When("^picks birthday as (.*)$")
public void picks_birthday_as(String birthday) throws Throwable {
	signup.setBirthday(birthday);
    
}
@When("^sets StraBe as (.*)$")
public void sets_StraBe_as(String strabe) throws Throwable {
	signup.setRoad(strabe);
}

@When("^sets Hausnr as (.*)$")
public void sets_Hausnr_as(String haunsr) throws Throwable {
	signup.setHouse(haunsr);
    
}

@When("^sets PLZ as (.*)$")
public void sets_PLZ_as(String plz) throws Throwable {
	signup.setPLZ(plz);
    
}

@When("^sets ort as (.*)$")
public void sets_ort_as(String ort) throws Throwable {
	signup.setPlace(ort);
    
}

@When("^sets Telefonnummer as (.*)$")
public void sets_Telefonnummer_as(String telephone) throws Throwable {
signup.setPhoneNumber(telephone);
    
}

@Then("^clicks Weiter$")
public void clicks_Weiter() throws Throwable {
    
    signup.clickcontinue_AfterfillingPersonalInfo();
}

@Then("^signup complete$")
public void signup_complete() throws Throwable {
	assertTrue("User is not signed up!", signup.SignUp_Complete());
	
}


}
