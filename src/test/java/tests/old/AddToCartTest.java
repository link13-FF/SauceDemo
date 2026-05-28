package tests.old;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import tests.base.BaseTest;

public class AddToCartTest extends BaseTest {

    @Test
    public void addCart() {
        SoftAssert softAssert = new SoftAssert();

        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        String expectedName = productsPage.getProductNameBackpack();
        String expectedName2 = productsPage.getProductNameTshirt();
        String expectedPrice = productsPage.getCostOfBackpack();
        String expectedPrice2 = productsPage.getCostOfTshirt();
        String expectedDescription = productsPage.getDescriptionBackpack();
        String expectedDescription2 = productsPage.getDescriptionTshirt();

        productsPage.clickButtonAddToCartBackpack();
        productsPage.clickButtonAddToCartTshirt();
        productsPage.clickButtonCart();

        cartPage.getTitleBasket();

        String nameInCart = cartPage.getProductNameBackpack();
        softAssert.assertEquals(expectedName, nameInCart);
        String nameInCart2 = cartPage.getProductNameTshirt();
        softAssert.assertEquals(expectedName2, nameInCart2);

        String descriptionCart = cartPage.getDescriptionBackpack();
        softAssert.assertEquals(expectedDescription, descriptionCart);
        String descriptionCart2 = cartPage.getDescriptionTshirt();
        softAssert.assertEquals(expectedDescription2, descriptionCart2);

        String costCart = cartPage.getCostOfBackpack();
        softAssert.assertEquals(costCart, expectedPrice);
        String costCart2 = cartPage.getCostOfTshirt();
        softAssert.assertEquals(costCart2, expectedPrice2);

        softAssert.assertAll();
    }
}
