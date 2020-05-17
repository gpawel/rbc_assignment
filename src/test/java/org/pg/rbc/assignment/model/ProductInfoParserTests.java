package org.pg.rbc.assignment.model;

import org.openqa.selenium.WebElement;
import org.pg.rbc.assignment.BaseTest;
import org.pg.rbc.assignment.pages.LoblawsPage;
import org.pg.rbc.assignment.pages.SearchResultsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ProductInfoParserTests extends BaseTest {
    private LoblawsPage loblawsPage;

    @BeforeMethod
    public void setUpTestMethod() {
        loblawsPage = new LoblawsPage(driver);
    }

    @Test
    public void findSingleProduct1() {
        String prodId = "20083526001_KG";
        SearchResultsPage resultsPage = loblawsPage.search("apples");
        List<WebElement> prods = resultsPage.getProductById(prodId);
        Assert.assertFalse(prods.isEmpty());
    }

    @Test
    public void findSingleProduct2() {
        String prodId = "20725795001_EA";
        SearchResultsPage resultsPage = loblawsPage.search("apples");
        List<WebElement> prods = resultsPage.getProductById(prodId);
        Assert.assertFalse(prods.isEmpty());
    }

    @Test
    public void parseProductId() {
        String prodId = "20725795001_EA";
        SearchResultsPage resultsPage = loblawsPage.search("apples");
        List<WebElement> prods = resultsPage.getProductById(prodId);
        Assert.assertFalse(prods.isEmpty());
        WebElement root = prods.get(0);
        ProductInfoParser parser = new ProductInfoParser(driver);
        parser.getProducts(root);
    }

    @Test
    public void parseProductSales1() {
        String prodId = "20606349001_EA";
        SearchResultsPage resultsPage = loblawsPage.search("apples");
        List<WebElement> prods = resultsPage.getProductById(prodId);
        Assert.assertFalse(prods.isEmpty());
        WebElement root = prods.get(0);
        ProductInfoParser parser = new ProductInfoParser(driver);
        parser.getProducts(root);
    }

    @Test
    public void parseProductSales2() {
        String prodId = "20632238001_EA";
        SearchResultsPage resultsPage = loblawsPage.search("apples");
        List<WebElement> prods = resultsPage.getProductById(prodId);
        Assert.assertFalse(prods.isEmpty());
        WebElement root = prods.get(0);
        ProductInfoParser parser = new ProductInfoParser(driver);
        parser.getProducts(root);
    }

    //
}
