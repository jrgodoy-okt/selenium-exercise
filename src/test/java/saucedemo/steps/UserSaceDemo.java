package saucedemo.steps;

import net.serenitybdd.core.steps.ScenarioActor;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.SoftAssertions;
import saucedemo.pageobject.*;

public class UserSaceDemo extends ScenarioActor {
    @Steps(shared = true)
    LoginPage loginPage;
    @Steps(shared = true)
    AboutPage aboutPage;
    @Steps(shared = true)
    InventoryPage inventoryPage;
    @Steps(shared = true)
    ShoppingCartPage shoppingCartPage;
    @Steps(shared = true)
    CheckoutStepOnePage checkoutStepOnePage;
    @Steps(shared = true)
    CheckoutStepTwoPage checkoutStepTwoPage;
    @Steps(shared = true)
    CheckoutCompletePage checkoutCompletePage;

    public void navigateTo() {
        loginPage.setDefaultBaseUrl("https://www.saucedemo.com/");
        loginPage.open();
    }

    public void login() {
        loginPage.loginAsStandardUser();
    }

    public void goToAboutPage() {
        inventoryPage.goToAboutPage();
    }

    public void goBackToInventoryPage() {
        aboutPage.goBack();
    }
    public void addFourMostExpensiveProductsToCart() {
        inventoryPage.sortProductsByHighToLowPrice();
        inventoryPage.addFirstNProductsToCart(4);
    }

    public void checkShoppingCartBadge(SoftAssertions softAssert) {
        inventoryPage.checkShoppingCartBadge(softAssert);
    }

    public void goToCartPage() {
        inventoryPage.goToCartPage();
        shoppingCartPage.getProductsDetails();
    }

    public void completeCheckoutStepOne() {
        shoppingCartPage.goToCheckout();
        checkoutStepOnePage.completeCheckout();
    }

    public void checkOrderOnCheckoutStepTwo(SoftAssertions softAssert) {
        checkoutStepTwoPage.checkTotalPrice(softAssert);
    }

    public void finishOrder() {
        checkoutStepTwoPage.finishCheckout();
    }

    public void checkIfSuccessMessageIsDisplayed(SoftAssertions softAssert) {
        checkoutCompletePage.checkIfSuccessMessageIsDisplayed(softAssert);
    }

}
