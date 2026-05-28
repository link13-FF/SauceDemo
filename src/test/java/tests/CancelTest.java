package tests;

import org.testng.annotations.Test;

public class CancelTest extends BaseTest {

    @Test

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
