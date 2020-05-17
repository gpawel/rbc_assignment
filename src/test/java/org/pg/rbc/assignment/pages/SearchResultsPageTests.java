package org.pg.rbc.assignment.pages;

import org.pg.rbc.assignment.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class SearchResultsPageTests extends BaseTest {

    private LoblawsPage loblawsPage;


    @BeforeMethod
    public void setUpTestMethod() {
        loblawsPage = new LoblawsPage(driver);
    }

    @Test
    public void createSearchResultsPageTest() {
        SearchResultsPage resultsPage = loblawsPage.search("apples");
        Assert.assertNotNull(resultsPage);
    }

    @Test
    public void getTotlaFindings() {
        SearchResultsPage resultsPage = loblawsPage.search("apples");
        int total = resultsPage.getTotalFound();
        Assert.assertEquals(total,513);
    }

    @Test
    public void getItemsOnPageSinglePage() {
        SearchResultsPage resultsPage = loblawsPage.search("asdf");
        int itemsOnPage = resultsPage.getNumberOfItemsOnPages();
        Assert.assertEquals(itemsOnPage,2);
    }

    @Test
    public void getItemsOnPageMultiPage() {
        SearchResultsPage resultsPage = loblawsPage.search("apples");
        int itemsOnPage = resultsPage.getNumberOfItemsOnPages();
        Assert.assertEquals(itemsOnPage,48);
    }

    @Test
    public void loadAllPages() {
        SearchResultsPage resultsPage = loblawsPage.search("milk");
        int total = resultsPage.getTotalFound();
        resultsPage.loadAllPages();
        int lastIndex = resultsPage.getLastItemIndexOnPage();
        Assert.assertEquals(lastIndex,total);
    }

    @Test
    public void noPages() {
        SearchResultsPage resultsPage = loblawsPage.search("asdf");
        resultsPage.loadAllPages();
        int lastIndex = resultsPage.getLastItemIndexOnPage();
        Assert.assertEquals(lastIndex,2);
    }

}
