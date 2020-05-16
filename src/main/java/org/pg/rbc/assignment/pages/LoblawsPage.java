package org.pg.rbc.assignment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoblawsPage extends Page {
    private static Logger log = LoggerFactory.getLogger(LoblawsPage.class);

    private By content = By.id("site-content");
    private By queryField = By.cssSelector(".search-form__typeahead__search-input__input");

    public LoblawsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        driver.get("https://www.loblaws.ca/");
        driver.manage().window().maximize();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(content));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(queryField));
    }

    public SearchResultsPage search(String product) {
        WebElement element = driver.findElement(queryField);
        element.clear();
        element.sendKeys(product);
        element.sendKeys(Keys.ENTER);
        return new SearchResultsPage(driver, product);
    }




}
