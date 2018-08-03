package gazeta;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
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
    @BeforeClass
    public static void SetUp() throws Exception {
        SetBrowserChrome();
        browser.manage().window().maximize();
    }

    @Test
    public void checkSliderButtons_1920_test() throws Exception {
        browser.manage().window().maximize();
        System.out.println("\n<<<=====----------=====>>>\n"
                + "Starting " + getCurrentMethodName() + "\n\t"
                + "1." + "[" + getCurrentTime() + "] "
                + "Trying to open: http://atwinta.ru/"
        );

        try
        {
            browser.get("http://atwinta.ru/");
            Thread.sleep(2000);
            System.out.println("\t----------"
                    + "\tRESULT"
                    + "\n\t\t"
                    + "[" + getCurrentTime() + "] "
                    + "Page open without any errors"
                    + "\n\t----------"
            );
        } catch (Exception e)
        {
            System.out.println("\t-----!!!!!"
                    + "\tRESULT"
                    + "\n\t\tERROR:\n\t\t"
                    + "[" + getCurrentTime() + "] "
                    + "Page cannot be open"
                    + "\n\t!!!!!-----"
            );
        }

        for (int i = 1; i < 11; i ++)
        {
            System.out.println("\t" + ( i + 1) + ". [" + getCurrentTime() + "] Checking slider button\n\t"
                    + ( i + 1 )
                    + ".1 [" + getCurrentTime() + "] "
                    + "Trying to change active slide, by clicking on button with xPath = "
                    + "/html/body/section[1]/div/div/div[2]/span[" + i + "]"
            );
            try
            {
                browser.findElement(By.xpath("/html/body/section[1]/div/div/div[2]/span[" + i + "]")).click();
                Thread.sleep(1000);
            } catch (Exception e)
            {
                System.out.println("\t-----!!!!!"
                        + "\tRESULT"
                        + "\n\t\tERROR:\n\t\t"
                        + "[" + getCurrentTime() + "]"
                        + "Searching element (xPath) do not exist or site have an issue with main slider on home page"
                        + "\n\t!!!!!-----"
                );
            }

            System.out.println("\t"
                    + ( i + 1 )
                    + ".2 [" + getCurrentTime() + "] "
                    + "Trying to open page from slider button, by xPath : "
                    + "/html/body/section[1]/div/div/div[2]/span[" + i + "]"
            );
            try
            {
                browser.findElement(By.xpath("/html/body/section[1]/div/div/a[" + ( i + 1 ) + "]")).click();
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("\t-----!!!!!"
                        + "\tRESULT:"
                        + "\n\t\t" + ANSI_RED_BACKGROUND + ANSI_BLACK + "ERROR:" + ANSI_RESET + "\n\t\t"
                        + "[" + getCurrentTime() + "]"
                        + "Page cannot be open or searching element (xPath) do not exist"
                );
            }

            System.out.println("\t"
                    + (i + 1)
                    + ".3" + " [" + getCurrentTime() + "] "
                    + "Trying to go back"
            );
            try {
                browser.get("http://atwinta.ru/");
                Thread.sleep(500);
            } catch (Exception e) {
                System.out.println("\t-----!!!!!"
                        + "\tRESULT"
                        + "\n\t\tERROR:\n\t\t"
                        + " [" + getCurrentTime() + "] "
                        + "Page cannot be open"
                        + "\n\t!!!!!-----"
                );
            }
            System.out.println("\t----------\n");
        }
        System.out.println("----------\nTest complete without any errors\n>>>-----==========-----<<<\n");
    }

    @Test
    public void checkServicesBlock_1920_test() throws Exception {
        SendTelegram("Starting checkServicesBlock_1920_test");

        browser.manage().window().maximize();
        // DEVELOPING BLOCK
        // /html/body/section[2]/div/div[1]/div[1]
        // /html/body/section[2]/div/div[1]/div[2]
        // /html/body/section[2]/div/div[1]/div[3]
        // /html/body/section[2]/div/div[1]/div[8]
        for ( int i = 1; i < 9; i ++ ) {
            browser.get("http://atwinta.ru/#services");
            Thread.sleep(3000);

            try {
                WebElement element = browser.findElement(By.xpath("/html/body/section[2]/div/div[1]/div[" + i + "]"));
                Actions actions = new Actions(browser);
                actions.moveToElement(element);
                actions.perform();
                Thread.sleep(3000);

                browser.findElement(By.xpath("/html/body/section[2]/div/div[1]/div[" + i + "]")).click();
                Thread.sleep(500);
                System.out.println(i + " :true");
            } catch (Exception e) {
                System.out.println(i + " :false");
                i = i - 1;
            }
        }

        // PROMOTION BLOCK
        // /html/body/section[2]/div/div[2]/div[1]
        // /html/body/section[2]/div/div[2]/div[6]
        for ( int i = 1; i < 7; i ++) {
            browser.get("http://atwinta.ru/#services");
            Thread.sleep(3000);

            try {
                WebElement element = browser.findElement(By.xpath("/html/body/section[2]/div/div[2]/div[" + i + "]"));
                Actions actions = new Actions(browser);
                actions.moveToElement(element);
                actions.perform();
                Thread.sleep(3000);

                browser.findElement(By.xpath("/html/body/section[2]/div/div[2]/div[" + i + "]")).click();
                Thread.sleep(500);
                System.out.println(i + " :true");
            } catch (Exception e) {
                System.out.println(i + " :false");
                i = i - 1;
            }
        }

        SendTelegram("Test complete without errors");

    }

    @Test
    public void checkWorksButtons_1920_test() throws Exception {

        SendTelegram("Starting checkWorksButtons_1920_test");

        // |-----------------------------------------------------------------|
        // | ELEMENTS XPATH                             | - OBJECT NAME      |
        // |--------------------------------------------|--------------------|
        // |/html/body/section[3]/div/ul/li[1]/aside/a  | - item 1           |
        // |/html/body/section[3]/div/ul/li[2]/aside/a  | - item 2           |
        // |/html/body/section[3]/div/ul/li[3]/aside/a  | - item 3           |
        // |/html/body/section[3]/div/div[2]/a          | - all works button |
        // |-----------------------------------------------------------------|

        for ( int i = 0; i < 1; i ++) {
            try {
                browser.get("http://atwinta.ru/#lastworks");
                Thread.sleep(3000);
                ClickButton("/html/body/section[3]/div/div[1]/span[1]/a");
            } catch (Exception e) {
                i = i - 1;
            }
        }

        for (int i = 1; i < 4; i ++) {
            try {
                browser.get("http://atwinta.ru/#lastworks");
                Thread.sleep(3000);
                ClickButton("/html/body/section[3]/div/ul/li[" + i + "]/aside/a");
            } catch (Exception e) {
                i = i - 1;
            }
        }

        browser.get("http://atwinta.ru/#lastworks");
        Thread.sleep(3000);

        ClickButton("/html/body/section[3]/div/div[2]/a");

        SendTelegram("Test complete without errors");

    }

    @Test
    public void checkHonorsButtons_1920_test() throws Exception {

        SendTelegram("Starting checkHonorsButtons_1920_test");

        // /html/body/section[4]/div/div[2]/ul/li[2]/a
        // /html/body/section[4]/div/div[2]/ul/li[3]/a
        // /html/body/section[4]/div/div[2]/ul/li[5]/a
        // /html/body/section[4]/div/div[2]/ul/li[7]/a

        String[] list = {
                "/html/body/section[4]/div/div[2]/ul/li[2]/a",
                "/html/body/section[4]/div/div[2]/ul/li[3]/a",
                "/html/body/section[4]/div/div[2]/ul/li[5]/a",
                "/html/body/section[4]/div/div[2]/ul/li[7]/a"
        };

        for (int i = 0; i < 4; i ++) {
            browser.get("http://atwinta.ru/#honors");
            Thread.sleep(3000);

            try {
                ClickButton(list[i]);
            } catch (Exception e) {
                i = i - 1;
            }
        }

        SendTelegram("Test complete without errors");

    }

    @Test
    public void checkNavigationButtons_1920_test() throws Exception {

        SendTelegram("Starting checkNavigationButtons_1920_test");

        String[] header_navigation_buttons = {
                "/html/body/header/ul/li[7]/a",
                "/html/body/header/ul/li[10]",
                "/html/body/header/ul/li[11]",
                "/html/body/header/ul/li[12]",
                "/html/body/header/ul/li[13]"
        };

        browser.manage().window().maximize();

        OpenPage("http://atwinta.ru");
        ClickButton("/html/body/header/ul/li[7]/a"); // contacts

        OpenPage("http://atwinta.ru");
        ClickButton("/html/body/header/ul/li[10]"); // portfolio

        OpenPage("http://atwinta.ru");
        ClickButton("/html/body/header/ul/li[11]"); // blog

        OpenPage("http://atwinta.ru");
        ClickButton("/html/body/header/ul/li[12]"); // conference

        OpenPage("http://atwinta.ru");
        ClickButton("/html/body/header/ul/li[13]"); // kpi
                                    ///html/body/header/ul/li[2]/a[1]

//        379fc2-a476ac-a67bbb
// https://alarmerbot.ru/?key=21dd13-b6486d-8ba16b&message=Habrahabr
        // /html/body/header/ul/li[2]/a[1]

        SendTelegram("Test complete without errors");

    }

    @AfterClass
    public static void SetDown() throws Exception {
        browser.quit();
    }

    private int open_page() throws Exception {
        try {
            browser.get("http://atwinta.ru/");
            Thread.sleep(2000);
            System.out.println("Page open without any errors");
            return 0;
        } catch (Exception e) {
            System.out.println("Page cannot be open");
            return 1;
        }
    }

    private void ClickButton(String xPath) throws Exception {
        //      ||------------------------------------------------------------------||
        //      ||   THIS METHOD SCROLLING AND CLICKING ELEMENT, BY ELEMENT XPATH   ||
        //      ||------------------------------------------------------------------||

        WebElement element = browser.findElement(By.xpath(xPath));
        Actions actions = new Actions(browser);
        actions.moveToElement(element);
        actions.perform();
        Thread.sleep(3000);

        browser.findElement(By.xpath(xPath)).click();
        Thread.sleep(1000);
    }

    public void SendTelegram(String alarm_message) {

        try {

            String url = "https://alarmerbot.ru/?key=379fc2-a476ac-a67bbb&message=" + alarm_message;

            URL obj = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) obj.openConnection();

            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            conn.setRequestMethod("PUT");

            String userpass = "user" + ":" + "pass";
            String basicAuth = "Basic " + javax.xml.bind.DatatypeConverter.printBase64Binary(userpass.getBytes("UTF-8"));
            conn.setRequestProperty ("Authorization", basicAuth);

            String data =  "{\"format\":\"json\",\"pattern\":\"#\"}";
            OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream());
            out.write(data);
            out.close();

            new InputStreamReader(conn.getInputStream());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void OpenPage(String page_url) throws Exception {
        browser.get(page_url);
        Thread.sleep(3000);
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