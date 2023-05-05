package saucedemo.pageobject;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckoutStepTwoPage extends PageObject {
    List<WebElementFacade> cartItems;

    @FindBy(xpath = "//div[@class='summary_info']/div[contains(@class, 'summary_')]")
    List<WebElementFacade> summaryItems;
    @FindBy(id = "finish")
    WebElementFacade finishButton;

    @FindBy(className = "summary_subtotal_label")
    WebElementFacade subtotalLabel;
    public void checkTotalPrice(SoftAssertions softAssert) {
        double expectedTotalPrice = 0.0;
        cartItems = findAll(By.className("cart_item"));
        for(WebElementFacade item : cartItems) {
            expectedTotalPrice += getItemQuantity(item) * getItemPrice(item);
        }

        double actualTotalPrice = Double.valueOf(
                subtotalLabel.getText().split(":")[1].substring(2)
        );
        recordOrderDetail();
        softAssert.assertThat(expectedTotalPrice).isEqualTo(actualTotalPrice);
    }

    private void recordOrderDetail() {
        String description = "";
        for(WebElement element : summaryItems) {
            description += "\n" + element.getText();
        }
        Serenity.recordReportData().withTitle("Order detail: ").andContents(description);
    }

    public void finishCheckout() {
        finishButton.click();
    }

    private double getItemPrice(WebElementFacade item) {
        return Double.valueOf(
                item.find(By.className("inventory_item_price")).getText().substring(1)
        );
    }

    private int getItemQuantity(WebElementFacade item) {
        return Integer.parseInt(
                item.find(By.className("cart_quantity")).getText()
        );
    }
}
