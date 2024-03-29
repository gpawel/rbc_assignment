package org.pg.rbc.assignment.pages;

import org.pg.rbc.assignment.BaseUnitTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoblawsPageTests extends BaseUnitTest {


    @Test
    public void createLoblawsPage() {
        LoblawsPage lbl = new LoblawsPage(driver);
        Assert.assertNotNull(lbl);
    }

    @Test
    public void testGoHome() {
        LoblawsPage loblawsPage = new LoblawsPage(driver);
        loblawsPage.search("milk");
        loblawsPage.goHomePage();
    }




}
