package org.pg.rbc.assignment.pages;

import org.pg.rbc.assignment.BaseUnitTest;
import org.testng.annotations.Test;

public class ShoppingCartTests extends BaseUnitTest {
    @Test
    public void addItemToShoppingCart() {
        LoblawsPage loblawsPage = new LoblawsPage(driver);
        SearchResultsPage resultsPage = loblawsPage.search("apples");

        ShoppingCart cart = resultsPage.addItemToShoppingCart(1);


    }
}
