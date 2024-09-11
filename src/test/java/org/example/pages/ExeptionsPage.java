package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExeptionsPage {
    WebDriver driver;

    @FindBy(xpath = "//div[@id='row1']//input[@type='text']")
    private WebElement inputField;

    @FindBy(xpath = "//div[@id='row2']//input[@type='text']")
    private WebElement secondRowInput;

    @FindBy(xpath = "//button[@id='add_btn']")
    private WebElement addButton;

    @FindBy(xpath = "//div[@id='row2']//button[@id='save_btn']")
    private WebElement saveButton2;

    @FindBy(xpath = "//div[@id='row1']//button[@id='save_btn']")
    private WebElement saveButton1;

    @FindBy(xpath = "//div[@id='row1']//button[@id='edit_btn']")
    private WebElement editButton;

    @FindBy(xpath = "//button[@id='remove_btn']")
    private WebElement removeButton;




    public ExeptionsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getInputField() {
        return inputField;
    }

    public WebElement getSecondRowInput() {
        return secondRowInput;
    }


    public WebElement getAddButton() {
        return addButton;
    }


    public WebElement getSaveButton1() {
        return saveButton1;
    }
    public WebElement getSaveButton2() {
        return saveButton2;
    }


    public WebElement getEditButton() {
        return editButton;
    }


    public WebElement getRemoveButton() {
        return removeButton;
    }

}
