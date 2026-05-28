package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTest;
import utils.Retry;

public class CartTest extends BaseTest {

    @Test (description = "Добавление товара в корзину",
            testName = "Добавление товара в корзину",
            retryAnalyzer = Retry.class)

    public void checkCart() {

        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        //Сохраняем данные товара
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
    }
}
