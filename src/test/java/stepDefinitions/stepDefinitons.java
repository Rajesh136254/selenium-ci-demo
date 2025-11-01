package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.GoogleSearchPage;
import utility.Hooks;

public class stepDefinitons {
    WebDriver driver = Hooks.driver;
    GoogleSearchPage google = new GoogleSearchPage( driver);


    @Given("User is on Google Home Page")
    public void User_is_on_Google_Home_Page(){
        google.googleOpen();
    }

    @When("User Searches for {string}")
    public void User_Searches_for(String text){
        google.Search(text);
    }

    @Then("Page title should contain {string}")
    public void Page_title_should_contain(String text){
        Assert.assertTrue(google.getTitle().contains(text));
    }
}
