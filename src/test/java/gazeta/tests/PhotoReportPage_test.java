package gazeta.tests;

import Helpers.Settings;
import gazeta.pages.PhotoReportPage_page;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.*;

import static Helpers.Locators.*;
import static gazeta.components.PageElement.*;

@FixMethodOrder (MethodSorters.NAME_ASCENDING)
public class PhotoReportPage_test extends Settings {

    private static String[][] data = new String[15][2];

    @BeforeClass
    public static void setUp() throws Exception {
        SetBrowserFirefox();
        browser.manage().window().setSize(new Dimension(1366, 768));
        data = PhotoReportPage_page.getLinks();
    }



    @Test
    public void a_Open_Photo_Report_Page_test() throws Exception {
        for (String[] item:data) {
            LoadPageAndVerify(item[1]);
            System.out.println(item[1]);
        }
    }



    @AfterClass
    public static void setDown() throws Exception {
        browser.quit();
    }

}