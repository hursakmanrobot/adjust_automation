package automation.challange.restassured;

import automation.challange.dataprovider.JsonFileParser;
import automation.challange.restassured.restresponsemodels.CreatePetModel;
import automation.challange.restassured.restresponsemodels.DataModel;
import automation.challange.restassured.restresponsemodels.PetCategoryModel;
import automation.challange.restassured.restresponsemodels.UserResponseModel;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;

public class PetService {
    private final String PETSTORE_BASE_URL = "https://petstore.swagger.io/v2";
    public PetService() throws IOException {
        RestAssured.baseURI = PETSTORE_BASE_URL;
    }

    public Response createNewPet() throws IOException {
        RestAssured.baseURI = PETSTORE_BASE_URL;

        JSONObject jsonObject = JsonFileParser.getInstance().getJsonObjectFromFile("src/test/resources/testData/CreatePetRequestBody.json");

        int uniqueNum = LocalDateTime.now().getDayOfYear() + LocalDateTime.now().getNano();

        String petName = "pet_" + uniqueNum;
        jsonObject.put("name", petName);

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(jsonObject.toString())
                .when().log().all()
                .post("/pet")
                .then().log().all()
                .extract().response();

        response.then().assertThat().statusCode(200);

        return  response;
    }

    public void checkPet(Response response) {
        String id = response.body().path("id").toString();
        Response res = RestAssured.get("/pet/" + id);

        res.then().assertThat().statusCode(200);
    }

    public void updatePet(String id){
        Response res = RestAssured
                .given()
                .contentType("application/x-www-form-urlencoded; charset=utf-8")
                .formParam("name", "updatedDog")
                .when().post("/pet/" + id);

        res.then().assertThat().statusCode(200);
    }
}
