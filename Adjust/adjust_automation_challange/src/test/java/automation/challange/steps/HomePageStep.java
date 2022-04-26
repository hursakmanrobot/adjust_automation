package automation.challange.steps;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import automation.challange.pages.HomePage;
import cucumber.api.java.en.When;

import java.lang.String;

public class HomePageStep {
    private HomePage homePage;

    public HomePageStep() {
        this.homePage = new HomePage();
    }

    @Given("Navigate to HomePage")
    public void navigateTooHomePage() {
        homePage.navigateToHomePage();
    }

    @Then("^Check Wikipedia Logo$")
    public void checkWikipediaLogo() {
        homePage.wikipediaLogoCheck();
    }

    @When("^I want to search \"([^\"]*)\" text on Wikipedia search page and check$")
    public void iWantToSearchTextOnWikipediaSearchPage(String text){
        homePage.searchAnyTextAndCheck(text);
    }

    @When("^I want to search \"([^\"]*)\" text on Wikipedia search page and check it is does not exists$")
    public void iWantToSearchTextOnWikipediaSearchPageAndCheckItIsDoesNotExists(String text){
        homePage.searchAnyTextAndCheckIsDoesNotExists(text);
    }

    @When("^I want to search Complex Regular Expression text on Wikipedia search page and check$")
    public void iWantToSearchComplexRegularExpressionTextOnWikipediaSearchPageAndCheck() {
        homePage.searchComplexTextAndCheckMessage();
    }
}

