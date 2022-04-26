package automation.challange.steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import automation.challange.utils.DriverUtil;

public class BaseStep {


    @Before("@browser")
    public void setup() throws Exception {
        String browserName=System.getProperty("browserName");
        System.out.println(browserName);
        DriverUtil.setWebDriver(browserName);
    }

    @After("@browser")
    public void tearDown(Scenario scenario) {
        DriverUtil.quitDriver(scenario);
    }

}
