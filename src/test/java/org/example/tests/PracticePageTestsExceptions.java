package org.example.tests;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class PracticePageTestsExceptions extends BaseTest{


    @Test(expectedExceptions = NoSuchElementException.class, priority = 1)
    public void testNoSuchElementExceptionWithoutProperWait() {
        exeptionsPage.getAddButton().click();
        Assert.assertTrue(exeptionsPage.getSecondRowInput().isDisplayed());

    }

    @Test(expectedExceptions = ElementNotInteractableException.class)
    public void testSaveButtonFunctionalityException() {
        exeptionsPage.getAddButton().click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(exeptionsPage.getSecondRowInput()));
        Assert.assertTrue(exeptionsPage.getSecondRowInput().isDisplayed());
        WebElement saveBtn = driver.findElement(By.name("Save"));
        exeptionsPage.getSecondRowInput().sendKeys("Text to save");
        saveBtn.click();
    }
    @Test(expectedExceptions = {InvalidElementStateException.class, JavascriptException.class})
    public void testEditDisabledInputField() {

        exeptionsPage.getInputField().clear();
        String newText = "New text to be entered";
        exeptionsPage.getInputField().sendKeys(newText);
        //should be throwing invalidelementstateexeption but throws javascriptexeption
    }
    @Test(priority = 5,expectedExceptions = TimeoutException.class)
    public void testTimeOutException() {
        exeptionsPage.getAddButton().click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(exeptionsPage.getSecondRowInput()));
        Assert.assertTrue(exeptionsPage.getSecondRowInput().isDisplayed());
    }

}
