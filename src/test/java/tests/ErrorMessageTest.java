package tests;

import org.testng.annotations.Test;

public class ErrorMessageTest extends BaseTest {

    @Test

    public void errorMessageTest() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        productsPage.clickButtonAddToCartBackpack();
        productsPage.clickButtonAddToCartTshirt();
        productsPage.clickButtonCart();

        cartPage.clickButtonCheckout();

        checkoutPage.inputCheckoutForm("","","");
        checkoutPage.clickContinue();
    }
}
