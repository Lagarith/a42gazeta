package gazeta.components;

import Helpers.Settings;
import com.galenframework.api.Galen;
import com.galenframework.reports.GalenTestInfo;
import com.galenframework.reports.HtmlReportBuilder;
import com.galenframework.reports.model.LayoutReport;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.internal.WrapsDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import static Helpers.Locators.extentReportFile;
import static Helpers.Locators.title_x_margin_from_top;
import static Helpers.Settings.browser;

public class PageElement extends Settings {

    public static boolean ContentText(String element_xpath) {
        boolean error_status = false;
        try {
            browser.findElement(By.xpath(element_xpath)).isDisplayed();
        } catch (Exception e) {
            error_status = true;
        }

        return error_status;
    }



    private static String getMethodName(){
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        String methodName = stackTraceElements[3].getMethodName();

        return methodName;
    }


    public static boolean MaterialDateAdd(String element_) {
        boolean error_status = false;
        return error_status;
    }



    public static boolean MaterialTags(String element_) {
        boolean error_status = false;
        return error_status;
    }



    public static boolean MaterialElementPosition(String element_) {
        boolean error_status = false;

        int x_position = browser.findElement(By.cssSelector(element_)).getSize().getWidth();
        int y_position = browser.findElement(By.cssSelector(element_)).getSize().getHeight();

        if (x_position == title_x_margin_from_top) {
            System.out.println("Normal");
        } else {
            error_status = true;
        }

        return error_status;
    }



    public static boolean JSPageErrors() {
        boolean error_status = false;

        //String jsErrors = browser.manage().logs().get(LogType.BROWSER).toString();

/*        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logEntries) {
            System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
            //do something useful with the data
        }*/

        LogEntries logEntries = browser.manage().logs().get(LogType.BROWSER);

        for (LogEntry logEntry : logEntries) {
            System.out.println(new Date(logEntry.getTimestamp() + " " + logEntry.getLevel() + " " + logEntry.getMessage()));
        }

        //System.out.println(jsErrors);


        return error_status;
    }



    public static boolean IsDisplayed(String elementXpath) {
        boolean error_status = false;

        try {
            browser.findElement(By.xpath(elementXpath)).isDisplayed();
        } catch (Exception e) {
            System.out.println("Cannot find element");
            error_status = true;
        }

        return error_status;
    }



    public static boolean SendKeys(String elementXpath, String message) {
        boolean error_status = false;

        System.out.println("Searching is element exist");

        if ( IsDisplayed(elementXpath) ) {
            System.out.println("Element exist. Trying to send keys: " + message);
            try {
                browser.findElement(By.xpath(elementXpath)).sendKeys(message);
            } catch (Exception e) {
                System.out.println("Something went wrong. Cannot send keys to element:" + elementXpath);
                e.printStackTrace();
            }
        } else {
            System.out.println("Cannot find element by xPath: " + elementXpath);
        }

        return error_status;
    }



    public static boolean Click (String elementXpath, String expected) {
        boolean error_status = false;

        browser.findElement(By.xpath(elementXpath)).click();

        Pause(1000);

        return error_status;
    }

    public static void Click (String elementXpath) {
        Click(elementXpath, "/html/body");
    }



    public static boolean GetAttribute (String elementXpath, String elementAttribute) {
        boolean error_status = false;

        if (IsDisplayed(elementXpath)) browser.findElement(By.xpath(elementXpath)).getAttribute("" + elementAttribute + "");

        return error_status;
    }



    public static boolean CreateReport (String filePath) {
        boolean error_status = false;

        String extentReportFile = System.getProperty("user.dir")
                + "\\extentReportFile.html";
        String extentReportImage = System.getProperty("user.dir")
                + "\\extentReportImage.png";

        return error_status;
    }



    public static List<WebElement> GetAllLinks() {
        java.util.List<WebElement> links = browser.findElements(By.tagName("a"));

        System.out.println(links.size());

        for (int i = 1; i<=links.size(); i=i+1)

        {
            System.out.println(links.get(i).getText());
        }

        return links;
    }



