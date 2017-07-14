package gazeta.tests; /** gazeta.tests.AuthorsPage_test */
import Helpers.Settings;
import gazeta.components.PageElement;
import gazeta.pages.ArticleList_page;
import gazeta.pages.AuthorsPage_page;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.*;

import static Helpers.Locators.*;
import static gazeta.components.PageElement.*;



@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AuthorsPage_test extends Settings{

    private static String[][] data = new String[22][2];


    @BeforeClass
    public static void setUp() throws Exception {
        SetBrowserFirefox();
        browser.manage().window().setSize(new Dimension(1366, 768));
        data = AuthorsPage_page.getLinks();
    }



    @Test
    public void a_Open_Authors_Page_test() throws Exception {
        for (String[] item:data) {
            LoadPageAndVerify(item[1]);
        }
    }


    @AfterClass
    public static void setDown() throws Exception {
        browser.quit();
    }
}

