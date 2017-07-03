import Helpers.PageElement;
import Helpers.Settings;
import Helpers.Locators.*;
import com.galenframework.config.GalenConfig;
import com.galenframework.config.GalenProperty;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sun.deploy.ref.Helpers;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.*;
import org.openqa.selenium.internal.WrapsDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;

import java.io.File;
import java.io.FileWriter;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import static Helpers.Locators.*;
import static Helpers.PageElement.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HomePage_test extends Settings {

    protected static String testSuite_1 = "LoginPage . ";


    @BeforeClass
    public static void setUp() throws Exception {
        System.setProperty("galen.config", "C:\\tests\\a42gazeta\\galen.config");
        GalenConfig.getConfig().setProperty(GalenProperty.SCREENSHOT_FULLPAGE, "true");
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
    public void testImageShown(){
        browser.get("http://gazeta.a42.ru/lenta/news/");

        IsImageDisplayed(NewsList_main_news_Image);
        
    }



    @AfterClass
    public static void setDown() throws Exception {
        browser.quit();
    }

}