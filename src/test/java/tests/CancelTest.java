package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;
import utils.Retry;

public class CancelTest extends BaseTest {

    @Test (description = "Нажатие кнопки 'Cancel' на странице 'Checkout: Your Information'",
            testName = "Нажатие кнопки 'Cancel' на странице 'Checkout: Your Information'",
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
        productsPage.clickButtonCart();
        cartPage.clickButtonCheckout();
        checkoutPage.open()
                .isPageOpened()
                .inputCheckoutForm("AAAA", "BBBB","112233")
                .clickCancel();
        }
}
