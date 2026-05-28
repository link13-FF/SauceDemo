package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RemoveFromCartTest extends BaseTest{

    @Test
    public void removeFromCart() {

        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        productsPage.clickButtonAddToCartBackpack();
        productsPage.clickButtonAddToCartTshirt();
        productsPage.clickButtonCart();

        cartPage.clickButtonRemove();
        cartPage.clickButtonRemove2();

        Assert.assertTrue(cartPage.checkRemoved());
    }
}
