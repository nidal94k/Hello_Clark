package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import PageObject.PageObjects;
/**
 * First page that the user uses after navigating to the test-page
 * picks which deal he is looking for(Privathaftpflicht,Hausrat..etc)
 * and then answers its question
 *
 */
public class Deals extends PageObjects{
	public Deals(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css="a[href*='request']")
	private WebElement Angebote;
	
	@FindBy(css="div[role='list']>div>div:nth-child(1)>div>div>div")
	private WebElement Privathaftpflicht;
	
	@FindBy(id="consent-broker")
	private WebElement Agreement;
	
	@FindBy(css="button[id*='ember']")
	private WebElement continue_RequestAQuote;
	
	@FindBy(css="ul[id='radioButtonsSingleSelect']")
	private WebElement first_second_third_Question;

	@FindBy(css="input[type='text']")
	private WebElement forth_question;
	
	@FindBy(css="button[class*='primary']")
	private WebElement continueAfter4Q;
	
	@FindBy(css="a[data-test-button-appearance='primary']")
	private WebElement moveToOffer;
	
	@FindBy(css="a[href*='voucher']")
	private WebElement voucher;
	
	@FindBy(id="headline")
	private WebElement headline_;
	
	public void clickDeals()
	{
		wait20.until(ExpectedConditions.elementToBeClickable(Angebote));
		Angebote.click();
	}	
	public void clickPrivathaftpflicht()
	{
		wait20.until(ExpectedConditions.elementToBeClickable(Privathaftpflicht));
		Privathaftpflicht.click();
	}	
	public void clickAgreement()
	{
		wait20.until(ExpectedConditions.elementToBeClickable(Agreement));
		Agreement.click();
	}	
	public void clickAngebotAnfordern_01()
	{
		wait20.until(ExpectedConditions.elementToBeClickable(continue_RequestAQuote));
		continue_RequestAQuote.click();
	}	
	public void AnswerFirstQ(int numberOfAnswer) throws InterruptedException
	{
		wait20.until(ExpectedConditions.elementToBeClickable(first_second_third_Question));
		first_second_third_Question.findElement(By.cssSelector("li:nth-child("+numberOfAnswer+")>div")).click();
	}
	public void AnswerSecondQ(int numberOfAnswer)throws InterruptedException
	{
		int count=0;
//in order to overcome StaleElementReferenceException exception, this method has been given 5*2 seconds to find the element		
		while(count<5)
		{
			try {
			if(headline_.getText().contains("Dienst"))
					count=10;
			else{
		    Thread.sleep(2000);
			}
		}catch (StaleElementReferenceException e) {
		}
		count++;
		}
		wait20.until(ExpectedConditions.elementToBeClickable(first_second_third_Question));
		first_second_third_Question.findElement(By.cssSelector("li:nth-child("+numberOfAnswer+")>div")).click();
	}
	public void AnswerThirdQ(int numberOfAnswer)throws InterruptedException
	{
		int count=0;
//in order to overcome StaleElementReferenceException exception, this method has been given 5*2 seconds to find the element	
		while(count<5)
		{
			try {
			if(headline_.getText().contains("eine"))
					count=10;
			else{
		    Thread.sleep(2000);
			}
			}catch (StaleElementReferenceException e) {
			}
			count++;
		}
		wait20.until(ExpectedConditions.elementToBeClickable(first_second_third_Question));
		first_second_third_Question.findElement(By.cssSelector("li:nth-child("+numberOfAnswer+")>div")).click();
	}
	public void AnswerFourthQ(String answer)throws InterruptedException
	{
		int count=0;
//in order to overcome StaleElementReferenceException exception, this method has been given 5*2 seconds to find the element	
		while(count<5)
		{
			try {
			if(headline_.getText().contains("weitere"))
					count=10;
			else{
		    Thread.sleep(2000);
			}
			}catch (StaleElementReferenceException e) {
			}
			count++;
		}
		wait20.until(ExpectedConditions.elementToBeClickable(forth_question));
		forth_question.sendKeys(answer);
	}
	public void ClickAngebotAnfordern_02()
	{
		wait20.until(ExpectedConditions.elementToBeClickable(continueAfter4Q));
		continueAfter4Q.click();
	}
    public void MoveToOffer()
    {
    	wait20.until(ExpectedConditions.elementToBeClickable(moveToOffer));
    	moveToOffer.click();
    }
    public Boolean ConfirmationContract()
    {//verify that user redirected to the next page successfully
    	try {
    		wait20.until(ExpectedConditions.elementToBeClickable(voucher));
    		return true;
    	}
    	catch (org.openqa.selenium.TimeoutException e2) {
    		return false;
		}
    }
}
