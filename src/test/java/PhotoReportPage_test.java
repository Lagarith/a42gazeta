import Helpers.PageElement;
import Helpers.Settings;
import Helpers.Locators.*;
import com.galenframework.config.GalenConfig;
import com.galenframework.config.GalenProperty;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sun.deploy.ref.Helpers;
import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.*;
import org.openqa.selenium.internal.WrapsDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.shooting.RotatingDecorator;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import ru.yandex.qatools.ashot.shooting.ShootingStrategy;
import ru.yandex.qatools.ashot.shooting.ViewportPastingDecorator;
import ru.yandex.qatools.ashot.shooting.cutter.CutStrategy;
import ru.yandex.qatools.ashot.shooting.cutter.VariableCutStrategy;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.imageio.ImageIO;
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

import static Helpers.PageElement.LoadPageAndVerify;

@FixMethodOrder (MethodSorters.NAME_ASCENDING)
public class PhotoReportPage_test extends Settings {

    private static String[][] data = new String[31][2];

    private static String[][] getLinks() throws Exception {
        browser.get(PhotoListURL);

        Click(PhotoList_ShowMore_btn);
        Click(PhotoList_ShowMore_btn);

        for (int i = 1; i < 16; i++) {
            String xPath = "//*[@id=\"paginate-block\"]/div/div[" + i + "]/p[1]/a/strong";
            String xPath2 = "//*[@id=\"paginate-block\"]/div/div[" + i + "]/p[1]/a";

            data[i][0] = browser.findElement(By.xpath("//*[@id=\"paginate-block\"]/div/div[" + i + "]/a/div/div/span")).getText();
            data[i][1] = browser.findElement(By.xpath("//*[@id=\"paginate-block\"]/div/div[" + i + "]/a")).getAttribute("href");
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
//            LoadPageAndVerify(item[1]);
            System.out.println(item[1]);
        }
    }



    @AfterClass
    public static void setDown() throws Exception {
        browser.quit();
    }

}
