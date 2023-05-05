package saucedemo.pageobject;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class InventoryPage extends PageObject {
    @FindBy(id = "react-burger-menu-btn")
    WebElementFacade menuButton;

    @FindBy(id = "about_sidebar_link")
    WebElementFacade aboutLink;

    @FindBy(className = "product_sort_container")
    WebElementFacade productSortSelect;

    @FindBy(className = "shopping_cart_link")
    WebElementFacade shopppingCartLink;
    List<WebElementFacade> products;
    WebElementFacade shoppingCartBadge;
    private String addToCartButtonXpath = "//button[contains(@id, 'add-to-cart')]";
    public void goToAboutPage() {
        menuButton.click();
        aboutLink.click();
    }

    public void goToCartPage() {
        shopppingCartLink.click();
    }

    public void sortProductsByHighToLowPrice() {
        productSortSelect.selectByValue("hilo");
        products = withTimeoutOf(1, TimeUnit.SECONDS)
                .findAll(By.className("pricebar"));
    }

    public void addFirstNProductsToCart(int n) {
        for(int i = 0; i < n; i++) {
            products.get(i).findElement(By.xpath(addToCartButtonXpath)).click();
        }
    }

    public void checkShoppingCartBadge(SoftAssertions softAssert) {
        shoppingCartBadge = withTimeoutOf(1, TimeUnit.SECONDS)
                .find(By.className("shopping_cart_badge"));

        softAssert.assertThat(shoppingCartBadge.getText()).isEqualTo("6");
    }


}
