package automation.challange.testcontext;

import io.restassured.response.Response;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {
    @Getter
    @Setter
    protected Response restassuredResponse;

    @Getter
    @Setter
    private String[] strArrayInContext;

    @Getter
    @Setter
    private String strInContext;

    @Getter
    @Setter
    private HashMap<String, String> dicInContext;
}
