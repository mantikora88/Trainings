package utils;

import org.json.simple.JSONObject;

public interface TestDataProvider {

    JSONObject readFile(Class<?> testClass);
    JSONObject getJSONData(Class<?> testClass, String testDataName);
}
