package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;
import utils.Retry;

public class ErrorMessageTest extends BaseTest {

    @Test (description = "Вызов окна ошибки на странице Checkout",
            testName = "Вызов окна ошибки на странице Checkout",
            retryAnalyzer = Retry.class)

    public void errorMessageTest() {
        loginPage.open()
                .isPageOpened()
                .login(user, password);
        productsPage.open()
                .isPageOpened()
                .addToCart("Sauce Labs Fleece Jacket")
                .addToCart("Sauce Labs Bolt T-Shirt")
                .removeFromCart("Sauce Labs Bolt T-Shirt")
                .clickButtonCart();
        cartPage.open()
                .isPageOpened()
                .getCartProductName("Sauce Labs Fleece Jacket");
        cartPage.getCartProductPrice("Sauce Labs Fleece Jacket");
        cartPage.clickButtonContinueShopping();
        productsPage.clickButtonCart();
        cartPage.clickButtonCheckout();
        checkoutPage.open()
                .isPageOpened()
                .inputCheckoutForm("", "","")
                .getTextError();
    }
}
