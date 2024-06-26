package org.example.tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class PracticePageTests extends BaseTest{


    @Test()
    public void testNoSuchElementExceptionWithProperWait() {
        exeptionsPage.getAddButton().click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(exeptionsPage.getSecondRowInput()));
        Assert.assertTrue(exeptionsPage.getSecondRowInput().isDisplayed());

    }

    @Test()
    public void testSaveButtonFunctionality() {
        testNoSuchElementExceptionWithProperWait();
        exeptionsPage.getSecondRowInput().sendKeys("Text to save");
        exeptionsPage.getSaveButton2().click();
    }


    @Test()
    public void testEditInputField() {

        exeptionsPage.getEditButton().click();

        exeptionsPage.getInputField().clear();

        String newText = "New text to be entered";
        exeptionsPage.getInputField().sendKeys(newText);

        Assert.assertEquals(exeptionsPage.getInputField().getAttribute("value"), newText);
    }
}