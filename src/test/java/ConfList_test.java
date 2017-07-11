/** ConfList_test */

import Helpers.Settings;
import com.galenframework.config.GalenConfig;
import com.galenframework.config.GalenProperty;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.*;

import static Helpers.Locators.*;
import static Helpers.PageElement.*;



@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ConfList_test extends Settings {

    @BeforeClass
    public static void setUp() throws Exception {
        System.setProperty("galen.config", "C:\\tests\\a42gazeta\\galen.config");
        GalenConfig.getConfig().setProperty(GalenProperty.SCREENSHOT_FULLPAGE, "true");
        SetBrowserFirefox();
        browser.manage().window().setSize(new Dimension(1366, 768));
    }



    @Test
    public void a_NewsList_load_test() throws Exception {
        LoadPageAndVerify(ConfListURL);
    }



    @AfterClass
    public static void setDown() throws Exception {
        browser.quit();
    }
}

