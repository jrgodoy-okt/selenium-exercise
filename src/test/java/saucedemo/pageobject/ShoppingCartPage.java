package saucedemo.pageobject;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShoppingCartPage extends PageObject {

    @FindBy(id = "checkout")
    WebElementFacade checkoutButton;
    List<WebElementFacade> products;

    public void goToCheckout() {
        checkoutButton.click();
    }
    public void getProductsDetails() {
        products = findAll(By.className("cart_item_label"));
        String description = "";
        for(WebElementFacade element : products) {
            description += "\n\nName: " + element.find(By.className("inventory_item_name")).getText()
                    + "\nDesc: " + element.find(By.className("inventory_item_desc")).getText()
                    + "\nPrice: " + element.find(By.className("inventory_item_price")).getText();
        }

        Serenity.recordReportData().withTitle("Products in cart").andContents(description);
    }
}
