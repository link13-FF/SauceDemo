package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;
import utils.Retry;

public class CancelTest extends BaseTest {

    @Test (description = "Нажатие кнопки 'Cancel' на странице 'Checkout: Your Information'",
            testName = "Нажатие кнопки 'Cancel' на странице 'Checkout: Your Information'",
            retryAnalyzer = Retry.class)

    public void cancelTest() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        productsPage.clickButtonAddToCartBackpack();
        productsPage.clickButtonAddToCartTshirt();
        productsPage.clickButtonCart();

        cartPage.clickButtonCheckout();

        checkoutPage.inputCheckoutForm("Trafilkin","Valentin","111531");
        checkoutPage.clickCancel();
    }
}
