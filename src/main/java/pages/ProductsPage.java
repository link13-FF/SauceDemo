package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    private final By TITLE = By.cssSelector("[data-test=title]");
    private final By BUTTON_CART = By.xpath("//a[@data-test='shopping-cart-link']");
    private final By BUTTON_ADD_TO_CART_BACKPACK = By.id("add-to-cart-sauce-labs-backpack");
    private final By BUTTON_ADD_TO_CART_TSHIRT = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    private final By PRODUCT_NAME_BACKPACK = By.id("item_4_title_link");
    private final By PRODUCT_NAME_TSHIRT = By.id("item_1_title_link");
    private final By COST_BACKPACK = By.xpath("//div[@data-test='inventory-item-price']");
    private final By COST_TSHIRT = By.xpath("(//div[@data-test='inventory-item-price'])[3]");
    private final By DESCRIPTION_BACKPACK = By.xpath("//div[@data-test='inventory-item-desc']");
    private final By DESCRIPTION_TSHIRT = By.xpath("(//div[@data-test='inventory-item-desc'])[3]");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL + "/inventory.html");
    }

    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }

    public void clickButtonCart() {
        driver.findElement(BUTTON_CART).click();
    }

    public void clickButtonAddToCartBackpack() {
        driver.findElement(BUTTON_ADD_TO_CART_BACKPACK).click();
    }

    public void clickButtonAddToCartTshirt() {
        driver.findElement(BUTTON_ADD_TO_CART_TSHIRT).click();
    }

    public String getProductNameBackpack() {
        return driver.findElement(PRODUCT_NAME_BACKPACK).getText();
    }

    public String getProductNameTshirt() {
        return driver.findElement(PRODUCT_NAME_TSHIRT).getText();
    }

    public String getCostOfBackpack() {
        return driver.findElement(COST_BACKPACK).getText();
    }

    public String getCostOfTshirt() {
        return driver.findElement(COST_TSHIRT).getText();
    }

    public String getDescriptionBackpack() {
        return driver.findElement(DESCRIPTION_BACKPACK).getText();
    }

    public String getDescriptionTshirt() {
        return driver.findElement(DESCRIPTION_TSHIRT).getText();
    }
}
