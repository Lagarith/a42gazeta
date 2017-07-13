package gazeta.tests; /** gazeta.tests.AuthorsList_test */

import Helpers.Settings;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.*;

import static Helpers.Locators.*;
import static gazeta.components.PageElement.*;



@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AuthorsList_test extends Settings {

    @BeforeClass
    public static void setUp() throws Exception {
        SetBrowserFirefox();
        browser.manage().window().setSize(new Dimension(1366, 768));
    }



    @Test
    public void a_NewsList_load_test() throws Exception {
        LoadPageAndVerify(AuthorsListURL);
    }



    @AfterClass
    public static void setDown() throws Exception {
        browser.quit();
    }
}

