package com.medikeeper.pages;

import com.medikeeper.utilities.Driver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    protected WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 35);


}