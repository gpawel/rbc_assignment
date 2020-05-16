package org.pg.rbc.assignment.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pg.rbc.assignment.config.Config;

public abstract class Page {
    protected WebDriver driver;
    protected Wait wait;

    public Page(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 4 * Config.getConfig().getPauseInTest() / 1000);
    }
}
