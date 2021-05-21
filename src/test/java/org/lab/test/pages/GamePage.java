package org.lab.test.pages;

import org.lab.test.framework.Browser;
import org.lab.test.framework.elements.MainMenu;
import org.openqa.selenium.By;

public class GamePage extends BasePage {
    public static final By CAPTION = By.cssSelector("div.apphub_AppName");
    public static final By DISCOUNT = By.cssSelector("div.discount_block.game_purchase_discount > div.discount_pct");

    public GamePage() {
        super(CAPTION);
    }

    public Boolean checkIsCorrectDiscount(String discount) {
        System.out.println(discount);
        System.out.println(Browser.getDriver().findElement(DISCOUNT).getText());
        return Browser.getDriver().findElement(DISCOUNT).getText() == discount;
    }
}
