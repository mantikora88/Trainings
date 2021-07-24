package google;

import google.utils.CustomTestNGListener;
import google.utils.DefaultTestDataProvider;
import google.utils.DriverProvider;
import io.qameta.allure.Step;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

@Listeners(CustomTestNGListener.class)
public class BaseTest {

    public final Logger LOG = LoggerFactory.getLogger(this.getClass().getCanonicalName());
    public static final ThreadLocal<DefaultTestDataProvider> tdTest = ThreadLocal.withInitial(DefaultTestDataProvider::new);

    @BeforeMethod
    public void setUp() {
        DriverProvider.setUp();
        DriverProvider.getDriver().manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(ITestResult iTestResult, ITestContext testContext) {
        LOG.info(iTestResult.getMethod().getMethodName());
        DriverProvider.getDriver().quit();
    }

    public static WebDriver getDriver() {
        return DriverProvider.getDriver();
    }

    @Step(value = "Step 1: Open {0} site in browser")
    public void openBrowser(String browser) {
        getDriver().get(browser);
        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        getDriver().manage().window().maximize();
    }

    public JSONObject getTestData(String testDataName) {
        return tdTest.get().getJSONData(this.getClass(), testDataName);
    }

    public JSONObject getTestData() {
        return tdTest.get().getJSONData(this.getClass(), null);
    }
}
