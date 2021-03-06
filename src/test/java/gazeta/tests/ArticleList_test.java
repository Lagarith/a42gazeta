package gazeta.tests;

import Helpers.Settings;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.Dimension;

import static Helpers.Locators.ArticleListURL;
import static gazeta.components.PageElement.LoadPageAndVerify;



@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ArticleList_test extends Settings {

    @BeforeClass
    public static void setUp() throws Exception {
        SetBrowserFirefox();
        browser.manage().window().setSize(new Dimension(1366, 768));
    }



    @Test
    public void a_NewsList_load_test() throws Exception {
        LoadPageAndVerify(ArticleListURL);
    }



    @AfterClass
    public static void setDown() throws Exception {
        browser.quit();
    }
}
