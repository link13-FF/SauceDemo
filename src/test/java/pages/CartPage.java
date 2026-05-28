package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private final By PRODUCT_NAME_BACKPACK = By.id("item_4_title_link");
    private final By PRODUCT_NAME_TSHIRT = By.id("item_1_title_link");
    private final By COST_BACKPACK = By.xpath("(//div[@data-test='inventory-item-price'])[1]");
    private final By COST_TSHIRT = By.xpath("(//div[@data-test='inventory-item-price'])[2]");
    private final By DESCRIPTION_BACKPACK = By.xpath("//div[@data-test='inventory-item-desc']");
    private final By DESCRIPTION_TSHIRT = By.xpath("(//div[@data-test='inventory-item-desc'])[2]");

    private final By TITLE_BASKET = By.xpath("//*[@data-test='title']");
    private final By BUTTON_REMOVE = By.id("remove-sauce-labs-backpack");
    private final By BUTTON_REMOVE2 = By.id("remove-sauce-labs-bolt-t-shirt");
    private final By EMPTY_BASKET = By.xpath("//*[@class='removed_cart_item']");
    private final By BUTTON_CONTINUE_SHOPPING = By.id("continue-shopping");
    private final By BUTTON_CHECKOUT = By.id("checkout");

    public CartPage(WebDriver driver) {
        super(driver);
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

    public String getTitleBasket() {
        return driver.findElement(TITLE_BASKET).getText();
    }

    public void clickButtonRemove() {
        driver.findElement(BUTTON_REMOVE).click();
    }
    public void clickButtonRemove2() {
        driver.findElement(BUTTON_REMOVE2).click();
    }

    public void clickButtonContinueShopping() {
        driver.findElement(BUTTON_CONTINUE_SHOPPING).click();
    }

    public void clickButtonCheckout() {
        driver.findElement(BUTTON_CHECKOUT).click();
    }

    public boolean checkRemoved() {
        return driver.findElements(EMPTY_BASKET).size() > 0;
    }
}
