package saucedemo.pageobject;

import net.thucydides.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject {

    @FindBy(id = "user-name")
    WebElementFacade usernameInput;

    @FindBy(id = "password")
    WebElementFacade passwordInput;

    @FindBy(id = "login-button")
    WebElementFacade loginButton;
    public void loginAsStandardUser() {
        usernameInput.clear();
        usernameInput.sendKeys("standard_user");
        passwordInput.clear();
        passwordInput.sendKeys("secret_sauce");
        loginButton.click();
    }
}
