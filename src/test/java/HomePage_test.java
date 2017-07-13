import Helpers.Settings;
import com.galenframework.config.GalenConfig;
import com.galenframework.config.GalenProperty;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.*;

import static Helpers.Locators.*;
import static Helpers.PageElement.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HomePage_test extends Settings {



    @BeforeClass
    public static void setUp() throws Exception {
        SetBrowserFirefox();
        browser.manage().window().setSize(new Dimension(1366, 768));
    }



    @Test
    public void a_NewsList_load_test() throws Exception {
        LoadPageAndVerify(NewsListURL);
    }



    @Test
    public void b_NewsList_HtmlCheck_test() throws Exception {
        LoadPage(NewsListURL);
        Check(NewsList_gspec);
    }



    @Test
    public void c_testImageDisplayed_test() throws Exception {
        boolean error_status = true;
        ExtentReports extent = NewReport();
        ExtentTest extentTest = extent.startTest("c_testImageDisplayed_test", "Test for all images is loaded");

        LoadPage(NewsListURL);
        if (browser.findElement(By.xpath(NewsList_main_news_Image)).isDisplayed()) {
            extentTest.log(LogStatus.INFO, "Image is load", "image xpath: " + NewsList_main_news_Image);
        } else {
            extentTest.log(LogStatus.INFO, "<b>Image is not load</b>", "image xpath: " + NewsList_main_news_Image);
            error_status = false;
        }

        for (int i = 1; i < 13; i++) {
            if (browser.findElement(By.xpath("//*[@id=\"paginate-block\"]/div/div[" + i + "]/p[1]/a/span/img")).isDisplayed()) {
                extentTest.log(LogStatus.INFO, "Image is load", "image xpath: " + "//*[@id=\"paginate-block\"]/div/div[" + i + "]/p[1]/a/span/img");
            } else {
                extentTest.log(LogStatus.INFO, "<b>Image is not load</b>", "image xpath: " + "//*[@id=\"paginate-block\"]/div/div[" + i + "]/p[1]/a/span/img");
                error_status = false;
            }
        }

        if (error_status) extentTest.log(LogStatus.PASS, "All images will load, without errors");
            else extentTest.log(LogStatus.FAIL, "<b>Some images is not load</b>");

        extent.endTest(extentTest);
        extent.flush();
    }



    @AfterClass
    public static void setDown() throws Exception {
        browser.quit();
    }

}