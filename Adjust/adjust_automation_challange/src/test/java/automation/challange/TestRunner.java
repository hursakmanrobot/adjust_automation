package automation.challange;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/automationChallange",
        strict = false,
        plugin = {"pretty", "html:target/advanced-reports", "json:target/advanced-reports/CucumberTestReport.json"},
        glue = {"automation.challange"})
public class TestRunner {

}
