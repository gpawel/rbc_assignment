package org.pg.rbc.assignment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pg.rbc.assignment.config.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoblawsPage  {
    private static Logger log = LoggerFactory.getLogger(LoblawsPage.class);
    private WebDriver driver;
    private By content = By.id("site-content");
    private By queryField = By.cssSelector(".search-form__typeahead__search-input__input");

    public LoblawsPage(WebDriver driver) {
        this.driver = driver;
        driver.get("https://www.loblaws.ca/");
        driver.manage().window().maximize();
        Wait wait = new WebDriverWait(driver, 4 * Config.getConfig().getPauseInTest() / 1000);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(content));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(queryField));
    }

    public SearchResultPage search(String product) {


        return null;
    }




}
