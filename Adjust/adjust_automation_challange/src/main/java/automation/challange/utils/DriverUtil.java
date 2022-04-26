package automation.challange.utils;

import cucumber.api.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.Arrays;

public class DriverUtil {
    public static WebDriver driver;

    public static void setWebDriver(String browser) throws Exception {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        if (browser == null) {
            browser = "chrome";
        }
        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/webdrivers/chromedriver.exe");
                driver = new ChromeDriver(options);
                options.addArguments("--headless");
                options.setExperimentalOption("excludeSwitches",
                        Arrays.asList("--disable-popup-blocking"));
                options.addArguments("--disable-notifications");
                options.addArguments("--disable-extensions");
                options.addArguments("--ignore-certificate-errors");

                break;
            case "firefox":
                driver = new ChromeDriver(options);
                break;
            default:
                throw new IllegalArgumentException("Browser \"" + browser + "\" isn't supported.");
        }
    }

    public static void quitDriver(Scenario scenario){
        if(scenario.isFailed()){
            saveScreenshotsForScenario(scenario);
        }
        driver.close();
    }

    private static void saveScreenshotsForScenario(final Scenario scenario) {

        try {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            String testName = scenario.getName();
            scenario.embed(screenshot, "image/png");
            scenario.write(testName);
        } catch (WebDriverException wde) {
            System.err.println(wde.getMessage());
        } catch (ClassCastException cce) {
            cce.printStackTrace();
        }
    }
}
