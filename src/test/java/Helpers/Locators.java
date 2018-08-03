package Helpers;

import java.util.*;

public class Locators extends Settings {

    //EXTENT REPORT
    //Create report file
    public static String extentReportFile = System.getProperty("user.dir") + "\\extentReportFile.html";
    public static String extentReportImage = System.getProperty("user.dir") + "\\extentReportFile.png";



    //LINKS
    public static final String LoginPage = "http://test-case.vats.atwinta.ru/login/";
    public static final String NewsListURL = "http://gazeta.a42.ru/lenta/news";
    public static final String PhotoListURL = "http://gazeta.a42.ru/lenta/photos";
    public static final String ArticleListURL = "http://gazeta.a42.ru/lenta/articles";
    public static final String ProjectListURL = "http://gazeta.a42.ru/lenta/projects";
    public static final String AuthorsListURL = "http://gazeta.a42.ru/lenta/authors";
    public static final String ConfListURL = "http://gazeta.a42.ru/lenta/conf";
    public static final String CompanyListURL = "http://gazeta.a42.ru/lenta/companies";



    //SPEC FILES
    public static final String NewsList_spec = "news_List";
    public static final String NewsPage_spec = "news_Page";



    //DATA
    public static final String Login = "director@test-case-company.com";
    public static final String Password = "password";
    public static final String replacement = "_test";



    //IMAGES
    public static final String NewsList_main_news_Image = "/html/body/div[1]/div[5]/div[1]/div[1]/div[2]/a/span/img";
    public static final String NewsList_news_item_Image_1 = "//*[@id=\"paginate-block\"]/div/div[1]/p[1]/a/span/img";
    public static final String NewsList_news_item_Image_2 = "//*[@id=\"paginate-block\"]/div/div[2]/p[1]/a/span/img";



    //NEWS LIST ELEMENTS
    public static final String NewsList_ShowMore_btn = "//*[@id=\"paginate-block\"]/noindex/p/a";



    //PHOTO REPORT'S LIST ELEMENTS
    public static final String PhotoList_ShowMore_btn = "//*[@id=\"paginate-block\"]/noindex/p/a";



    //LOGIN PAGE ELEMENTS
    public static final String EmailInput = "/html/body/div/div/div[2]/div[1]/form/div[2]/div/div[2]/input";
    public static final String PasswordInput = "/html/body/div/div/div[2]/div[1]/form/div[3]/div/div[2]/input";
    public static final String LoginButton = "/html/body/div/div/div[2]/div[1]/form/button";



    //EMPLOYERS PAGE
    public static final String EmployersTitleH1 = "//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[1]/div/div[1]/span";



    public static final String reportPath = "";
    public static final String reportFilePath = "c:/tests/HomePage/extentReportFile.html";

    static final String shortMessage50 = "";
    static final String mediumMessage255 = "";
    static final String longMessage500 = "";
    static final String trashMessage = "";

    static final String xssString1 = "";
    static final String xssString2 = "";
    static final String xssString3 = "";

    //Page elements
    public static final String content_title_xpath = "/html/body/div[1]/div[6]/div[1]/div[1]/header/h1";
    public static final String content_text_selector = "#material > div";

    //Elements margins
    public static final int title_x_margin_from_top = 200;
    public static final int title_y_margin_from_left = 200;

    static final HashSet<Character> PUNCT_SET = new HashSet<Character>(Arrays.asList(
            '!', '"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-',
            '.', '/', ':', ';', '<', '=', '>', '?', '@', '[', '\\', ']', '^',
            '_', '`', '{', '|', '}', '~'
    ));

    static final String[] Homeurl_list = {
            "http://atwinta.ru/services/web-dev",
            "http://atwinta.ru/services/adaptive",
            "http://atwinta.ru/services/services",
            "http://atwinta.ru/services/technical-task-and-prototypes",
            "http://atwinta.ru/services/web-design",
            "http://atwinta.ru/services/mobile",
            "http://atwinta.ru/services/mobile-design",
            "http://atwinta.ru/services/apps-for-smart-tv",
            "http://atwinta.ru/services/support",
            "http://atwinta.ru/services/context",
            "http://atwinta.ru/services/seo",
            "http://atwinta.ru/services/smm",
            "http://atwinta.ru/services/promoting-business-in-vkontakte",
            "http://atwinta.ru/services/promoting-business-in-instagram",
            "http://atwinta.ru/portfolio",
            "http://atwinta.ru/portfolio/more/kpd",
            "http://atwinta.ru/portfolio/more/bolshoe-tv",
            "http://atwinta.ru/portfolio/more/sibir.tv"
    };

}
