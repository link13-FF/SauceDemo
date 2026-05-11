package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTest;
import utils.Retry;

public class RemoveFromCartTest extends BaseTest {

    @Test (description = "Удаление товара из корзины",
            testName = "Удаление товара из корзины",
            retryAnalyzer = Retry.class)

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
