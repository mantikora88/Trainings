package google;

import google.metadata.Sites;
import io.qameta.allure.*;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import google.utils.SearchRequestsDataProvider;

import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

@Test(singleThreaded = true)
public class TestOne extends BaseTest {

    @Epic("Story-1")
    @Feature("BCMM-1 Testing google search")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Just simple test to check google search")
    @Test
    @Parameters("searchText")
    public void test(@Optional String searchText) {
        openBrowser(Sites.GOOGLE);
        searchText(searchText);
        LOG.info("Search text parameter value = " + searchText + " in thread = " + Thread.currentThread().getName() + Thread.currentThread().getId());
        Assertions.assertThat(false).as("testing error").isTrue();
    }

    @Step("Step 1: Open browser")
    private void openBrowser(String browser) {
        getDriver().get(browser);
        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        getDriver().manage().window().maximize();
    }

    @Step("Step 2: Perform Search")
    private void searchText(String searchText) {
        getDriver().findElement(By.xpath("//*[@title='Пошук']")).sendKeys(Objects.isNull(searchText) ? "Test parameter" : searchText);
        getDriver().findElement(By.xpath("//*[@title='Пошук']")).sendKeys(Keys.ENTER);
    }

    @Epic("Story-1")
    @Feature("Testing google search with data provider")
    @Severity(SeverityLevel.MINOR)
    @Description("Just simple test to check google search using data provider")
    @Test(enabled = false, dataProvider = "googleSearchRequestsProvider", dataProviderClass = SearchRequestsDataProvider.class)
    @Parameters("searchText")
    public void googleSearchWithTestDataProvider(String searchText1, String searchText2, String searchText3) {
        getDriver().get("http://google.com");
        String searchString = Stream.of(searchText1, searchText2, searchText3).reduce((combine, options) -> combine + options).orElse("No search value");
        getDriver().findElement(By.xpath("//*[@title='Пошук']")).sendKeys(searchString);
        getDriver().findElement(By.xpath("//*[@title='Пошук']")).sendKeys(Keys.ENTER);
        System.out.println("Parameter value = " + searchString + " Thread = " + Thread.currentThread().getName() + Thread.currentThread().getId());
    }
}
