package org.lab.test.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Browser {
    // browsers
    private static Browser instance;
    private static RemoteWebDriver driver;

    public static ConfProperties props;
    public static Browsers currentBrowser;

    private Browser() {

    }

    public static Browser getInstance() {
        if (instance == null) {
            initProperties();
            driver = BrowserFactory.setUp(currentBrowser.toString());
            instance = new Browser();
        }
        return instance;
    }

    private static void initProperties() {

        currentBrowser = Browsers.valueOf(ConfProperties.getProperty("browser").toUpperCase());
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void openUrl(String url) {
        driver.get(url);
    }

    public static void closeBrowser() {
        driver.close();
    }

    /**
     * Browsers enumeration
     */
    public enum Browsers {
        /**
         * @uml.property name="fIREFOX"
         * @uml.associationEnd
         */
        FIREFOX("firefox"),
        /**
         * @uml.property name="cHROME"
         * @uml.associationEnd
         */
        CHROME("chrome");

        public String value;

        /**
         * Constructor
         *
         * @param values Value
         */
        Browsers(final String values) {
            value = values;
        }

        /**
         * Returns string value
         *
         * @return String value
         */
        public String toString() {
            return value;
        }
    }
}
