package org.pg.rbc.assignment.pages;

import org.pg.rbc.assignment.BaseUnitTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocationSelectorTests extends BaseUnitTest {
    @Test
    public void chooseLocation() {
        LoblawsPage loblawsPage = new LoblawsPage(driver);
        LocationSelector selector = loblawsPage.openLocationSelector();
        selector.searchLocation("queen street west");
        selector.pickUpLocation(1);
        selector.openLocationDetails();
        String locationAddress = selector.getAddress();
        Assert.assertTrue(locationAddress.toLowerCase().contains("queen"));
        StoreFlyer flyer = selector.openStoreFlyer();
        Assert.assertTrue(flyer.getFlyerForLocation().toLowerCase().contains("queen street west"));
    }
}
