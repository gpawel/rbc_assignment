package org.pg.rbc.assignment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LocationSelector extends Page {
    private By storeLocatorContentLocator = By.cssSelector("div.store-locator-content");
    private By locationSearchField = By.cssSelector("input.location-search__search__input");
    private By storeLocatorContentList = By.cssSelector("ul.location-list");
    private By pickupLocationButtonSelector = By.cssSelector("button.location-set-store__button.location-set-store__button--is-not-current-location.location-set-store__button--is-shoppable.location-set-store__button--is-store.location-set-store__button--is-not-this-banner");
    private By continueButton = By.cssSelector("a.fulfillment-location-confirmation__actions__button");

    public LocationSelector(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.presenceOfElementLocated(storeLocatorContentLocator));
    }

    public void searchLocation(String locationTofind) {
        WebElement field = driver.findElement(locationSearchField);
        field.click();
        field.sendKeys(locationTofind);
        field.submit();
        wait.until(ExpectedConditions.presenceOfElementLocated(storeLocatorContentList));
    }

    public void pickUpLocation(int locationNumber) {
        if (locationNumber < 1 ) throw new RuntimeException("Location number must be more than 0");
        WebElement el = driver.findElements(pickupLocationButtonSelector).get(locationNumber-1);
        el.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(continueButton));
        driver.findElement(continueButton).click();
    }
}
