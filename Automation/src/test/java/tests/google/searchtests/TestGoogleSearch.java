package tests.google.searchtests;

import tests.UIBaseTest;
import metadata.Sites;
import io.qameta.allure.*;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.SearchRequestsDataProvider;

import java.util.Objects;
import java.util.stream.Stream;

@Test(singleThreaded = true)
public class TestGoogleSearch extends UIBaseTest {

    @Epic("Story-1")
    @Feature("BCMM-1 Testing tests.google search")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Just simple test to check tests.google search")
    @Test
    @Parameters("searchText")
    public void googleSearch(@Optional String searchText) {
        openBrowser(Sites.GOOGLE);
        searchText(searchText);
        LOG.info("Search text parameter value = " + searchText + " in thread = " + Thread.currentThread().getName() + Thread.currentThread().getId());
        Assertions.assertThat(false).as("testing error").isTrue();
    }

    @Step(value = "Step 2: Perform Search with value = {0}")
    private void searchText(String searchText) {
        getDriver().findElement(By.xpath("//*[@title='Пошук']")).sendKeys(Objects.isNull(searchText) ? "Test parameter" : searchText);
        getDriver().findElement(By.xpath("//*[@title='Пошук']")).sendKeys(Keys.ENTER);
    }

    @Epic("Story-1")
    @Feature("Testing tests.google search with data provider")
    @Severity(SeverityLevel.MINOR)
    @Description("Just simple test to check tests.google search using data provider")
    @Test(enabled = false, dataProvider = "googleSearchRequestsProvider", dataProviderClass = SearchRequestsDataProvider.class)
    @Parameters("searchText")
    public void googleSearchWithTestDataProvider(String searchText1, String searchText2, String searchText3) {
        openBrowser(Sites.GOOGLE);
        String searchString = Stream.of(searchText1, searchText2, searchText3).reduce((combine, options) -> combine + options).orElse("No search value");
        searchText(searchString);
        System.out.println("Parameter value = " + searchString + " Thread = " + Thread.currentThread().getName() + Thread.currentThread().getId());
    }
}
