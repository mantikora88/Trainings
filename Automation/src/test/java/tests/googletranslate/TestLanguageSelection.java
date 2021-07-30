package tests.googletranslate;

import metadata.Sites;
import metadata.pages.GoogleTranslatePage;
import org.testng.annotations.Test;
import tests.UIBaseTest;

public class TestLanguageSelection extends UIBaseTest {

    GoogleTranslatePage googleTranslatePage = new GoogleTranslatePage();

    @Test
    public void testLanguageSelectionMu() {
        openBrowser(Sites.GOOGLE_TRANSLATE);
        googleTranslatePage.selectLanguage("зулу");
    }
}
