package metadata;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverProvider;

public class BasePage {

    protected WebDriverWait wait = new WebDriverWait(DriverProvider.getDriver(), 30);
}
