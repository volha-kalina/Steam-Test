package org.lab.test.pages;

import org.lab.test.framework.BaseElement;
import org.openqa.selenium.By;

public class BasePage {

    protected BaseElement baseElement;

    BasePage(By elementLocator) {
        baseElement= new BaseElement(elementLocator);
    }
}
