package gazeta;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.*;
import org.junit.runners.MethodSorters;
import Helpers.Settings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

@FixMethodOrder (MethodSorters.NAME_ASCENDING)
public class HomePage_test extends Settings
{
    private static final ExtentReports extent = new ExtentReports(System.getProperty("user.dir") + "\\extentReportFile.html", false);
    private boolean suite_status = true;
    private static final String siteUrl = "";

    @BeforeClass
    public static void SetUp() throws Exception {
        SetBrowserChrome();
        browser.manage().window().maximize();
    }

    @Test
    public void openHomePage_test()
    {
        ExtentTest extentTest = extent.startTest("1. Open home page.",
                "Verify website availability.");
        extentTest.log(LogStatus.INFO, "1. Navigated to http://smart_logistic.k.atwinta.ru/");

        try {
            browser.get("http://smart_logistic.k.atwinta.ru/");
            Thread.sleep(2000);
            extentTest.log(LogStatus.PASS, "RESULT:\n\tWebsite is available");
            extent.endTest(extentTest);
            extent.flush();
        } catch (Exception e) {
            suite_status = false;
            extentTest.log(LogStatus.ERROR, "[" + getCurrentTime() + "] " + "Page cannot be opened. All tests are canceled.");
            extentTest.log(LogStatus.FAIL, "Website home page cannot be opened.");
            extent.endTest(extentTest);
            extent.flush();
        }
    }

    @Test
    public void auth_test()
    {
        if (suite_status)
        {
            ExtentTest extentTest = extent.startTest("2. Registration",
                    "Verify website availability.");
            extentTest.log(LogStatus.INFO, "1. Navigated to http://smart_logistic.k.atwinta.ru/");
        }
    }

    @AfterClass
    public static void SetDown(){
        browser.quit();
    }

    private String getCurrentTime()
    {
        String current_time = new SimpleDateFormat("yyyy.MM.dd__HH:mm:ss").format(Calendar.getInstance().getTime());
        return current_time;
    }

    private String getCurrentMethodName()
    {
        String method_name = new Object(){}.getClass().getEnclosingMethod().getName();
        return method_name;
    }

    private static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLACK = "\u001B[30m";
}