    public static void Pause(long waitingTime) {
        System.out.println("Pause (" + waitingTime + " ms)");

        try {
            Thread.sleep(waitingTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    public static ExtentReports NewReport() {
        ExtentReports extent = new ExtentReports(extentReportFile, false);
        return extent;
    }



    public static ExtentTest PageLoadTime(ExtentTest extentTest, long totalTime) {
        if (totalTime/1000 > 10) {
            System.out.println("Warning! Page load time, is too long");
            extentTest.log(LogStatus.WARNING, "Page loading is critical.", "Load time: " + totalTime/1000 + "sec");
        } else extentTest.log(LogStatus.INFO, "Load time = " + totalTime/1000 + "sec");

        return extentTest;
    }



    public static boolean LoadPageAndVerify(String pageURL) {

        String testSuiteName = getMethodName();

        System.out.println(testSuiteName + ". ");
        ExtentReports extent = NewReport();
        ExtentTest extentTest = extent.startTest(testSuiteName + " - Open: " + pageURL, "Trying to open page, by url - <a>" + pageURL + "</a>");

        boolean error_status = true;
        long start = 0;

        System.out.println("Trying to open - " + pageURL);
        extentTest.log(LogStatus.INFO, "Trying to open - <a>" + pageURL + "</a>");
        try {
            start = System.currentTimeMillis(); // Start timer.
            browser.get(pageURL);
        } catch (Exception e) {
            e.printStackTrace();
            error_status = false;
            System.out.println("Page cannot be opened.");
            extentTest.log(LogStatus.FAIL, "Page cannot be opened.\n\nStackTrace:\n");
        }

        long finish = System.currentTimeMillis(); // Stop timer.
        long totalTime = finish - start;

        extentTest = PageLoadTime(extentTest, totalTime);

        Pause(1000);

        System.out.println("Total Time for page load - " + totalTime/1000 + " sec.");

        if (error_status) extentTest.log(LogStatus.PASS, "Page is loaded");

        extent.endTest(extentTest);
        extent.flush();

        return error_status;
    }



    public static void LoadPage(String pageURL, String expected) {
        String currentURL = browser.getCurrentUrl();
        System.out.println("Current URL is: " + currentURL);

        if (pageURL.equals(currentURL)) {
            try {
                RefreshPage();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            browser.get(pageURL);
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void LoadPage(String PageURL) {
        LoadPage(PageURL, "/html/body");
    }



    public static boolean Check(String fileName) {
        String testSuiteName = getMethodName();

        System.out.println(testSuiteName + ". ");
        ExtentReports extent = NewReport();
        ExtentTest extentTest = extent.startTest(testSuiteName + " - Page check by galen", "Page check by galen");

        boolean error_status = true;

        LayoutReport layoutReport = null;
        try {
            layoutReport = Galen.checkLayout(browser, "specs/" + fileName + ".spec", Arrays.asList("desktop"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        extentTest.log(LogStatus.PASS, "<a href = \"C:\\tests\\a42gazeta\\target\\1--layout.html\">Galen report</a>");

        extent.endTest(extentTest);
        extent.flush();

        //Create a tests list
        List<GalenTestInfo> tests = new LinkedList<GalenTestInfo>();

        String title = browser.getTitle();

        //Create a GalenTestInfo object
        GalenTestInfo test = GalenTestInfo.fromString(title + " layout");

        //Get layoutReport and assign to test object
        test.getReport().layout(layoutReport, "Check " + title + " layout");

        //Add test object to the tests list
        tests.add(test);

        //Create a htmlReportBuilder object
        HtmlReportBuilder htmlReportBuilder = new HtmlReportBuilder();

        //Create a report under /target folder based on tests list
        try {
            htmlReportBuilder.build(tests, "target");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //If layoutReport has errors Assert Fail
        if (layoutReport.errors() > 0)
        {
            Assert.fail("Layout test failed");
        }

        return error_status;
    }



    public static Object IsImageDisplayed(String imageXpath) {

        WebElement brokenImage = browser.findElement(By.xpath(imageXpath));

        WrapsDriver wrapsDriver = (WrapsDriver) brokenImage;
        String script = "return (typeof arguments[0].naturalWidth!=\"undefined\"" +
                " && arguments[0].naturalWidth>0)";
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) wrapsDriver.getWrappedDriver();

        Object isBrokenShown = javascriptExecutor.executeScript(script, brokenImage);

        return isBrokenShown;
    }



    public static void RefreshPage() throws Exception {
        browser.navigate().refresh();
        Thread.sleep(2000);
    }



    public static boolean HoverAndCick(String hoverXpath, String clickXpath) {
        boolean error_status = true;
        Actions actions = new Actions(browser);

        // SEARCH AND HOVER MENU
        try {
            WebElement menu = browser.findElement(By.xpath(hoverXpath));
            actions.moveToElement(menu);
        }catch (Exception e) {
            error_status = false;
        }

        // SEARCH AND CLICK SUBMENU ELEMENT
        if (error_status) {
            try {
                WebElement subMenu = browser.findElement(By.xpath(clickXpath));
                actions.moveToElement(subMenu);
                actions.click().build().perform();
            } catch (Exception e) {
                error_status = false;
            }
        }

        return error_status;
    }



    public static boolean IsNotDisplayed(String elementXpath) {
        boolean error_status = true;

        try {
            browser.findElements(By.xpath(elementXpath)).isEmpty();
        } catch (Exception e) {
            error_status = false;
        }

        return error_status;
    }



    public void ReadFile(String filePath) {

    }



    /*public void save(String fileName) throws FileNotFoundException {
    String tmp = clubs.toString();
    PrintWriter pw = new PrintWriter(new FileOutputStream(fileName));
    pw.write(tmp);
    pw.close();
}*/
}
