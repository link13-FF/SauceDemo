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

        loginPage.open()
                .isPageOpened()
                .login(user, password);
        productsPage.open()
                .isPageOpened()
                .addToCart("Sauce Labs Fleece Jacket")
                .addToCart("Sauce Labs Bolt T-Shirt")
                .removeFromCart("Sauce Labs Bolt T-Shirt");
    }
}
