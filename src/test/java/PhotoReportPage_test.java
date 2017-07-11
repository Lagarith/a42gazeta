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

@FixMethodOrder (MethodSorters.NAME_ASCENDING)
public class PhotoReportPage_test extends Settings {

    private static String[][] data = new String[15][2];

    private static String[][] getLinks() throws Exception {
        browser.get(PhotoListURL);

        Click(PhotoList_ShowMore_btn);
        Pause(1000);
        Click(PhotoList_ShowMore_btn);
        Pause(1000);

        for (int i = 0; i < 15; i++) {
            String xPath = "//*[@id=\"paginate-block\"]/div/div[" + i + "]/p[1]/a/strong";
            String xPath2 = "//*[@id=\"paginate-block\"]/div/div[" + i + "]/p[1]/a";

            data[i][0] = browser.findElement(By.xpath("//*[@id=\"paginate-block\"]/div/div[" + (i+1) + "]/a/div/div/span")).getText();
            data[i][1] = browser.findElement(By.xpath("//*[@id=\"paginate-block\"]/div/div[" + (i+1) + "]/a")).getAttribute("href");
                                                       //*[@id="paginate-block"]/div/div[1]/a
        }

        return data;
    }

    @BeforeClass
    public static void setUp() throws Exception {
        System.setProperty("galen.config", "C:\\tests\\a42gazeta\\galen.config");
        GalenConfig.getConfig().setProperty(GalenProperty.SCREENSHOT_FULLPAGE, "true");
        SetBrowserFirefox();
        browser.manage().window().setSize(new Dimension(1366, 768));
        data = getLinks();
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
