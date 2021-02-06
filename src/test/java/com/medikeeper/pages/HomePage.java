package com.medikeeper.pages;

import com.medikeeper.utilities.Driver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    @FindBy(xpath = "//*[@id='menu-off-canvas']/li[7]/a")
    private WebElement requestADemoButton;


    public void clickOnRequestADemoButton() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(requestADemoButton));

    }

}
