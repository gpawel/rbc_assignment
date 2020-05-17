package org.pg.rbc.assignment.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ProductInfoParser {

    private List<WebElement> products = new ArrayList<WebElement>();;

    private By trackingInfo = By.cssSelector(".product-tracking");
    private By productEyeBrow = By.cssSelector(".product-tile__eyebrow");
    private By productBrand = By.cssSelector(".product-name__item product-name__item--brand");
    private By productName = By.className(".product-name__item product-name__item--name");
    private By productSize = By.cssSelector(".product-name__item product-name__item--package-size");
    private By sellingPriceList = By.cssSelector(".selling-price-list selling-price-list--product-tile,product-tile");
    private By sellingPriceValue = By.cssSelector(".price__value selling-price-list__item__price selling-price-list__item__price--now-price__value");
    private By sellingPriceType = By.cssSelector(".price__type selling-price-list__item__price selling-price-list__item__price--now-price__type");
    private By sellingPriceUnit = By.cssSelector(".price__unit selling-price-list__item__price selling-price-list__item__price--now-price__unit");
    private By comparisonPriceList = By.cssSelector(".comparison-price-list comparison-price-list--product-tile comparison-price-list--product-tile");
    private By comparisonPriceValue = By.cssSelector(".price__value comparison-price-list__item__price__value");
    private By comparisonPriceUnit = By.cssSelector(".price__value comparison-price-list__item__price__value");


    public ProductInfoParser(List<WebElement> listOfProducts) {
        products.addAll(listOfProducts);
    }

    public ProductInfoParser(WebElement product) {
        products.add(product);
    }

}
