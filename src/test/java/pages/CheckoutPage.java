package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    private final By TITLE_CHECKOUT = By.xpath("//span[@data-test='title']");
    private final By FIRST_NAME = By.id("first-name");
    private final By LAST_NAME = By.id("last-name");
    private final By POSTAL_CODE = By.id("postal-code");
    private final By BUTTON_CANCEL = By.id("cancel");
    private final By BUTTON_CONTINUE = By.id("continue");
    private final By ERROR = By.xpath("//div[@data-test='data-test='error-button']");


    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public String getTextTitle() {
        return driver.findElement(TITLE_CHECKOUT).getText();
    }

    public void inputCheckoutForm(String firstName, String lastName, String postalCode) {
        driver.findElement(FIRST_NAME).sendKeys(firstName);
        driver.findElement(LAST_NAME).sendKeys(lastName);
        driver.findElement(POSTAL_CODE).sendKeys(postalCode);
    }

    public void clickCancel() {
       driver.findElement(BUTTON_CANCEL).click();
    }
    public void clickContinue() {
        driver.findElement(BUTTON_CONTINUE).click();
    }

    public String getTextError() {
        return driver.findElement(ERROR).getText();
    }
}
