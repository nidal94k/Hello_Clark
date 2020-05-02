package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * A super class that used for providing the mechanism for finding elements.
 *
 */
public class PageObjects {
    protected WebDriver driver;
    protected WebDriverWait wait20;//wait for 20 seconds
    protected WebDriverWait wait7;//wait for 7 seconds
    public PageObjects(WebDriver driver){
        this.driver = driver;
        wait20 = new WebDriverWait(driver, 20);
        wait7 = new WebDriverWait(driver, 7);
        PageFactory.initElements(driver, this);
        
    }
}
