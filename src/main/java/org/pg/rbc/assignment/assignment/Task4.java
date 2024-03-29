package org.pg.rbc.assignment.assignment;

import org.pg.rbc.assignment.pages.LoblawsPage;
import org.pg.rbc.assignment.pages.LocationSelector;
import org.pg.rbc.assignment.pages.StoreFlyer;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task4 extends BaseTest {
    @Test
    public void chooseLocation() {
        loblawsPage = new LoblawsPage(driver);
        LocationSelector selector = loblawsPage.openLocationSelector();
        selector.searchLocation("queen street west");
        selector.pickUpLocation(1);
        selector.openLocationDetails();
        String locationAddress = selector.getAddress();
        Assert.assertTrue(locationAddress.toLowerCase().contains("queen"),"Location address should have 'queen'");
        StoreFlyer flyer = selector.openStoreFlyer();
        Assert.assertTrue(flyer.getFlyerForLocation().toLowerCase().contains("queen street west"));
    }
}
