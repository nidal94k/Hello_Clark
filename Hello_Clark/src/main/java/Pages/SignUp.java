package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Helper.Common_help;
import PageObject.PageObjects;
/**
 * A class that covers Sign-up page elements.
 *
 */
public class SignUp extends PageObjects{
	
	public SignUp(WebDriver driver)
	{
		super(driver);		
	}	
	
	@FindBy(css="input[type='email']")
	protected static WebElement emailAdress;
	
	@FindBy(css="input[type='password']")
	private WebElement userPassword;

	@FindBy(css="button[type='submit']")
	private WebElement signup_Button;
	
	@FindBy(css="ul[class*='choices']>li:nth-child(1)>label>span:nth-child(1)>span")
	private WebElement sex_male;
	
	@FindBy(css="ul[class*='choices']>li:nth-child(2)>label>span:nth-child(1)>span")
	private WebElement sex_Female;
	
	@FindBy(css="input[name='firstName']")
	private WebElement firstName;
	
	@FindBy(css="input[name='lastName']")
	private WebElement LastName;
	
	@FindBy(css="input[name='birthdate']")
	private WebElement Birthday_input;
	
	@FindBy(css="input[name='street']")
	private WebElement UserRoad;
	
	@FindBy(css="input[name='houseNumber']")
	private WebElement UserHouse;
	
	@FindBy(css="input[name='zipcode']")
	private WebElement UserPLZ;
	
	@FindBy(css="input[name='city']")
	private WebElement UserPlace;
	
	@FindBy(css="input[name='phoneNumber']")
	private WebElement UserPhoneNumber;
	
	@FindBy(css="button[form='customer-upgrade-profile-form']")
	private WebElement Continue_button;
	
	@FindBy(css="nav[class*='cucumber_header']>ul:nth-child(3)>li:nth-child(2)>a>span")
	private WebElement Profile_button;
	
	@FindBy(css="div[role='menu']>ul:nth-child(1)>li:nth-child(2)")
	private WebElement SignOut;
	
	@FindBy(css="ul[data-view='years']")
	private WebElement years_elements;
	
	@FindBy(css="ul[data-view='months']")
	private WebElement months_elements;
	
	@FindBy(css="ul[data-view='days']")
	private WebElement days_elements;
	

	public void setEmail(String email)
	{
	    wait20.until(ExpectedConditions.visibilityOf(emailAdress));
		emailAdress.sendKeys(email);
	}
	public void setPassword(String password)
	{
		userPassword.sendKeys(password);
	}
	public void clickSignUpButton()
	{
		wait20.until(ExpectedConditions.visibilityOf(signup_Button));
		signup_Button.click();
	}	
	public void clickMale() {
		wait20.until(ExpectedConditions.elementToBeClickable(sex_male));
		Actions actions2 = new Actions(driver);
		actions2.moveToElement(sex_male).click().build().perform();

	}
	public void clickFemale() {
		wait20.until(ExpectedConditions.elementToBeClickable(sex_Female));
		Actions actions2 = new Actions(driver);
		actions2.moveToElement(sex_Female).click().build().perform();
	}
	public void setFirstName(String fname)
	{
		firstName.sendKeys(fname);
	}
	public void setLastName(String lname)
	{
		LastName.sendKeys(lname);
	}
	public void setBirthday(String birthday) throws InterruptedException
	{//first the users enters his birthday as a text, then based on the text, year,month, and day are picked
		Birthday_input.sendKeys(birthday);Thread.sleep(1111);
        String[] birthday_split = birthday.split("\\.");
        String day=birthday_split[1];
        String month_String=Common_help.translateMonth(Integer.valueOf(birthday_split[0]));
        String year=birthday_split[2];        
        
        List<WebElement> years=years_elements.findElements(By.cssSelector("li"));//saves in the list all the years that are shown in DOM
        for(WebElement yearx:years)//loop over the years
        {
        	if(yearx.getText().contains(year)) {//if the year is equal to the year that the user has picked
        		yearx.click();//click on the year
        		break;
        	}
        }
        
        List<WebElement> months=months_elements.findElements(By.cssSelector("li"));
        for(WebElement monthx:months)
        {
        	if(monthx.getText().contains(month_String)) {
        		monthx.click();
        		break;
        	}
        }
        
        List<WebElement> days=days_elements.findElements(By.cssSelector("li"));
        for(WebElement daysx:days)
        {
        	if(daysx.getText().contains(day)) {
        		daysx.click();
        		break;
        	}
        }
		
	}
	public void setRoad(String road)
	{
		UserRoad.sendKeys(road);
	}
	public void setPLZ(String plz)
	{
		UserPLZ.sendKeys(plz);
	}
	public void setHouse(String house)
	{
		UserHouse.sendKeys(house);
	}
	public void setPhoneNumber(String phonenumber)
	{
		UserPhoneNumber.sendKeys(phonenumber);
	}
	public void setPlace(String place)
	{
		UserPlace.sendKeys(place);
	}
	public void clickcontinue_AfterfillingPersonalInfo()
	{
		wait20.until(ExpectedConditions.elementToBeClickable(Continue_button));
		Continue_button.click();
	}

	public Boolean SignUp_Complete()
	{//since there's no profile for the user that can be entered and then verify the data that exists with the data that the user entered
     // verify if the sign-up is completed by the existence of the button 'logout', since it's shown only when he sign up/in
		wait20.until(ExpectedConditions.visibilityOf(Contracts.BankAccount));
		wait7.until(ExpectedConditions.elementToBeClickable(Profile_button));
		Profile_button.click();
		try {
			wait7.until(ExpectedConditions.elementToBeClickable(SignOut));
			return true;
		}
		catch (org.openqa.selenium.TimeoutException e2) {
			return false;
		}
	}
	
	
	
	
}
