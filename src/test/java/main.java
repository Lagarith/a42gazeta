import gazeta.pages.ArticleList_page;
import gazeta.tests.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;



public class main {

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(
                ArticleList_test.class,
                ArticlePage_test.class,
                AuthorsList_test.class,
                AuthorsPage_test.class,
                CompanyList_test.class,
                CompanyPage_test.class,
                ConfList_test.class,
                HomePage_test.class,
                NewsPage_test.class,
                PhotoReportPage_test.class,
                PhotoReportList_test.class,
                ProjectPage_test.class,
                ProjectsList_test.class
        );

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());
    }
    }

