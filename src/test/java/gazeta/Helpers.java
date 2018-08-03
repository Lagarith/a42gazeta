package gazeta;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileWriter;
import java.util.*;

import static Helpers.Settings.browser;

public class Helpers {

    static ArrayList getAllLinks(String mask) throws Exception {

        //GET ALL LINKS
        java.util.List<WebElement> links = browser.findElements(By.tagName("a"));

        //DELETE LINKS FROM ANOTHER RESOURCES
        String link_element;
        ArrayList updated_links = new ArrayList();

        for (WebElement link : links) {
            link_element = link.getAttribute("href");
            //if (link_element.contains(mask) & !updated_links.contains(link_element))

//            {
                updated_links.add(link.getAttribute("href"));
                //System.out.println(link.getAttribute("href"));
//            }
        }

        return updated_links;

    }

    static ArrayList parsing(String start_page, String mask) throws Exception {
        ArrayList updated_links = new ArrayList();
        ArrayList intermediate_links = new ArrayList();

        browser.get(start_page);
        ArrayList links = getAllLinks(mask);


        for (Object link : links) {
            if ( !updated_links.contains(link) ) {
                updated_links.add(link);
            }
        }

        for ( Object updated_link : updated_links) {
            browser.get( (String) updated_link );
            links = null;
            links = getAllLinks(mask);

            for ( Object link : links) {
                intermediate_links.add(link);
            }
        }

        for ( Object intermediate_link : intermediate_links) {
            if ( !updated_links.contains(intermediate_link) ) {
                updated_links.add(intermediate_link);
            }
        }

        System.out.println( "Total: " + updated_links.size() );

        for ( Object updated_link : updated_links) {
            System.out.println( updated_link );
        }

        return updated_links;

    }

    public static void getFullScreenshot(String file_path) throws Exception {

        Screenshot screenshot = new AShot()
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .takeScreenshot(browser);
        ImageIO.write(screenshot.getImage(), "PNG", new File("C:\\tests\\site_map\\" + file_path + ".png"));

    }

    public void addLogs(List console_info, String file_name) throws Exception {

        String csvFile = "C:\\tests\\site_map\\" + file_name + ".csv";
        FileWriter writer = new FileWriter(csvFile);
        CSVUtils.writeLine(writer, console_info, '\n', ' ');
        writer.flush();
        writer.close();

    }

    public static void analyzeLog() {

        LogEntries logEntries = browser.manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logEntries) {

            System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
            //do something useful with the data
        }
    }

}