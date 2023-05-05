package saucedemo.pageobject;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.support.FindBy;

public class CheckoutCompletePage extends PageObject {

    @FindBy(className = "complete-header")
    WebElementFacade completeOrderLabel;

    public void checkIfSuccessMessageIsDisplayed(SoftAssertions softAssert) {
        String expectedMessage = "Thank you for your order!";
        softAssert.assertThat(completeOrderLabel.getText()).isEqualTo(expectedMessage);
    }
}
