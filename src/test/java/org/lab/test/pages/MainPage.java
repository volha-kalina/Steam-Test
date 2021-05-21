package org.lab.test.pages;

import org.lab.test.framework.Browser;
import org.lab.test.framework.elements.MainMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class MainPage extends BasePage {
    private static final By LANGUAGE_BTN = By.xpath("//span[@id=\"language_pulldown\"]");
    private static final MainMenu MENU = new MainMenu();

    public MainPage() {
        super(LANGUAGE_BTN);
    }

    public void selectLanguage(By language, String correctLangValue) {
        if (baseElement.getText().contains(correctLangValue)) {
            return;
        }
        baseElement.clickElement(LANGUAGE_BTN);
        baseElement.clickElement(language);

        WebDriver driver = Browser.getDriver();

        Wait wait = new FluentWait<WebDriver>(driver)
                .withTimeout(20, TimeUnit.SECONDS)
                .pollingEvery(1, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);

        wait.until(new Function<WebDriver, Boolean>() {
                       public Boolean apply(WebDriver driver) {
                           return languageChangingInProcess();
                       }
                   }
        );

        wait.until(new Function<WebDriver, Boolean>() {
                       public Boolean apply(WebDriver driver) {
                           return isLanguageChanged();
                       }
                   }
        );
    }

    public void navigateMenu(By item, By subItem) {
        MENU.navigateMenu(item, subItem);
    }

    public Boolean languageChangingInProcess() {
        WebDriver driver = Browser.getDriver();
        WebElement modal = driver.findElement(By.cssSelector(".newmodal_background"));

        return modal != null;
    }

    public Boolean isLanguageChanged() {
        WebDriver driver = Browser.getDriver();
        try {
            WebElement modal = driver.findElement(By.cssSelector(".newmodal_background"));
        } catch (Exception e) {
            return true;
        }

        return false;
    }
}
