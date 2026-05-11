package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import tests.base.BaseTest;
import utils.Retry;

public class CheckoutTest extends BaseTest {

    @Test (description = "E2E оформление покупки",
            testName = "E2E оформление покупки",
            retryAnalyzer = Retry.class)

    public void checkoutTest() {

        SoftAssert softAssert = new SoftAssert();

        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        productsPage.clickButtonAddToCartBackpack();
        productsPage.clickButtonAddToCartTshirt();
        productsPage.clickButtonCart();

        cartPage.clickButtonCheckout();

        checkoutPage.inputCheckoutForm("Trafilkin","Valentin","111531");
        checkoutPage.clickContinue();

        String actualName = cartPage.getProductNameBackpack();
        String expectedName = checkoutOverviewPage.getItemName();
        softAssert.assertEquals(actualName, expectedName);
        String actualName2 = cartPage.getProductNameTshirt();
        String expectedName2 = checkoutOverviewPage.getItemName2();
        softAssert.assertEquals(actualName2, expectedName2);

        String actualDesc = cartPage.getDescriptionBackpack();
        String expectedDesc = checkoutOverviewPage.getDescriptionItem();
        softAssert.assertEquals(actualDesc, expectedDesc);
        String actualDesc2 = cartPage.getDescriptionTshirt();
        String expectedDesc2 = checkoutOverviewPage.getDescriptionItem2();
        softAssert.assertEquals(actualDesc2, expectedDesc2);

        String actualPrice = cartPage.getCostOfBackpack();
        String expectedPrice = checkoutOverviewPage.getPriceItem();
        String actualPrice2 = cartPage.getCostOfTshirt();
        String expectedPrice2 = checkoutOverviewPage.getPriceItem2();
        softAssert.assertEquals(actualPrice2, expectedPrice2);

        //Эту часть решил через ИИ, так как оформляется 2 товара.
        double price1 = Double.parseDouble(expectedPrice.replaceAll("[^\\d.]", ""));
        double price2 = Double.parseDouble(expectedPrice2.replaceAll("[^\\d.]", ""));
        double calculatedTotal = price1 + price2;
        String subtotalText = checkoutOverviewPage.getSubTotal();
        double subtotalValue = Double.parseDouble(subtotalText.replaceAll("[^\\d.]", "").trim());
        softAssert.assertEquals(subtotalValue, calculatedTotal);

        String expectedTax = checkoutOverviewPage.getTax();
        String expectedTotal = checkoutOverviewPage.getTotalPrice();
        double tax = Double.parseDouble(expectedTax.replaceAll("[^\\d.]", ""));
        double totalPrice = Double.parseDouble(expectedTotal.replaceAll("[^\\d.]", ""));
        double calculatedTotalPrice = tax + subtotalValue;
        softAssert.assertEquals(totalPrice, calculatedTotalPrice);

        checkoutOverviewPage.getTitleCheckoutOverview();

        checkoutOverviewPage.clickButtonFinish();

        String titleComplete = checkoutOverviewPage.getTitleCheckoutOverview();
        String expectedTitle = "Checkout: Complete!";
        Assert.assertEquals(titleComplete,expectedTitle);
        softAssert.assertAll();
    }
}