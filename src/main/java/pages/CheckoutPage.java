package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class CheckoutPage extends BasePage {

    private final By TITLE_CHECKOUT = By.xpath("//span[@data-test='title']");
    private final By FIRST_NAME = By.id("first-name");
    private final By LAST_NAME = By.id("last-name");
    private final By POSTAL_CODE = By.id("postal-code");
    private final By BUTTON_CANCEL = By.id("cancel");
    private final By BUTTON_CONTINUE = By.id("continue");
    private final By ERROR = By.xpath("//h3[@data-test='error']");

    private final String CHECKOUT_URL = "/checkout-step-one.html";


    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public CheckoutPage open() {
        log.info("CheckoutPage Open");
        driver.get(BASE_URL + CHECKOUT_URL);
        return this;
    }

    @Override
    public CheckoutPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(FIRST_NAME));
        return this;
    }

    @Step ("Заполнение информации о покупателе: имя: '{firstName}' фамилия '{lastName}' индекс '{postalCode}'")
    public CheckoutPage inputCheckoutForm(String firstName, String lastName, String postalCode) {
        driver.findElement(FIRST_NAME).sendKeys(firstName);
        driver.findElement(LAST_NAME).sendKeys(lastName);
        driver.findElement(POSTAL_CODE).sendKeys(postalCode);
        return this;
    }

    public void clickCancel() {
        driver.findElement(BUTTON_CANCEL).click();
        new CartPage(driver);
    }

    public void clickContinue() {
        driver.findElement(BUTTON_CONTINUE).click();
        new CheckoutOverviewPage(driver);
    }

    public String getTextError() {
        driver.findElement(BUTTON_CONTINUE).click();
        return driver.findElement(ERROR).getText();
    }
}
