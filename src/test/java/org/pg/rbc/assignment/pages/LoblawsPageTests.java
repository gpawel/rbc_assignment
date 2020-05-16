package org.pg.rbc.assignment.pages;

import org.openqa.selenium.WebDriver;
import org.pg.rbc.assignment.BaseTest;
import org.pg.rbc.assignment.driver.ChromeDriverFactory;
import org.pg.rbc.assignment.pages.LoblawsPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoblawsPageTests extends BaseTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUpTestMethod() {
        driver = ChromeDriverFactory.createChromeDriver();
    }

    @Test
    public void createLoblawsPage() {
        LoblawsPage lbl = new LoblawsPage(driver);
        Assert.assertNotNull(lbl);
    }

    @AfterMethod
    public void tearDownTestMethod() {
        driver.quit();
    }


}
