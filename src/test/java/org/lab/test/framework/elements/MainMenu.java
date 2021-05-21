package org.lab.test.framework.elements;

import org.lab.test.framework.BaseElement;
import org.openqa.selenium.By;

public class MainMenu {
    public By installButton = By.xpath("//a[@class='header_installsteam_btn_content']");

    public void navigateMenu(By menuItem, By SubMenuItem){
        BaseElement mainItem = new BaseElement(menuItem);
        BaseElement secondItem = new BaseElement(SubMenuItem);

        mainItem.clickElement();
        secondItem.clickElement();
    }

    public void installSteam() {
        BaseElement installButton = new BaseElement(this.installButton);
        installButton.clickElement();
    }
}
