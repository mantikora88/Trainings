package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Objects;

public class DriverProvider {

    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static synchronized WebDriver getDriver() {
        if (Objects.isNull(driver)) {
            setUpBrowser();
        }
        return driver.get();
    }

    public static synchronized void setUpBrowser() {
        String browser = System.getenv("Browser");
        if (Objects.isNull(browser)) {
            PropertiesProvider.getProperty(PropertiesProvider.getProperty(PropertiesProvider.GlobalProperties.BROWSER.get()));
        }
        if (Objects.isNull(browser) || browser.equals("Chrome")) {
            System.setProperty("webdriver.chrome.driver", PropertiesProvider.getProperty(PropertiesProvider.GlobalProperties.CHROME_DRIVER.get()));
            ChromeOptions chromeOptions = new ChromeOptions().setHeadless(false);
            driver.set(new ChromeDriver(chromeOptions));
        } else throw new RuntimeException("Only Chrome browser supported at the moment.");
    }
}
