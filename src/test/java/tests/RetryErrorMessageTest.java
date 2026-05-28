package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;
import utils.Retry;

public class RetryErrorMessageTest extends BaseTest {

    @Test (description = "Вызов окна ошибки на странице Checkout",
            testName = "Вызов окна ошибки на странице Checkout",
            retryAnalyzer = Retry.class)

    public void errorMessageTest() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauc");

        productsPage.clickButtonAddToCartBackpack();
        productsPage.clickButtonAddToCartTshirt();
        productsPage.clickButtonCart();

        cartPage.clickButtonCheckout();

        checkoutPage.inputCheckoutForm("","","");
        checkoutPage.clickContinue();
    }
}
