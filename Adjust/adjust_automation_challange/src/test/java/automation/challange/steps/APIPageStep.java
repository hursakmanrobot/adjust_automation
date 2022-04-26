package automation.challange.steps;

import automation.challange.restassured.OrderService;
import automation.challange.restassured.PetService;
import automation.challange.restassured.UserService;
import automation.challange.testcontext.ScenarioContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class APIPageStep {
    private UserService restUserService;
    private PetService restPetService;
    private OrderService restOrderService;
    ScenarioContext scenarioContext;

    public APIPageStep() throws IOException {
        this.restUserService = new UserService();
        this.restPetService = new PetService();
        this.restOrderService = new OrderService();
        this.scenarioContext = new ScenarioContext();
    }

    @Then("^Check Pet Created$")
    public void checkPetCreated() {
        restPetService.checkPet(scenarioContext.getRestassuredResponse());
    }

    @Given("^Create New Pet$")
    public void createNewPet() throws IOException {
        Response response = restPetService.createNewPet();
        scenarioContext.setRestassuredResponse(response);
    }

    @And("^Order Created Pet$")
    public void orderCreatedPet() throws IOException {
        Response response = scenarioContext.getRestassuredResponse();

        String id = response.body().path("id").toString();
        restOrderService.createNewOrder(id);
    }

    @And("^Update Pet And Check$")
    public void updatePetAndCheck() {
        Response response = scenarioContext.getRestassuredResponse();
        String id = response.body().path("id").toString();
        restPetService.updatePet(id);
    }

    @Given("^Create New User And Check$")
    public void createNewUserAndCheck() throws IOException {
        restUserService.createNewUser();
    }

    @Given("^Login With Existing User And Check$")
    public void loginWithExistingUserAndCheck() throws IOException {
        Map<String, String> map = scenarioContext.getDicInContext();

        restUserService.loginUserAndCheck(map.get("username"), map.get("password"));
    }

    @Given("^Create New User$")
    public void createNewUser() throws IOException {
        int uniqueNum = LocalDateTime.now().getDayOfYear() + LocalDateTime.now().getNano();

        String username = "hur_" + uniqueNum;
        String password = String.valueOf(uniqueNum);

        restUserService.createNewUser(username, password);
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("username", username);
        map.put("password", password);

        scenarioContext.setDicInContext(map);
    }
}

