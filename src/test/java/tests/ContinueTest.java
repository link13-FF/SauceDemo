package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;
import utils.Retry;

public class ContinueTest extends BaseTest {

    @Test (description = "Проверка кнопки 'Continue' на странице 'Cart'",
            testName = "Проверка кнопки 'Continue' на странице 'Cart'",
            retryAnalyzer = Retry.class)

    public void cancelTest() {

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
    }
}
