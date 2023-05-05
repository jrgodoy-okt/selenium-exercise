package saucedemo.pageobject;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckoutStepOnePage extends PageObject {

    @FindBy(id = "first-name")
    WebElementFacade firstNameInput;

    @FindBy(id = "last-name")
    WebElementFacade lastNameInput;


    @FindBy(id = "postal-code")
    WebElementFacade postalCodeInput;

    @FindBy(id = "continue")
    WebElementFacade continueButton;

    public void completeCheckout() {
        firstNameInput.clear();
        firstNameInput.sendKeys("John");
        lastNameInput.clear();
        lastNameInput.sendKeys("Doe");
        postalCodeInput.clear();
        postalCodeInput.sendKeys("1111111");
        continueButton.click();
    }
}
