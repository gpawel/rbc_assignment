package org.pg.rbc.assignment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchResultsPage extends Page {

    private String query;

    private By root = By.cssSelector("search-page__result");
    private By pageTitle = By.cssSelector("h1.page-title__title");
    private By pagination = By.cssSelector(".pagination");

    public SearchResultsPage(WebDriver driver, String query) {
        super(driver);
        this.query = query;
        wait.until(ExpectedConditions.presenceOfElementLocated(pageTitle));
    }






}
