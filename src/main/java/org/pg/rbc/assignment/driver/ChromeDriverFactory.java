package org.pg.rbc.assignment.driver;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.pg.rbc.assignment.config.Config;
import org.pg.rbc.assignment.utils.ResourceUtils;


import java.net.URL;

public class ChromeDriverFactory {

    public static ChromeDriver createChromeDriver(String pathToExec) {
        System.setProperty("webdriver.chrome.driver",pathToExec);
        ChromeOptions chromeOptions = getChromeOptions();
        return new ChromeDriver(chromeOptions);
    }

    public static ChromeDriver createChromeDriver(String pathToExec, ChromeOptions chromeOptions) {
        System.setProperty("webdriver.chrome.driver",pathToExec);
        return new ChromeDriver(chromeOptions);
    }

    public static ChromeDriver createChromeDriver() {
        String pathToExec = getChromeDriverPath();
        return createChromeDriver(pathToExec);
    }

    public static WebDriver createRemoteChromeDriver(URL hub) {
        ChromeOptions chromeOptions = getChromeOptions();
        RemoteWebDriver driver = createRemoteWebdriver(hub, new DesiredCapabilities(chromeOptions));
        return driver;
    }

    public static String getChromeDriverPath() {
        String defValue = Config.getConfig().getChromeDriverPath();
        return ResourceUtils.getSystemProperty("webdriver.chrome.driver",defValue);
    }

    public static ChromeOptions getChromeOptions() {
        MutableCapabilities mc = getDefaultMutualCapabilities();
        return getChromeOptionsFrom(mc);
    }


    public static RemoteWebDriver createRemoteWebdriver(URL hub, DesiredCapabilities capabilities) {
        addDefaultCapabilitiesTo(capabilities);
        RemoteWebDriver driver = 	new RemoteWebDriver(hub, capabilities);
        return driver;
    }

    public static MutableCapabilities getDefaultMutualCapabilities() {
        MutableCapabilities mc = new MutableCapabilities();
        mc.setCapability(org.openqa.selenium.remote.CapabilityType.ACCEPT_SSL_CERTS, true);
        mc.setCapability(org.openqa.selenium.remote.CapabilityType.SUPPORTS_JAVASCRIPT,true);
        mc.setCapability(org.openqa.selenium.remote.CapabilityType.SUPPORTS_FINDING_BY_CSS, true);
        return mc;
    }

    private static ChromeOptions getChromeOptionsFrom(MutableCapabilities mc) {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.merge(mc);
        chromeOptions = chromeOptions.addArguments("--disable-extensions");
        chromeOptions.setExperimentalOption("useAutomationExtension", false);
        return chromeOptions;
    }

    private static void addDefaultCapabilitiesTo(DesiredCapabilities dc) {
        dc.merge(getDefaultMutualCapabilities());
    }


}

