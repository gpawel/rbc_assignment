package org.pg.rbc.assignment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SearchResultsPage extends Page {
    private static final String GET_TOTAL_REGEX ="(\\d*)\\sRESULTS\\s";
    private static final String FIRST_LAST_ITEM_INDEX_REGEX = "(\\d*)-(\\d*)";

    private String query;
    private int pageSize;

    private By root = By.cssSelector(".search-page__result");
    private By pageTitle = By.cssSelector("h1.page-title__title");
    private By pagination = By.cssSelector("span.pagination > span");
    private By loadMoreButton = By.cssSelector("div.load-more-button>button");
    int totalFound;
    private By productsContainer = By.cssSelector(".product-grid__results__products");
    private By productsGridFooter = By.cssSelector(".product-grid__results__footer");

    public SearchResultsPage(WebDriver driver, String query) {
        super(driver);
        this.query = query;
        if (containsText("We were unable to find results for")) throw new RuntimeException("There is no result page for "+query);
        wait.until(ExpectedConditions.presenceOfElementLocated(root));
        wait.until(ExpectedConditions.presenceOfElementLocated(pageTitle));
        wait.until(ExpectedConditions.presenceOfElementLocated(pagination));
        pageSize = getNumberOfItemsOnPages();
        totalFound = getTotalFound();

    }

    int getTotalFound() {
        WebElement title = driver.findElement(pageTitle);
        List<String> found = getAllRegExpFrom(title.getText(),GET_TOTAL_REGEX);
        return Integer.parseInt(found.get(1));
    }

    int getNumberOfItemsOnPages() {
        return getLastItemIndexOnPage() - getFirstItemIndexOnPage() + 1;
    }

    int getFirstItemIndexOnPage() {
        WebElement paging = getPagingElement();
        String firstIndex = getAllRegExpFrom(paging.getText(),FIRST_LAST_ITEM_INDEX_REGEX).get(1);
        return Integer.parseInt(firstIndex);
    }

    int getLastItemIndexOnPage() {
        WebElement paging = getPagingElement();
        String lastIndex = getAllRegExpFrom(paging.getText(),FIRST_LAST_ITEM_INDEX_REGEX).get(2);
        return Integer.parseInt(lastIndex);
    }

    public void loadMore() {
        wait.until(ExpectedConditions.elementToBeClickable(loadMoreButton));
        driver.findElement(loadMoreButton).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(pagination));
        wait.until(ExpectedConditions.visibilityOfElementLocated(pagination));

    }

    public void loadMore(int pages) {
        for (int i=0; i < pages; i++) loadMore();
    }

    public void loadAllPages() {
        int pages = (totalFound-pageSize)/pageSize + (totalFound%pageSize > 0 ? 1 : 0);
        loadMore(pages);


    }

    public String getQuery() {
        return query;
    }

    public int getPageSize() {
        return pageSize;
    }

    private WebElement getPagingElement() {
        return driver.findElement(pagination);
    }









}
