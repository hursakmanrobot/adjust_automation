package automation.challange.restassured;

import automation.challange.dataprovider.JsonFileParser;
import automation.challange.restassured.restresponsemodels.DataModel;
import automation.challange.restassured.restresponsemodels.ErrorResponseModel;
import automation.challange.restassured.restresponsemodels.UserResponseModel;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Random;

public class UserService {
    private final String PETSTORE_BASE_URL = "https://petstore.swagger.io/v2";

    public UserService() throws IOException {
        RestAssured.baseURI = PETSTORE_BASE_URL;
    }

    public Response createNewUser() throws IOException {
        JSONObject jsonObject = JsonFileParser.getInstance().getJsonObjectFromFile("src/test/resources/testData/CreateUserRequestBody.json");

        int uniqueNum = LocalDateTime.now().getDayOfYear() + LocalDateTime.now().getNano();

        String username = "hur_" + uniqueNum;
        jsonObject.put("username", username);

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(jsonObject.toString())
                .when().log().all()
                .post("/user")
                .then().log().all()
                .extract().response();

        response.then().assertThat().statusCode(200);

        return  response;
    }

    public Response createNewUser(String username, String password) throws IOException {
        JSONObject jsonObject = JsonFileParser.getInstance().getJsonObjectFromFile("src/test/resources/testData/CreateUserRequestBody.json");
        jsonObject.put("username", username);
        jsonObject.put("username", password);

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(jsonObject.toString())
                .when().log().all()
                .post("/user")
                .then().log().all()
                .extract().response();

        response.then().assertThat().statusCode(200);


        return  response;
    }

    public void loginUserAndCheck(String username, String password){
        Response response = RestAssured.given()
                .queryParam("username", username)
                .queryParam("password", password)
                .when().log().all()
                .get("/user/login")
                .then().log().all()
                .extract().response();


        response.then().assertThat().statusCode(200);
        String message = response.body().path("message").toString();
        message.contains("logged in user");
    }
}
