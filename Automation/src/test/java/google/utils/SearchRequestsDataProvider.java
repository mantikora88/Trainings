package google.utils;

import org.testng.annotations.DataProvider;

public class SearchRequestsDataProvider {

    @DataProvider(name = "googleSearchRequestsProvider")
    public Object[][] googleSearchRequestsProvider() {
        //we have 4 rows with 3 values in each, every row is 1 tests execution.
        return new Object[][]{{"Row", "Number", "One"}, {"Row", "Number", "Two"}, {"Row", "Number", "Three"}, {"Row", "Number", "Four"}};
    }
}
