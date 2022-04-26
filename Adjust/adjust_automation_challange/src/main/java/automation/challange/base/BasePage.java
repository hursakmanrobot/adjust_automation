package automation.challange.base;

import automation.challange.utils.DriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.util.concurrent.TimeUnit;

public class BasePage {

    protected WebDriver driver;

    protected WebDriverWait wait;

    protected Actions actions;


    public BasePage() {
        this.driver = DriverUtil.driver;
        wait = new WebDriverWait(driver, 30);
        actions = new Actions(driver);
    }

    protected WebDriver getDriver() {
        return driver;
    }

    protected void clickAndWrite(By by, String value) {
        WebElement element = waitUntilVisibleByLocator(by);
        element.click();
        element.sendKeys(value);
    }

    protected WebElement waitUntilVisibleByLocator(By locator) {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitUntilPresenceByLocator(By locator) {

        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected WebElement waitUntilClickableByLocator(By locator) {

        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected void click(By locator) {
        WebElement element = waitUntilPresenceByLocator(locator);
        waitUntilClickableByLocator(locator);
        element.click();
    }

    protected void waitUntilClickableByElement(WebElement element) {

        new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitUntilVisibleElement(WebElement element) {

        new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOf(element));
    }

    protected boolean isElementPresent(By by){
        try{
            driver.findElement(by);
            return true;
        }
        catch(NoSuchElementException e){
            return false;
        }
    }

    protected String getText(By locator) {
        return waitUntilVisibleByLocator(locator).getText();
    }

}
