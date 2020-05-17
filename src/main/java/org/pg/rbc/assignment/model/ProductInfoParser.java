package org.pg.rbc.assignment.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ProductInfoParser {

    private List<WebElement> products = new ArrayList<WebElement>();;

    private By productId = By.xpath("./div[@data-track-product-id]");
    private String productIndex = "//div[@data-track-product-index]";
    private String salesText = "//div[contains(@class,'product-badge__icon__text product-badge__icon__text--sale')]";
    private String salesExpire = "//div[contains(@class,'product-badge__icon__expiry product-badge__icon__expiry--sale')]";
    private String productEyeBrow = "//div[contains(@class,'product-tile__eyebrow')]";
    private String productBrand = "//span[contains(@class,'product-name__item product-name__item--brand')]";
    private String productName = "//span[contains(@class,'product-name__item product-name__item--name')]";
    private String productSize = "//span[contains(@class,'product-name__item product-name__item--package-size')]";
    private String productText = "//div[contains(@class,'product-badge__text product-badge__text--product-tile')]";

    private String sellingPriceValue = "//span[contains(@class,'price__value selling-price-list__item__price selling-price-list__item__price--now-price__value')]";
    private String sellingPriceType = "//span[contains(@class,'price__type selling-price-list__item__price selling-price-list__item__price--now-price__type')]/span";
    private Unit sellingPriceUnit = Unit.EA;

    private String sellingPriceWasValue = "//span[contains(@class,'price__value selling-price-list__item__price selling-price-list__item__price--was-price__value')]";
    private String sellingPriceWasType = "//span[contains(@class,'price__type selling-price-list__item__price selling-price-list__item__price--was-price__type')]/span";

    private String comparisonPriceValue = "//span[contains(@class,'price__value comparison-price-list__item__price__value')]";
    private String comparisonPriceUnit = "//span[contains(@class,'price__unit comparison-price-list__item__price__unit')]";


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

    public List<Product> parse(List<WebElement> products) {
        ArrayList<Product> result = new ArrayList<>();
        for (WebElement productRoot : products) result.add(parseSingleProductElement(productRoot));
        return result;
    }

    public Product parseProductById (String productId) {
        String root  = "//div[@data-track-product-id='" + productId + "']/..";
        String prodId = productId;
        String prodIndex = driver.findElement(By.xpath(root+productIndex)).getAttribute("data-track-product-index");
        String sales = getValue(root+salesText);
        String salesExpires = getValue(root+ salesExpire);
        String prodEyeBrow = getValue(root+productEyeBrow);
        String prodBrand = getValue(root+productBrand);
        String prodName = getValue(root+productName);
        String prodSize = getValue(root+productSize);
        String prodText = getValue(root + productText);
        return null;
    }

    private Product parseSingleProductElement(WebElement root) {
        String prodId = root.findElement(productId).getAttribute("data-track-product-id");
        parseProductById(prodId);
        return null;
    }

    private String getValue(String xpath) {
        return getValue(xpath,0);
    }

    private String getValue(String xpath, int index) {
        List<WebElement> r = driver.findElements(By.xpath(xpath));
        if (r.isEmpty()) return "";
        if (index > r.size()-1) throw new RuntimeException(index + " is out of boundaries from results found by " + xpath);
        return r.get(index).getText();
    }

    private List<Price> getPrice(String xpath) {
        return null;
    }

}
