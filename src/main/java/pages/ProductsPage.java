package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

//@Log4j
public class ProductsPage extends BasePage {

    private final By BUTTON_ADD_TO_CART_BACKPACK = By.id("add-to-cart-sauce-labs-backpack");
    private final By BUTTON_ADD_TO_CART_TSHIRT = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    private final By PRODUCT_NAME_BACKPACK = By.id("item_4_title_link");
    private final By PRODUCT_NAME_TSHIRT = By.id("item_1_title_link");
    private final By COST_BACKPACK = By.xpath("//div[@data-test='inventory-item-price']");
    private final By COST_TSHIRT = By.xpath("(//div[@data-test='inventory-item-price'])[3]");
    private final By DESCRIPTION_BACKPACK = By.xpath("//div[@data-test='inventory-item-desc']");
    private final By DESCRIPTION_TSHIRT = By.xpath("(//div[@data-test='inventory-item-desc'])[3]");

    private final By TITLE = By.cssSelector("[data-test=title]");
    private final By BUTTON_CART = By.xpath("//a[@data-test='shopping-cart-link']");
    private final String PRODUCT_PAGE_URL = "/inventory.html";
    private final String ADD_TO_CART_PATTERN =
            "//*[text()='%s']/ancestor::div[@class='inventory_item']//button[text()='Add to cart']";
    private final String REMOVE_ITEM_TO_CART =
            "//*[text()='%s']/ancestor::div[@class='inventory_item']//button[text()='Remove']";



    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step ("Открытие страницы с товарами")
    public ProductsPage open() {
        driver.get(BASE_URL + PRODUCT_PAGE_URL);
        return this;
    }

    @Override
    public ProductsPage isPageOpened() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE));
        return this;
    }

    @Step ("Добавление товара с именем '{product}' в корзину")
    public ProductsPage addToCart(String product) {
        //log.info("Added in cart product name '{}'", product);
        driver.findElement(By.xpath(String.format(ADD_TO_CART_PATTERN, product))).click();
        return this;
    }

    @Step ("Добавление товара с именем '{product}' в корзину")
    public ProductsPage removeFromCart(String product) {
        //log.info("Remove from cart product name '{}'", product);
        driver.findElement(By.xpath(String.format(REMOVE_ITEM_TO_CART, product))).click();
        return this;
    }

    @Step ("Клик/Переход на страницу корзина")
    public void clickButtonCart() {
        driver.findElement(BUTTON_CART).click();
    }
}
