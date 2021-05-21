package org.lab.test;

import org.lab.test.framework.BaseTest;
import org.lab.test.framework.ConfProperties;
import org.lab.test.pages.GamePage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.lab.test.pages.CategoryPage;
import org.lab.test.pages.DownloadPage;
import org.lab.test.pages.MainPage;

public class MainTest extends BaseTest {
    private static final String LANGUAGE = "//div[@id=\"language_dropdown\"]/div/*[contains(text(), 'NEEDED_LANGUAGE')]";
    private static final String MENU_ITEM = "#genre_tab";
    private static final String SUB_MENU_ITEM = "//div[@id=\"genre_flyout\"]/div/div[2]/div[3]/a";

    @Test
    public void runTest() {
        MainPage mainPage = new MainPage();

        String neededLanguage = ConfProperties.getProperty("neededLanguage");
        String correctLanguageInputValue = ConfProperties.getProperty("correctLanguageInputValue");
        mainPage.selectLanguage(By.xpath(LANGUAGE.replace("NEEDED_LANGUAGE", neededLanguage)), correctLanguageInputValue);
        mainPage.navigateMenu(By.cssSelector(MENU_ITEM), By.xpath(SUB_MENU_ITEM));

        CategoryPage categoryPage = new CategoryPage();
        categoryPage.navigateToGameWithTheLargestDiscount();
        GamePage gamePage = new GamePage();
        categoryPage.installSteam();
        DownloadPage downloadPage = new DownloadPage();
        downloadPage.downloadSteam();
    }
}
