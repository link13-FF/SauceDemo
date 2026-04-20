import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class CartTest {
    @Test
    public void checkCart() {
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("credentials_enable_service", false);
        chromePrefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-infobars");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

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

        System.out.println("Успешно: Товар: " + actualName + " (" + actualPrice + ")");

        driver.quit();
    }
}
