package org.pg.rbc.assignment;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    @BeforeSuite
    public void setUpSuite() {
        String env = System.getProperty("os.name");
        if (env.toLowerCase().contains("linux")) System.setProperty("env","linux");
        else System.setProperty("env","windows");
    }
}
