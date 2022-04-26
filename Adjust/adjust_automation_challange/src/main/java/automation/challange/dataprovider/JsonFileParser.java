package automation.challange.dataprovider;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.util.Arrays;

public class JsonFileParser {

    private static JsonFileParser jsonFileParser = new JsonFileParser();

    private JSONObject jsonObject;

    private JsonFileParser() {
    }

    public static JsonFileParser getInstance() {
        return jsonFileParser;
    }

    //TODO: Do not use more than one JSON library
    public String parseJsonFileAndReturnRequestedDAta(String dataGroup, String requestedData) throws IOException, NullPointerException {
        String path = "src/test/resources/testdata/testdata.json";
        path = path.replace('/', File.separatorChar);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(bufferedReader, JsonObject.class);
        return jsonObject.getAsJsonObject(dataGroup).get(requestedData).getAsString();
    }

    public JSONObject getJsonObjectFromFile(String path) throws IOException, NullPointerException {
        File jsonFile = new File(path);
        if(jsonFile.exists()) {
            InputStream is = new FileInputStream(path);
            String jsonTxt = IOUtils.toString(is, "UTF-8");
            jsonObject = new JSONObject(jsonTxt);
        }
        return jsonObject;
    }

    public JSONObject addValueIfThereIsNestedObjectInJson(String value, JSONObject jsonObject, String[] keys) {
        String currentKey = keys[0];

        if (keys.length == 1) {
            return jsonObject.put(currentKey, value);
        } else if (!jsonObject.has(currentKey)) {
            System.out.println("key value is nested");
            ;
        }
        JSONObject nestedJsonObjectVal;
        try {
            nestedJsonObjectVal = jsonObject.getJSONObject(currentKey);
            jsonObject.put(currentKey, value);
        } catch (JSONException e) {
            nestedJsonObjectVal = jsonObject.put(currentKey, new JSONObject());
            nestedJsonObjectVal = nestedJsonObjectVal.getJSONObject(currentKey);
        }
        String[] remainingKeys = Arrays.copyOfRange(keys, 1, keys.length);
        JSONObject updatedNestedValue = addValueIfThereIsNestedObjectInJson(value, nestedJsonObjectVal, remainingKeys);
        return jsonObject.put(currentKey, updatedNestedValue);
    }

}
