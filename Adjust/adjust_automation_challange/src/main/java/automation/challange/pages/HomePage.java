package automation.challange.pages;

import automation.challange.base.BasePage;
import automation.challange.keywords.WebElements;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import static automation.challange.keywords.WebElements.WikipediaSearchPageElements.*;
import static org.junit.Assert.assertTrue;

public class HomePage extends BasePage implements WebElements {
    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    private static final java.lang.String HOME_PAGE_URL = WikipediaSearchPageElements.rootMainPageloginURL;

    public void navigateToHomePage() {
        getDriver().get(HOME_PAGE_URL);
    }

    public void wikipediaLogoCheck(){

        if(isElementPresent(wikipediaLogo))
        {
            System.out.println("Wikipedia logo successfully displayed");
        }

        else
        {
            Assert.fail("The Wikipedia logo could not be displayed successfully!!!");
        }

    }

    public void searchAnyTextAndCheck(String text){
        EnterTextToSearchbox(text);
        CheckSearchResult(text);
    }

    public void searchAnyTextAndCheckIsDoesNotExists(String text){
        EnterTextToSearchbox(text);
        DoesNotExistsTextSearchCheck(text);
    }

    public void searchComplexTextAndCheckMessage(){
        EnterTextToSearchbox(complexRegularExpressionSearchText);
        ComplexRegularExpressionMeesageCheck();
    }

    private void EnterTextToSearchbox(String text){
        clickAndWrite(wikipediaSearchTextbox, text);
        click(searchButton);
    }

    private void CheckSearchResult(String text){
        waitUntilPresenceByLocator(searchResultLabel);
        String searchResultLabelText = getText(searchResultLabel);

        char ch='"';
        text = ch+text+ch;

        assertTrue(searchResultLabelText.contains("There is a page named "+ text +" on Wikipedia"));
    }

    private void DoesNotExistsTextSearchCheck(String text){
        waitUntilPresenceByLocator(doesNotExistsLabel);
        String doesNotExistsLabelText = getText(doesNotExistsLabel);

        char ch='"';
        text = ch+text+ch;

        assertTrue(doesNotExistsLabelText.contains("The page "+ text +" does not exist. You can ask for it to be created."));
    }

    private void ComplexRegularExpressionMeesageCheck(){
        waitUntilPresenceByLocator(complexRegularExpressionMessageLabel);
        String complexRegularExpressionMessageLabelText = getText(complexRegularExpressionMessageLabel);
        assertTrue(complexRegularExpressionMessageLabelText.contains(complexRegularExpressionMessage));
    }
}


