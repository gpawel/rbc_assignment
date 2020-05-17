package org.pg.rbc.assignment.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ProductInfoParser {

    private List<WebElement> products = new ArrayList<WebElement>();;

    private By productId = By.xpath("./div[@data-track-product-id]");
    private By salesText = By.xpath("//div[contains(@class,'product-badge__icon__text product-badge__icon__text--sale')]");
    private By salesEnds = By.xpath("//div[contains(@class,'product-badge__icon__expiry product-badge__icon__expiry--sale')]");
    private By productEyeBrow = By.cssSelector(".product-tile__eyebrow");
    private By productBrand = By.cssSelector(".product-name__item product-name__item--brand");
    private By productName = By.className(".product-name__item product-name__item--name");
    private By productSize = By.cssSelector(".product-name__item product-name__item--package-size");
    private By productText = By.cssSelector(".product-badge__text product-badge__text--product-tile");
    private By sellingPriceList = By.cssSelector(".selling-price-list selling-price-list--product-tile,product-tile");
    private By sellingPriceValue = By.cssSelector(".price__value selling-price-list__item__price selling-price-list__item__price--now-price__value");
    private By sellingPriceWasValue = By.cssSelector(".price selling-price-list__item__price selling-price-list__item__price--was-price");
    private By sellingPriceType = By.cssSelector(".price__type selling-price-list__item__price selling-price-list__item__price--now-price__type");
    private By sellingPriceWasType = By.cssSelector(".price__type selling-price-list__item__price selling-price-list__item__price--was-price__type");
    private By sellingPriceUnit = By.cssSelector(".price__unit selling-price-list__item__price selling-price-list__item__price--now-price__unit");
    private By comparisonPriceList = By.cssSelector(".comparison-price-list comparison-price-list--product-tile comparison-price-list--product-tile");
    private By comparisonPriceValue = By.cssSelector(".price__value comparison-price-list__item__price__value");
    private By comparisonPriceUnit = By.cssSelector(".price__value comparison-price-list__item__price__value");

    private WebDriver driver;

    public ProductInfoParser(WebDriver driver) {
        this.driver = driver;
    }

    public List<Product> getProducts(List<WebElement> prodInfo) {
        products.addAll(prodInfo);
        return parse(products);
    }

    public List<Product> getProducts(WebElement prodInfo) {
        products.add(prodInfo);
        return parse(products);
    }

    private List<Product> parse(List<WebElement> products) {
        ArrayList<Product> result = new ArrayList<>();
        for (WebElement productRoot : products) result.add(parseSingleProductElement(productRoot));
        return result;
    }

    private Product parseSingleProductElement(WebElement root) {
        String prodId = root.findElement(productId).getAttribute("data-track-product-id");
        parseProductById(prodId);
        return null;
    }

    private Product parseProductById (String prodId) {
        String root  = "//div[@data-track-product-id='" + productId + "']/..";
        String sales = getValue(root+salesText);
        String salesExpires = getValue(root+salesEnds);
        return null;
    }

    private String getValue(String xpath) {
        List<WebElement> r = driver.findElements(By.xpath(xpath));
        if (r.isEmpty()) return "";
        else return r.get(0).getText();
    }


}
