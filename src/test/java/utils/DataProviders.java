package utils;

import org.testng.annotations.DataProvider;
import tests.BaseTest;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

public class DataProviders extends BaseTest {

    @DataProvider(name = "dp_tc_verifyLogin")
    public static Object[][] dp_tc_verifyLogin() {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = null;

        // Read JSON file
        try {
            Object obj = parser.parse(new FileReader("src/main/resources/testData.json"));
            jsonObject = (JSONObject) obj;
        } catch (IOException | ParseException exception) {
            exception.printStackTrace();
        }

        // Array to store JSON data
        Object[] data = new Object[1];

        // Store JSON data as key/value pairs in a hashMap
        HashMap<Object, String> hashMap = new LinkedHashMap<>();
        if (jsonObject != null) {
            Set jsonObjKeys = jsonObject.keySet();
            for (Object jsonObjKey : jsonObjKeys) {
                hashMap.put(jsonObjKey, (String) jsonObject.get(jsonObjKey));
            }
        } else {
            log.error("Error retrieving JSON data");
            throw new RuntimeException();
        }

        // Store HashMap in an array and return array
        data[0] = hashMap;
        return (Object[][]) data[0];
    }

    @DataProvider
    public Object[][] dataProvider2() {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject;

        // Read JSON file
        Object obj = null;
        try {
            obj = parser.parse(new FileReader("src/main/resources/testData2.json"));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        jsonObject = (JSONObject) obj;

        // Extract array data from JSONObject
        assert jsonObject != null;
        JSONArray formInfo = (JSONArray) jsonObject.get("form info");

        // String array to store JSONArray data
        String[] dataArray = new String[formInfo.size()];

        // JSONObject to read each JSONArray object
        JSONObject formInfoData;
        String inputField, checkbox, radioBtn, dropdown, email, message;

        // Get data from JSONArray and store it in String array
        for (int i = 0; i < formInfo.size(); i++) {
            formInfoData = (JSONObject) formInfo.get(i);
            inputField = (String) formInfoData.get("Input Field");
            checkbox = (String) formInfoData.get("Checkbox");
            radioBtn = (String) formInfoData.get("Radio Button");
            dropdown = (String) formInfoData.get("Dropdown");
            email = (String) formInfoData.get("Email");
            message = (String) formInfoData.get("Message");

            dataArray[i] = inputField + "," + checkbox + "," + radioBtn + "," + dropdown + "," + email + "," + message;
        }
        return new String[][]{dataArray};
    }
}
