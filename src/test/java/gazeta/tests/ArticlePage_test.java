package gazeta.tests;

import Helpers.Settings;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.*;

import static Helpers.Locators.*;
import static Helpers.PageElement.*;

import gazeta.pages.ArticlePage_page;



@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ArticlePage_test extends Settings{

    private static String[][] data = new String[30][2];

    @BeforeClass
    public static void setUp() throws Exception {
        SetBrowserFirefox();
        browser.manage().window().setSize(new Dimension(1366, 768));
        data = ArticlePage_page.getLinks();
    }



    @Test
    public void a_Open_Article_Page_test() throws Exception {
        for (String[] item:data) {
            LoadPageAndVerify(item[1]);
        }
    }


    @AfterClass
    public static void setDown() throws Exception {
        browser.quit();
    }
}
