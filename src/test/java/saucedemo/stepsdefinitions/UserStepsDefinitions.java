package saucedemo.stepsdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.eo.Se;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.SoftAssertions;
import saucedemo.steps.UserSaceDemo;

public class UserStepsDefinitions {
    @Steps(shared = true)
    UserSaceDemo user;

    SoftAssertions softAssert = new SoftAssertions();

    @Given("^user navigates to https://www.saucedemo.com/$")
    public void userNavigateToSauceDemo() {
        user.navigateTo();
        Serenity.takeScreenshot();
    }

    @And("^login as standard user$")
    public void loginAsStandardUser() {
        user.login();
        Serenity.takeScreenshot();
    }

    @And("^go to about page$")
    public void goToAboutPage() {
        user.goToAboutPage();
        Serenity.takeScreenshot();
    }

    @And("^go back to inventory page$")
    public void goBackToInventoryPage() {
        user.goBackToInventoryPage();
        Serenity.takeScreenshot();
    }

    @Given("^4 most expensive products added to cart$")
    public void userAddFourMostExpensiveProductsToCart() {
        user.addFourMostExpensiveProductsToCart();
        Serenity.takeScreenshot();
    }

    @And("^user check shopping cart badge$")
    public void userCheckShoppingCartBadge() {
        user.checkShoppingCartBadge(softAssert);
        Serenity.takeScreenshot();
    }

    @And("^user go to cart page$")
    public void userGoToCartPage() {
        user.goToCartPage();
        Serenity.takeScreenshot();
    }

    @And("^complete checkout step one$")
    public void userCompleteCheckoutStepOne() {
        user.completeCheckoutStepOne();
    }

    @And("^check order on checkout step two$")
    public void checkOrderOnCheckoutStepTwo() {
        user.checkOrderOnCheckoutStepTwo(softAssert);
        Serenity.takeScreenshot();
    }

    @And("^finish order$")
    public void userFinishOrder() {
        user.finishOrder();
    }

    @Then("^success message is displayed$")
    public void successMessageIsDisplayed() {
        user.checkIfSuccessMessageIsDisplayed(softAssert);
        softAssert.assertAll();
    }
}
