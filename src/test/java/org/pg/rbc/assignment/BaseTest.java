package org.pg.rbc.assignment;

import org.openqa.selenium.WebDriver;
import org.pg.rbc.assignment.driver.ChromeDriverFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    protected static WebDriver driver = null;
    @BeforeSuite
    public void setUpSuite() {
        String env = System.getProperty("os.name");
        if (env.toLowerCase().contains("linux")) System.setProperty("env","linux");
        else System.setProperty("env","windows");
        driver = ChromeDriverFactory.createChromeDriver();
    }
    @AfterSuite
    public void tearDownSuite() {
        driver.quit();
    }

}
