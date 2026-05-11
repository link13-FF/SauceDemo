package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;
import utils.Retry;

public class ContinueTest extends BaseTest {

    @Test (description = "Проверка кнопки 'Continue' на странице 'Cart'",
            testName = "Проверка кнопки 'Continue' на странице 'Cart'",
            retryAnalyzer = Retry.class)

    public void cancelTest() {

        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        productsPage.clickButtonAddToCartBackpack();
        productsPage.clickButtonAddToCartTshirt();
        productsPage.clickButtonCart();
        cartPage.clickButtonContinueShopping();
    }
}
