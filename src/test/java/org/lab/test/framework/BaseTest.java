package org.lab.test.framework;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    static ConfProperties config = new ConfProperties();

    @BeforeMethod
    public static void setUp() {
        Browser browser = Browser.getInstance();
        browser.openUrl(config.getProperty("mainPage"));
    }

    @AfterMethod()
    public static void tearDown() {
        Browser.closeBrowser();
    }
}
