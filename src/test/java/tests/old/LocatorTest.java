package tests.old;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import tests.base.BaseTest;

public class LocatorTest extends BaseTest {
    @Test
    public void checkLocator() {

        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        //name
        driver.findElement(By.name("add-to-cart-sauce-labs-bike-light"));
        //classname
        driver.findElement(By.className("shopping_cart_container"));
        //tagname
        driver.findElement(By.tagName("button"));
        //linktext
        driver.findElement(By.linkText("Sauce Labs Bike Light"));
        //partiallinktext
        driver.findElement(By.partialLinkText("Bike Light"));

        //xpath:
        //- поиск по атрибуту, например: By.xpath("//tag[@attribute='value']");
        driver.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-bike-light']"));
        //поиск по тексту, например: By.xpath("//tag[text()='text']");
        driver.findElement(By.xpath("//div[text()='Sauce Labs Bike Light']"));
        //поиск по частичному совпадению атрибута, например: By.xpath("//tag[contains(@attribute,'text')]");
        driver.findElement(By.xpath("//div[contains(@class,'butto')]"));
        //поиск по частичному совпадению текста, например: By.xpath("//tag[contains(text(),'text')]");
        driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Bike')]"));
        //ancestor, например //*[text()='Enterprise Testing']//ancestor::div
        driver.findElement(By.xpath("//*[text()='Sauce Labs Bike Light']//ancestor::div"));
        //descendant
        driver.findElement(By.xpath("//*[@id='item_0_title_link']//descendant::div"));
        //following
        driver.findElement(By.xpath("//*[@id='item_0_title_link']//following::div"));
        //parent
        driver.findElement(By.xpath("//*[text()='Sauce Labs Bike Light']//parent::div"));
        //preceding
        driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Bike')]//preceding::a"));
        //поиск элемента с условием AND, например //input[@class='_2zrpKA_1dBPDZ' and @type='text']
        driver.findElement(By.xpath("//div[@data-test='inventory-item-desc' and contains(text(),'when riding your bike at night. Water-resistant with 3 lighting modes')]"));

        //css:
        //.class
        driver.findElement(By.cssSelector(".shopping_cart_container"));
        //.class1.class2
        driver.findElement(By.cssSelector(".btn_primary.btn_inventory"));
        //.class1 .class2
        driver.findElement(By.cssSelector(".shopping_cart_container .shopping_cart_link"));
        //#id
        driver.findElement(By.cssSelector(".inventory_container"));
        //tagname
        driver.findElement(By.cssSelector("button"));
        //tagname.class
        driver.findElement(By.cssSelector("footer"));
        //[attribute=value]
        driver.findElement(By.cssSelector("[data-test='add-to-cart-sauce-labs-bike-light']"));
        //[attribute~=value]
        driver.findElement(By.cssSelector("[class~='btn']"));
        //[attribute|=value]
        driver.findElement(By.cssSelector("[lang|='en']"));
        //[attribute^=value]
        driver.findElement(By.cssSelector("[href^='https']"));
        //[attribute$=value]
        driver.findElement(By.cssSelector("[id$=light]"));
        //[attribute*=value]
        driver.findElement(By.cssSelector("[name*=sauce]"));
    }
}