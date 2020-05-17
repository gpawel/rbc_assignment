package org.pg.rbc.assignment.model;

import org.openqa.selenium.WebElement;
import org.pg.rbc.assignment.BaseTest;
import org.pg.rbc.assignment.pages.LoblawsPage;
import org.pg.rbc.assignment.pages.ProductInfoParser;
import org.pg.rbc.assignment.pages.SearchResultsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.security.AllPermission;
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

    @Test
    public void parseProductSales3() {
        String prodId = "20613154001_EA";
        SearchResultsPage resultsPage = loblawsPage.search("apples");
        List<WebElement> prods = resultsPage.getProductById(prodId);
        Assert.assertFalse(prods.isEmpty());
        WebElement root = prods.get(0);
        ProductInfoParser parser = new ProductInfoParser(driver);
        List<Product> list = parser.getProducts(root);
        Assert.assertFalse(list.isEmpty());
        Product p = list.get(0);
        Assert.assertEquals(p.getProductBrand(),"PC Organics");
        Assert.assertEquals(p.getProductIndex(),41);
        Assert.assertEquals(p.getComparisonPrices().get(0).getValue(),5.90);
    }

    @Test
    public void parseShortListOfProducts() {
        SearchResultsPage resultsPage = loblawsPage.search("asdf");
        List<WebElement> foundElements = resultsPage.getAllFoundProducts();
        ProductInfoParser parser = new ProductInfoParser(driver);
        List<Product> prods = parser.parse(foundElements);
        Assert.assertEquals(prods.size(),resultsPage.getLastItemIndexOnPage());
    }

    @Test
    public void parseLongListOfProducts() {
        SearchResultsPage resultsPage = loblawsPage.search("milk");
        List<WebElement> foundElements = resultsPage.getAllFoundProducts();
        ProductInfoParser parser = new ProductInfoParser(driver);
        List<Product> prods = parser.parse(foundElements);
        Assert.assertEquals(prods.size(),resultsPage.getLastItemIndexOnPage());
    }
}
