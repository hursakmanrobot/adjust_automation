package automation.challange.restassured;

import automation.challange.dataprovider.JsonFileParser;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;

import java.io.IOException;

public class OrderService {
    private final String PETSTORE_BASE_URL = "https://petstore.swagger.io/v2";
    public OrderService() throws IOException {
        RestAssured.baseURI = PETSTORE_BASE_URL;
    }

    public Response createNewOrder(String petId) throws IOException {
        JSONObject jsonObject = JsonFileParser.getInstance().getJsonObjectFromFile("src/test/resources/testData/OrderPetRequestBody.json");
        jsonObject.put("petId", petId);
        jsonObject.put("quantity", 1);

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(jsonObject.toString())
                .when().log().all()
                .post("/store/order")
                .then().log().all()
                .extract().response();

        response.then().assertThat().statusCode(200);

        return  response;
    }
}
