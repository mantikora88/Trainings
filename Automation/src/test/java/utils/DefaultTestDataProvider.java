package utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.Yaml;

import javax.annotation.Nullable;
import java.io.*;
import java.util.Map;
import java.util.Objects;

public class DefaultTestDataProvider implements TestDataProvider {

    Logger LOG = LoggerFactory.getLogger("TestData");
    private static final String RESOURCES = "src/test/resources/";

    @Override
    public JSONObject readFile(Class<?> testClass) {
        JSONParser parser = new JSONParser();
        JSONObject jsonFile = null;
        try {
            jsonFile = (JSONObject) parser.parse(
                    new FileReader(RESOURCES + testClass.getName().replaceAll("\\.", "\\/") + ".json"));
        } catch (IOException e) {
            LOG.error("Test data file is not accessible");
            throw new RuntimeException(e);
        } catch (ParseException e) {
            LOG.error("Error parsing test data, please check data correctness");
            throw new RuntimeException(e);
        }
        return jsonFile;
    }

    public Map<String, Object> readYamlFile(Class<?> testClass) {
        Yaml parser = new Yaml();
        InputStream inputStream = this.getClass().getClassLoader().
                getResourceAsStream(RESOURCES + testClass.getName().replaceAll("\\.", "\\/") + ".yaml");
        Map<String, Object> file = parser.load(inputStream);
        return file;
    }

    @Override
    public JSONObject getJSONData(Class<?> testClass, @Nullable String testDataName) {
        JSONObject jsonFile = readFile(testClass);
        if (Objects.isNull(testDataName)) {
            return jsonFile;
        } else {
            return (JSONObject) jsonFile.get(testDataName);
        }
    }
}
