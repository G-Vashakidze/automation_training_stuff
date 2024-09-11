package org.example.tests;


import org.example.pages.ExeptionsPage;
import org.example.utils.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseTest {
    protected WebDriver driver;
    protected ExeptionsPage exeptionsPage;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver();
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/practice-test-exceptions/");
        exeptionsPage = new ExeptionsPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        WebDriverFactory.quitDriver();
    }


    }


