package org.lab.test.pages;

import org.lab.test.framework.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.io.File;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class DownloadPage extends BasePage {
    public static final By DOWNLOAD_BUTTON = By.xpath("//a[@class='about_install_steam_link']");

    public DownloadPage() {
        super(DOWNLOAD_BUTTON);
    }

    public void downloadSteam() {
        this.baseElement.clickElement();
        WebDriver driver = Browser.getDriver();

        Wait wait = new FluentWait<WebDriver>(driver)
                .withTimeout(20, TimeUnit.SECONDS)
                .pollingEvery(2, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);

        wait.until(new Function<WebDriver, Boolean>() {
                       public Boolean apply(WebDriver driver) {
                           return isFileDownloaded("SteamSetup.exe");
                       }
                   }
        );
    }

    public boolean isFileDownloaded(String fileName) {
        File dir = new File("C:\\download");
        File[] dirContents = dir.listFiles();

        for (int i = 0; i < dirContents.length; i++) {
            if (dirContents[i].getName().equals(fileName)) {
                // File has been found, it can now be deleted:
                dirContents[i].delete();
                return true;
            }
        }
        return false;
    }
}
