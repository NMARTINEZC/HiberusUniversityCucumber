package com.hiberus.university.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CarritoPage extends BasePage {



    public CarritoPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
