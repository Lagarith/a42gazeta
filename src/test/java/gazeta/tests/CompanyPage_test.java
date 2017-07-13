package gazeta.tests; /** gazeta.tests.CompanyPage_test */
import Helpers.Settings;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.*;

import static Helpers.Locators.*;
import static Helpers.PageElement.*;



@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CompanyPage_test extends Settings{

    private static String[][] data = new String[30][2];

    private static String[][] getLinks() throws Exception {
        browser.get(CompanyListURL);

        Click(NewsList_ShowMore_btn);
        Click(NewsList_ShowMore_btn);

        for (int i = 0; i < 30; i++) {
            data[i][0] = browser.findElement(By.xpath("//*[@id=\"paginate-block\"]/div/div[" + (i+1) + "]/p[1]/a/strong")).getText();
            data[i][1] = browser.findElement(By.xpath("//*[@id=\"paginate-block\"]/div/div[" + (i+1) + "]/p[1]/a")).getAttribute("href");
        }

        return data;
    }

    @BeforeClass
    public static void setUp() throws Exception {
        SetBrowserFirefox();
        browser.manage().window().setSize(new Dimension(1366, 768));
        data = getLinks();
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


