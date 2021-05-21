package org.lab.test.pages;

import org.lab.test.framework.elements.MainMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CategoryPage extends BasePage {
    public static final By CAPTION = By.xpath("//h2[@class='pageheader']");
    public static final By SPECIALS_GRID_ITEM = By.xpath("//div[@class='discount_block  discount_block_inline']");
    public static final By SPECIALS_GRID_ITEM_DISCOUNT = By.xpath("//div[@class='discount_pct']");
    public static final MainMenu MENU = new MainMenu();

    public CategoryPage() {
        super(CAPTION);
    }

    public void navigateToGameWithTheLargestDiscount() {
        List<WebElement> elementsList = this.baseElement.getElements(SPECIALS_GRID_ITEM);
        WebElement itemWithLargestDiscount = elementsList.get(0);

        for (WebElement element : elementsList) {
            String discountStr = element.findElement(SPECIALS_GRID_ITEM_DISCOUNT).getText();
            Double discount = 0.00;
            if (discountStr != "") {
                try {
                    discount = Double.parseDouble(discountStr.replace("-", "").replace("%", ""));
                } catch (Exception e) {
                    discount = 0.00;
                }
            }

            Double currentMaxDiscount = 0.00;
            try {
                currentMaxDiscount = Double.parseDouble(itemWithLargestDiscount.findElement(SPECIALS_GRID_ITEM_DISCOUNT).getText().replace("-", "").replace("%", ""));
            } catch (Exception e) {
                currentMaxDiscount = 0.00;
            }

            if (discount > currentMaxDiscount) {
                itemWithLargestDiscount = element;
            }
        }

        itemWithLargestDiscount.click();
    }

    public void installSteam() {
        MENU.installSteam();
    }
}
