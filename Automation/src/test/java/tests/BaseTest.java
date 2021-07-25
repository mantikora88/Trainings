package tests;

import utils.CustomTestNGListener;
import utils.DefaultTestDataProvider;
import utils.DriverProvider;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;


@Listeners(CustomTestNGListener.class)
public class BaseTest {

    public final Logger LOG = LoggerFactory.getLogger(this.getClass().getCanonicalName());
    public static final ThreadLocal<DefaultTestDataProvider> tdTest = ThreadLocal.withInitial(DefaultTestDataProvider::new);

    public static WebDriver getDriver() {
        return DriverProvider.getDriver();
    }

    public JSONObject getTestData(String testDataName) {
        return tdTest.get().getJSONData(this.getClass(), testDataName);
    }

    public JSONObject getTestData() {
        return tdTest.get().getJSONData(this.getClass(), null);
    }
}
