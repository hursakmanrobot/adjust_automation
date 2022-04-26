package automation.challange.keywords;

import org.openqa.selenium.By;

public interface WebElements {

    interface WikipediaSearchPageElements{
        String rootMainPageloginURL = ("https://en.wikipedia.org/w/index.php?search");
        String complexRegularExpressionSearchText = ("Q1w2e3r4t5y6u7ı8o9p0q1w2e3r4t5y6u7ı8o9p0q1w2e3r4t5y6u7ı8o9p0q1w2e3r4t5y6u7ı8o9p0q1w2e3r4t5y6u7ı8o9p0q1w2e3r4t5y6u7ı8o9p0");
        String complexRegularExpressionMessage = ("An error has occurred while searching: Regular expression is too complex. Learn more about simplifying it here.");
        By wikipediaLogo = By.xpath("//a[@class='mw-wiki-logo']");
        By wikipediaSearchTextbox = By.id("ooui-php-1");
        By searchButton = By.xpath("//button[@type='submit']");
        By searchResultLabel = By.xpath("//*[@id='mw-content-text']/div[3]/p[1]/b");
        By doesNotExistsLabel = By.xpath("//*[@id='mw-content-text']/div[3]/p[1]/i");
        By complexRegularExpressionMessageLabel = By.xpath("//*[@id='mw-content-text']/div[3]/div[1]/p");
    }
}
