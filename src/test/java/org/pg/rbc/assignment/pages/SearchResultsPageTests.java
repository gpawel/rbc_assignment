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
}
