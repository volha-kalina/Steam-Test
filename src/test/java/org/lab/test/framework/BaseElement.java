package org.lab.test.framework;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BaseElement implements WebElement {

    protected WebElement webElement;
    private static final int MEDIUM_WAIT = 5;
    private static final int LONG_WAIT = 15;

    public BaseElement(By by) {
        this.webElement = getElement(by);
    }

    /**
     * Method for clicking element
     *
     * @param elementLocator Locator for element
     */
    public void clickElement(By elementLocator) {
        waitElementBeClickable(elementLocator);
        getElement(elementLocator).click();
    }

    /**
     * Method for clicking element
     *
     */
    public void clickElement() {
        waitElementBeClickable(this.webElement);
        this.webElement.click();
    }

    /**
     * Method for waiting until element is clickable
     *
     * @param elementLocator Locator for element
     */
    public void waitElementBeClickable(By elementLocator) {
        WebDriverWait wait = new WebDriverWait(Browser.getDriver(), MEDIUM_WAIT);
        wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
    }

    public void waitElementBeClickable(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(Browser.getDriver(), LONG_WAIT);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    /**
     * Method for getting element by locator
     *
     * @param elementLocator Locator for element
     * @return element
     */
    public static WebElement getElement(By elementLocator) {
        try {
            return new WebDriverWait(Browser.getDriver(), MEDIUM_WAIT)
                    .until(driver -> driver.findElement(elementLocator));
        } catch (TimeoutException e) {
            System.out.println(("I can't find this element " + elementLocator));
            throw e;
        }
    }

    /**
     * Method for getting list of elements by locator
     *
     * @param elementLocator Locator for element
     * @return element's list
     */
    public static List<WebElement> getElements(By elementLocator) {
        return new WebDriverWait(Browser.getDriver(), LONG_WAIT)
                .until(driver -> driver.findElements(elementLocator));
    }

    @Override
    public void click() {

    }

    public void submit() {

    }

    public void sendKeys(CharSequence... keysToSend) {

    }

    public void clear() {

    }

    public String getTagName() {
        return null;
    }

    public String getAttribute(String name) {
        return null;
    }

    public boolean isSelected() {
        return false;
    }

    public boolean isEnabled() {
        return false;
    }

    @Override
    public String getText() {
        return this.webElement.getText();
    }


    public List<WebElement> findElements(By by) {
        return null;
    }

    public WebElement findElement(By by) {
        return null;
    }

    public boolean isDisplayed() {
        return false;
    }

    public Point getLocation() {
        return null;
    }

    public Dimension getSize() {
        return null;
    }

    public Rectangle getRect() {
        return null;
    }

    public String getCssValue(String propertyName) {
        return null;
    }

    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return null;
    }
}
