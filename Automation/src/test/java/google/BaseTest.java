package google;

import google.utils.CustomTestNGListener;
import google.utils.DriverProvider;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

@Listeners(CustomTestNGListener.class)
public class BaseTest {

    public final Logger LOG = LoggerFactory.getLogger(this.getClass().getCanonicalName());

    @Parameters("browser")
    @BeforeMethod
    public void setUp(@Optional String browser) {
        DriverProvider.setUp(browser);
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

}