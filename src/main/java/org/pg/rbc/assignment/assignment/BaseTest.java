package org.pg.rbc.assignment.assignment;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.pg.rbc.assignment.config.Config;
import org.pg.rbc.assignment.driver.ChromeDriverFactory;
import org.pg.rbc.assignment.model.Product;
import org.pg.rbc.assignment.pages.LoblawsPage;
import org.pg.rbc.assignment.pages.ProductInfoParser;
import org.pg.rbc.assignment.pages.SearchResultsPage;
import org.testng.annotations.*;

import java.util.List;

public class BaseTest {
    public static WebDriver driver;
    public static List<Product> productList;
    public static String query;
    public static LoblawsPage loblawsPage;
    public static SearchResultsPage resultsPage;
    @Parameters({ "query" })
    @BeforeMethod
    public void setUpSuite(@Optional("apples") String searchString) {
        Config.getConfig();
        query = searchString;
        driver = ChromeDriverFactory.createChromeDriver();
        driver.get("https://www.loblaws.ca/");
        loblawsPage = new LoblawsPage(driver);

    }

    @Test
    public void firtstTest() {
        System.out.println("Hello World");
    }

    @AfterMethod
    public void tearDownSuite() {
        driver.quit();
    }
}


