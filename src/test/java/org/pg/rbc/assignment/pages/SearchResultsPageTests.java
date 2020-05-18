package org.pg.rbc.assignment.pages;

import org.openqa.selenium.WebElement;
import org.pg.rbc.assignment.BaseTest;
import org.pg.rbc.assignment.model.Catalogue;
import org.pg.rbc.assignment.model.Product;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.sql.rowset.WebRowSet;
import java.util.Collections;
import java.util.List;


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
        Assert.assertEquals(itemsOnPage,resultsPage.getLastItemIndexOnPage());
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
        Assert.assertEquals(lastIndex,resultsPage.getLastItemIndexOnPage());
    }

    @Test
    public void sortOnePageList() {
        SearchResultsPage resultsPage = loblawsPage.search("appicot");
        resultsPage.loadAllPages();
        List<WebElement> webElementsList = resultsPage.getAllFoundProducts();
        ProductInfoParser parser = new ProductInfoParser(driver);
        List<Product> productList = parser.getProducts(webElementsList);
        Collections.sort(productList);
        Collections.reverse(productList);



        Assert.assertEquals(productList.size(),resultsPage.getLastItemIndexOnPage());
        resultsPage.sortDesc();

        Product topProductInList = productList.get(0);
        Product topProductOnPage = parser.parseProductById(topProductInList.getId());
        Assert.assertEquals(topProductOnPage.getProductIndex(),1);

        Product cheapestProdInList = productList.get(productList.size()-1);
        Product cheapestProdOnPage = parser.parseProductById(cheapestProdInList.getId());
        Assert.assertEquals(cheapestProdOnPage.getProductIndex(),47);


    }

    @Test
    public void testScroll() {
        SearchResultsPage resultsPage = loblawsPage.search("milk");
        resultsPage.loadMore(3);
        resultsPage.scrollToTheTop();
        resultsPage.sortDesc();
    }

    @Test
    public void sortAllProdsList() {
        SearchResultsPage resultsPage = loblawsPage.search("apples");
        resultsPage.loadAllPages();
        List<WebElement> webElementsList = resultsPage.getAllFoundProducts();
        ProductInfoParser parser = new ProductInfoParser(driver);
        List<Product> productList = parser.getProducts(webElementsList);
        Catalogue catalogue = new Catalogue(productList);
        catalogue.sortProductsDesc();
        resultsPage.scrollToTheTop();

        Assert.assertEquals(productList.size(),resultsPage.getLastItemIndexOnPage());
        resultsPage.sortDesc();
        resultsPage.loadAllPages();

        Product topProductInList = productList.get(0);
        Product topProductOnPage = parser.parseProductById(topProductInList.getId());
        Assert.assertEquals(topProductOnPage.getProductIndex(),1);

        Product cheapestProdInList = productList.get(productList.size()-1);
        Product cheapestProdOnPage = parser.parseProductById(cheapestProdInList.getId());
        Assert.assertEquals(cheapestProdOnPage.getProductIndex(),resultsPage.getLastItemIndexOnPage());


    }

    @Test
    public void testPriceReductionFilter() {
        loblawsPage.goHomePage();
        SearchResultsPage resultsPage = loblawsPage.search("milk");
        resultsPage.filterByPriceReduction();
    }

    @Test
    public void testPriceReduction() {

    }




}
