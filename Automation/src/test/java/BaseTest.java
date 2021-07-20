import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class BaseTest {

    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public final Logger LOG = LoggerFactory.getLogger(this.getClass().getCanonicalName());

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "E:/Trainings/chromedriver/chromedriver2.exe");
        driver.set(new ChromeDriver(new ChromeOptions().setHeadless(true)));
    }

    @AfterMethod
    public void tearDown(ITestResult iTestResult, ITestContext testContext) {
        LOG.info(iTestResult.getMethod().getMethodName());
        getDriver().quit();
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

}
