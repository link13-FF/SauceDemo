package tests;

import org.testng.annotations.Test;

public class ContinueTest extends BaseTest {

    @Test
    public void cancelTest() {

        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        productsPage.clickButtonAddToCartBackpack();
        productsPage.clickButtonAddToCartTshirt();
        productsPage.clickButtonCart();
        cartPage.clickButtonContinueShopping();
    }
}
