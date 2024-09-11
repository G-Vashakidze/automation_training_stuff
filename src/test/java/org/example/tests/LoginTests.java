package org.example.tests;

import com.codeborne.selenide.Selenide;
import org.example.pages.LoginPage;
import org.example.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LoginTests {

    private WebDriver driver;
    private LoginPage loginPage;
    public void logIn(String username, String password) {
        loginPage.login(username, password);
    }

    @BeforeClass
    public void setUp() {
        driver = WebDriverFactory.getDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://practicetestautomation.com/practice-test-login/");
        loginPage = new LoginPage(driver);
        driver.manage().window().maximize();
    }

    @Test(dataProvider = "positiveLoginData")
    public void testPositiveLogin(String username, String password) {
        logIn(username,password);
        Assert.assertTrue(driver.getCurrentUrl().contains("practicetestautomation.com/logged-in-successfully/"));
        WebElement logoutButton = driver.findElement(By.xpath("//a[@class='wp-block-button__link has-text-color has-background has-very-dark-gray-background-color']"));
        logoutButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(loginPage.getUsername()));

    }

    @Test(dataProvider = "negativeLoginData")
    public void testLogInNegative(String username, String password, String expectedErrorMessage){
        logIn(username, password);
        Selenide.sleep(2000);
        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
        Assert.assertEquals(loginPage.getErrorMessageText(), expectedErrorMessage);
    }

    @DataProvider(name = "negativeLoginData")
    public Object[][] negativeLoginData() {
        return new Object[][] {
                {"incorrectUser", "Password123", "Your username is invalid!"},
                {"student", "incorrectPassword", "Your password is invalid!"}
        };
    }

    @DataProvider(name = "positiveLoginData")
    public Object[][] positiveLoginData() {
        return new Object[][] {
                {"student", "Password123"},

        };
    }

    @AfterClass
    public void tearDown() {
        WebDriverFactory.quitDriver();
    }
}
