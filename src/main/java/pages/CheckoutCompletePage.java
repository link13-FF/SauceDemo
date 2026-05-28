package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class CheckoutCompletePage extends BasePage{

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }
    
    private final String CHECKOUT_COMPLETE_URL = "checkout-complete.html";
    private final By BUTTON_BACK = By.id("back-to-products");
    
    @Override
    public CheckoutCompletePage open() {
        log.info("Checkout Complete Open");
        driver.get(BASE_URL + CHECKOUT_COMPLETE_URL);
        return this;
    }

    @Override
    public CheckoutCompletePage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(BUTTON_BACK));
        return this;
    }

    @Step ("Возврат на страницу с товарами")
    public ProductsPage clickButtonBackHome () {
        driver.findElement(BUTTON_BACK).click();
        return new ProductsPage(driver);
    }
}
