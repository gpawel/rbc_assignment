package org.pg.rbc.assignment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ShoppingCart extends Page{

    private By miniCartButtonSelector = By.cssSelector("button.desktop-mini-cart-button");
    private By viewCartLinkSelector = By.cssSelector("a.cart-summary__view-cart__link");

    public ShoppingCart(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.presenceOfElementLocated(miniCartButtonSelector));
        driver.findElement(miniCartButtonSelector).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(viewCartLinkSelector));
        driver.findElement(viewCartLinkSelector).click();
    }

    public void openShoppingCart() {

    }


}
