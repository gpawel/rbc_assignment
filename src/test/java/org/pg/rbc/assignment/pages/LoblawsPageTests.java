package org.pg.rbc.assignment.pages;

import org.pg.rbc.assignment.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoblawsPageTests extends BaseTest {


    @Test
    public void createLoblawsPage() {
        LoblawsPage lbl = new LoblawsPage(driver);
        Assert.assertNotNull(lbl);
    }




}
