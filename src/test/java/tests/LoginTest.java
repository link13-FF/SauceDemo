package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.base.BaseTest;
import utils.Retry;

public class LoginTest extends BaseTest {
    @Test (priority = 1,
            description = "проверка входа в систему с позитивными значениями",
            testName = "проверка входа в систему с позитивными значениями",
            groups = {"smoke"},
            retryAnalyzer = Retry.class)
            /*dependsOnMethods = "checkLoginWithNegativeCred",
            invocationCount = 2,
            threadPoolSize = 2
             */
    public void checkLoginWithPositiveValue() {

        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertEquals(productsPage.getTitle(), "Products");

    }

    @Test (priority = 3,
            description = "Проверка входа с пустым паролем",
            testName = "Проверка входа с пустым паролем",
            groups = {"regression"})
    public void checkLoginWithEmptyPassword() {
        loginPage.open();
        loginPage.login("standard_user", "");
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Password is required");
    }

    @Test (priority = 4,
            description = "Проверка входа с пустым логином",
            testName = "Проверка входа с пустым логином",
            groups = {"regression"})
    public void checkLoginWithEmptyUser() {
        loginPage.open();
        loginPage.login("", "secret_sauce");
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username is required");
    }

    @Test (priority = 2,
            description = "Проверка входа в систему с негативными значениями",
            testName = "Проверка входа в систему с негативными значениями",
            groups = {"regression"})
    public void checkLoginWithNegativeCred() {
        loginPage.open();
        loginPage.login("standard_user123", "secret_sauce123");
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username and password do not " +
                "match any user in this service");
    }

    @DataProvider(name = "Тестовые данные для негативного теста")
    public Object [][] loginData() {
        return new Object[][]{
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"standard_user123", "secret_sauce123", "Epic sadface: Username and password do not " +
                        "match any user in this service"},
                {"standard_user", "", "Epic sadface: Password is required"}
        };
    }

    @Test (dataProvider = "Тестовые данные для негативного теста")
    public void negativeLogin(String user, String password, String errorMessage) {
        loginPage.open();
        loginPage.login(user, password);
        Assert.assertEquals(loginPage.getErrorMessage(), errorMessage);
    }
}

