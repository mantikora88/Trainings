package utils;

import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesProvider {

    public static String getProperty(String propertyName) {
        String propertyValue = null;
        Properties property = new Properties();
        //try with resources
        try (FileInputStream inputStream = new FileInputStream("src/test/resources/global.properties")) {
            property.load(inputStream);
            propertyValue = property.getProperty(propertyName);
        } catch (IOException e) {
            LoggerFactory.getLogger("PropertyProvider").info("Property file not found. Property defaulted to empty.");
            propertyValue = "";
        }
        return propertyValue;
    }

    public enum GlobalProperties {
        BROWSER("test.browser"),
        CHROME_DRIVER("chrome.driver.path");

        private String property;

        GlobalProperties(String property) {
            this.property = property;
        }

        public String get() {
            return property;
        }
    }
}
