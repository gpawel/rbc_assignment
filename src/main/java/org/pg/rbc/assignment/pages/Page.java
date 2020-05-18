package org.pg.rbc.assignment.pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pg.rbc.assignment.config.Config;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Page {
    protected WebDriver driver;
    protected Wait wait;

    public Page(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 3 * Config.getConfig().getPauseInTest() / 1000);
    }

    public List<String> getAllRegExpFrom(String input, String regExp) {
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(input);
        ArrayList<String> list = new ArrayList<String>();
        while (m.find()) {
            for (int i = 0; i <= m.groupCount(); i++) {
                list.add(m.group(i));
            }
        }
        return list;
    }

    public void scrollToTheTop() {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollTo(0, 0)");
    }

    public boolean containsText(String text) {
        return driver.getPageSource().contains(text);
    }




}
