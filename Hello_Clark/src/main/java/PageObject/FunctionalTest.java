package PageObject;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.Contracts;
import Pages.Deals;
import Pages.SignUp;
/**
 * A class that hold all the driver life-cycle management code
 * each test-class extends this class
 * 
 */

public class FunctionalTest {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static SignUp signup;
    public static Deals deal;
    public static Contracts contract;
	
    @BeforeClass
    public static void setUp(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait=new WebDriverWait(driver, 20);
        
        //initialize each page and make it ready-to-use
        deal=new Deals(driver);
        contract=new Contracts(driver);
        signup=new SignUp(driver);

    }
    @After
    public void cleanUp(){
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }

}
