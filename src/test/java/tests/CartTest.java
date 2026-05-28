package tests;


import org.testng.annotations.Test;
import tests.base.BaseTest;

public class CartTest extends BaseTest {

    @Test (description = "Добавление товара в корзину",
            testName = "Добавление товара в корзину")
            //retryAnalyzer = Retry.class)

    public void checkCart() {

        loginPage.open()
                .isPageOpened()
                .login("standard_user", "secret_sauce");
        productsPage.open()
                .isPageOpened()
                .addToCart("Sauce Labs Fleece Jacket")
                .addToCart("Sauce Labs Bolt T-Shirt")
                .removeFromCart("Sauce Labs Bolt T-Shirt")
                .clickButtonCart();
        cartPage.open()
                .isPageOpened()
                .getCartProductName("Sauce Labs Fleece Jacket");
        cartPage.getCartProductPrice("Sauce Labs Fleece Jacket");
        /*
        Сохраняем данные товара
        String expectedName = driver.findElement(By.cssSelector(".inventory_item_name")).getText();
        String expectedPrice = driver.findElement(By.cssSelector(".inventory_item_price")).getText();

        //Добавление товара в корзину
        driver.findElement(By.xpath("//button[contains(text(), 'Add to cart')]")).click();

        //Переход в корзину
        driver.findElement(By.cssSelector(".shopping_cart_link")).click();

        //Проверка названия товара и стоимости
        String actualName = driver.findElement(By.cssSelector(".inventory_item_name")).getText();
        String actualPrice = driver.findElement(By.cssSelector(".inventory_item_price")).getText();

        Assert.assertEquals(actualName, expectedName, "Название товара не совпадает");
        Assert.assertEquals(actualPrice, expectedPrice, "Стоимость товара не совпадает");
         */
    }
}
