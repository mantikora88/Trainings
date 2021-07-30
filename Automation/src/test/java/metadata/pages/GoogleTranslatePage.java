package metadata.pages;

import metadata.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverProvider;

import java.util.List;

public class GoogleTranslatePage extends BasePage {

    WebDriver driver;

    @FindBy(xpath = "//div[@jsname='gnoFo']//button[@jsname='RCbdJd']")
    private WebElement languageSelectorOpener;

    @FindBy(xpath = "(//div[@jsname='rPx1uf']/div)[1]/following-sibling::div/div[last()]")
    private List<WebElement> languagesList;
    private By languagesListPath = By.xpath("(//div[@jsname='rPx1uf']/div)[1]/following-sibling::div/div[last()]");

    public GoogleTranslatePage() {
        this.driver = DriverProvider.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void selectLanguage(String language) {
        languageSelectorOpener.click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("input[aria-label='Шукати мови']"))));
        List<WebElement> languages = driver.findElements(languagesListPath);
        WebElement resultingLanguage = languages.stream().filter(element -> element.getText().equals(language)).findFirst().get();
        String js = "arguments[0].setAttribute('color',''red')";
        ((JavascriptExecutor) driver).executeScript(js, resultingLanguage);
        resultingLanguage.click();
    }

}
