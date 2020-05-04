package Pages;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Helper.Common_help;
import PageObject.PageObjects;
/**
 * The class covers all elements of choosing bank account and accepting final buy of the contract
 * + the flow of verifying that the contract is the same one that the user has chosen
 *
 */
public class Contracts extends PageObjects{

public Contracts(WebDriver driver) {
		super(driver);
	}

@FindBy(css="div[class='offer-details__options']>div:nth-child(2)>div:nth-child(2)>button")
private WebElement Offer1;

@FindBy(css="div[class='offer-details__options']>div:nth-child(3)>div:nth-child(2)>button")
private WebElement Offer2;

@FindBy(css="div[class='offer-details__options']>div:nth-child(4)>div:nth-child(2)>button")
private WebElement Offer3;

@FindBy(css="label[for='termsCheck']")
private WebElement AceeptAgrementBeforeBuy;

@FindBy(css="button[class*='primary']")
private WebElement Buy;

@FindBy(css="input[class*='iban-input']")
protected static WebElement BankAccount;

@FindBy(css="label[for='ibanCheck']")
private WebElement checkAgreement;

@FindBy(css="button[class*='primary']")
private WebElement Continue2;

@FindBy(css="h1[class*='iban-offer-form']")
private WebElement Offer_header;

@FindBy(css="h1[class='offers__confirmation__header__title']")
private WebElement Order_Completed;

@FindBy(css="button[class*='primary']")
private WebElement Back_overView;

@FindBy(css="button[class*='close']")
private WebElement close_notifaction;


@FindBy(css="div[class='offer-details__options']>div:nth-child(2)>div:nth-child(2)>h5")
private WebElement Offer1_name_html;
private String offer1_string;

@FindBy(css="div[class='offer-details__options']>div:nth-child(3)>div:nth-child(2)>h5")
private WebElement Offer2_name_html;
private String offer2_string;

@FindBy(css="div[class='offer-details__options']>div:nth-child(4)>div:nth-child(2)>h5")
private WebElement Offer3_name_html;
private String offer3_string;

@FindBy(css="div[class='_subtitle_niboal']")
private WebElement contract_name_in_manager_route;

public void ChooseOffer(int numberOfOffer)
{
	offer1_string="";
	offer2_string="";
	offer3_string="";
	
	wait20.until(ExpectedConditions.elementToBeClickable(Offer1));
			
	if(numberOfOffer==1) {
//if the user picks the first offer then save the text(name of company that provides the contract) to verify it later
		Offer1.click(); offer1_string=Offer1_name_html.getText();
	}
	if(numberOfOffer==2) {
		Offer2.click(); offer2_string=Offer2_name_html.getText();
	}
	if(numberOfOffer==3) {
		Offer3.click(); offer3_string=Offer3_name_html.getText();
	}
}

public void AceeptAgrementBeforeBuy() throws InterruptedException
{
	int temp_count=0;
//in order to overcome StaleElementReferenceException exception, this method has been given 7*1 seconds to find the element
	while(temp_count<7) {
		try {
	wait20.until(ExpectedConditions.visibilityOf(Offer_header));
	temp_count=7;
		}
		catch (StaleElementReferenceException e) {
		}
		Thread.sleep(1000);
	temp_count++;
	}
	JavascriptExecutor jsExec = (JavascriptExecutor) driver;
	//scroll down
	jsExec.executeScript("document.getElementsByClassName('offer-checkout__details__bottom-trust offer-checkout__details offer-checkout__details__bottom-trust offer-checkout__details__bottom-trust--left').scrollDown += 100");
	Thread.sleep(2000);
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", AceeptAgrementBeforeBuy);//viewport adjustments 
	Actions actions2 = new Actions(driver);
	actions2.moveToElement(AceeptAgrementBeforeBuy).click().build().perform();
}

public void ClickBuy()
{
	wait20.until(ExpectedConditions.elementToBeClickable(Buy));
	Buy.click();
}
public Boolean Confirmation_redirectedToSignUp()
{//verify that user redirected to the next page successfully
	try {
		wait20.until(ExpectedConditions.visibilityOf(SignUp.emailAdress));
		return true;
	}
	catch (org.openqa.selenium.TimeoutException e2) {
		return false;
	}
}

public void SetBankAccount(String bank)
{
	wait20.until(ExpectedConditions.visibilityOf(BankAccount));
	BankAccount.sendKeys(bank);
}
public void clickAgreement_AfterfillingBankAccount()
{
	wait20.until(ExpectedConditions.elementToBeClickable(checkAgreement));
	checkAgreement.click();
}
public void clickcontinue_AfterfillingBankAccount()
{
	wait20.until(ExpectedConditions.elementToBeClickable(Continue2));
	Continue2.click();
}
public Boolean Confirmation_OrderCompleted()
{
	try {
		wait20.until(ExpectedConditions.visibilityOf(Order_Completed));
		return true;
	}
	catch (org.openqa.selenium.TimeoutException e2) {
		return false;
	}

}
public void click_backOverView()
{
	wait20.until(ExpectedConditions.elementToBeClickable(Back_overView));
	Back_overView.click();
	wait20.until(ExpectedConditions.elementToBeClickable(close_notifaction));//do you like Clark notification
	close_notifaction.click();
}


public Boolean Verify_contractAdded()
{
//since the html value (of the contract name) is shown in HTML while decoded (&and*),I have created a method that encodes it.
	offer1_string=Common_help.encoderStringHTML(offer1_string);
	offer2_string=Common_help.encoderStringHTML(offer2_string);
	offer3_string=Common_help.encoderStringHTML(offer3_string);

	try {
		wait20.until(ExpectedConditions.visibilityOf(contract_name_in_manager_route));
		if(offer1_string.equals(contract_name_in_manager_route.getText()) ||
				offer2_string.equals(contract_name_in_manager_route.getText()) ||
						offer3_string.equals(contract_name_in_manager_route.getText()))
		return true;//if the picked deal is the same as the shown one, return true
	}
	catch (org.openqa.selenium.TimeoutException e2) {
		return false;
	}
	return false;
	}


}
