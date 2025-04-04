package org.pg.rbc.assignment.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pg.rbc.assignment.BaseUnitTest;
import org.pg.rbc.assignment.config.Config;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChromeDriverFactoryTests extends BaseUnitTest {
    private WebDriver driver;

    @Test
    public void startChromeDriver() {
        driver = ChromeDriverFactory.createChromeDriver();
        Assert.assertNotNull(driver);
        driver.get("https://www.loblaws.ca/");
        driver.manage().window().maximize();
        Wait wait = new WebDriverWait(driver, 4 * Config.getConfig().getPauseInTest() / 1000);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".logo")));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("site-content")));
        WebElement element = driver.findElement(By.cssSelector("div.booking-selector>a>span>span"));
        Assert.assertEquals(element.getText(), "Store Locator".toUpperCase());
    }
    @AfterMethod
    public void tearDownTestMethod() {
        driver.quit();
    }


}
