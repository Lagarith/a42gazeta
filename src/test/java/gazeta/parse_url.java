package gazeta;

import Helpers.Settings;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.junit.runners.Suite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.*;

@FixMethodOrder (MethodSorters.NAME_ASCENDING)
public class parse_url extends Settings {



    @BeforeClass
    public static void SetUp() throws Exception {
        //SetBrowserFirefox();
        SetBrowserChrome();
    }

    @Test
    public void qwer_test() throws Exception {
        browser.get("http://atwinta.ru/");
        browser.manage().window().maximize();
        Thread.sleep(5000);
        ArrayList links = new ArrayList();
        links = Helpers.parsing("http://atwinta.ru/", "atwinta.ru");

        for ( Object link : links ) {
            browser.get( (String) link );
            Thread.sleep(3000);
            System.out.println( "\n\n\n" + browser.getTitle() );
            Helpers.analyzeLog();

            Date date = new Date();
            Format dateFormat = null;
            System.out.println(dateFormat.format(date));
            Helpers.getFullScreenshot(browser.getTitle() + " --- " + dateFormat.format(date) );
        }
    }

    @Test
    public void homePageServices_test() throws Exception {

    }

    @AfterClass
    public static void SetDown() throws Exception {
        browser.quit();
    }

}
