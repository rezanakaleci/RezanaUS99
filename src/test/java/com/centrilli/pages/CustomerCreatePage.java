package com.centrilli.pages;

import com.centrilli.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerCreatePage {

    public CustomerCreatePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "/div[1]//div[6]/ul[1]/li[3]/a/span  ")
    public WebElement customerButton;

    @FindBy (xpath = "//button[@accesskey='c']")
    public WebElement createButton;

    @FindBy(name = "name")
    public WebElement nameBox;

    @FindBy(name = "street")
    public WebElement addressBox;

    @FindBy(className = "o_input_dropdown")
    public WebElement companyBox;

    @FindBy(xpath = "//button[text()='button']")
    public WebElement saveButton;

    @FindBy(name = "function")
    public WebElement jobPosition;

    @FindBy(xpath = "//button[@accesskey='a']")
    public WebElement editButton;

    public WebElement findingCustomer(String name) {
        String element = "/div/div/div[1]/div/div[3]/h1/span";
        return Driver.getDriver().findElement(By.xpath(element));
    }

  @FindBy(xpath = "//td/div/input[@name='phone']")
    public WebElement phoneNumber;

}
