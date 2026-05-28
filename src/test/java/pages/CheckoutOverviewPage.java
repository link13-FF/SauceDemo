package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage extends BasePage{

    private final By TITLE_CHECKOUT_OVERVIEW = By.xpath("//span[@data-test='title']");
    private final By ITEM_NAME = By.xpath("//div[@data-test='inventory-item-name']");
    private final By ITEM_NAME2 = By.xpath("(//div[@data-test='inventory-item-name'])[2]");
    private final By DESCRIPTION_ITEM = By.xpath("//div[@data-test='inventory-item-desc']");
    private final By DESCRIPTION_ITEM2 = By.xpath("(//div[@data-test='inventory-item-desc'])[2]");
    private final By PRICE_ITEM = By.xpath("//div[@data-test='inventory-item-price']");
    private final By PRICE_ITEM2 = By.xpath("(//div[@data-test='inventory-item-price'])[2]");

    private final By PAYMENT_INFO = By.xpath("//div[@data-test='payment-info-value']");
    private final By SHIPPING_INFO = By.xpath("//div[@data-test='shipping-info-value']");
    private final By SUBTOTAL_PRICE = By.xpath("//div[@data-test='subtotal-label']");
    private final By TAX = By.xpath("//div[@data-test='tax-label']");
    private final By TOTAL_PRICE = By.xpath("//div[@data-test='total-label']");

    private final By BUTTON_CANCEL = By.id("cancel");
    private final By BUTTON_FINISH = By.id("finish");

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    public String getTitleCheckoutOverview() {
        return driver.findElement(TITLE_CHECKOUT_OVERVIEW).getText();
    }

    public String getItemName() {
        return driver.findElement(ITEM_NAME).getText();
    }

    public String getItemName2() {
        return driver.findElement(ITEM_NAME2).getText();
    }

    public String getDescriptionItem() {
        return driver.findElement(DESCRIPTION_ITEM).getText();
    }

    public String getDescriptionItem2() {
        return driver.findElement(DESCRIPTION_ITEM2).getText();
    }

    public String getPriceItem() {
        return driver.findElement(PRICE_ITEM).getText();
    }

    public String getPriceItem2() {
        return driver.findElement(PRICE_ITEM2).getText();
    }

    public String getPaymentInfo() {
        return driver.findElement(PAYMENT_INFO).getText();
    }

    public String getShipping() {
        return driver.findElement(SHIPPING_INFO).getText();
    }

    public String getSubTotal() {
        return driver.findElement(SUBTOTAL_PRICE).getText();
    }

    public String getTax() {
        return driver.findElement(TAX).getText();
    }

    public String getTotalPrice() {
        return driver.findElement(TOTAL_PRICE).getText();
    }

    public void clickButtonCancel() {
        driver.findElement(BUTTON_CANCEL).click();
    }

    public void clickButtonFinish() {
        driver.findElement(BUTTON_FINISH).click();
    }
}
