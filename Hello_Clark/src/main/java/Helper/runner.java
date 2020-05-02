package Helper;
import org.junit.runner.RunWith;

import PageObject.FunctionalTest;
import cucumber.api.CucumberOptions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/Web_automation/"}
,glue={"Web_Automation"})
public class runner {
}
