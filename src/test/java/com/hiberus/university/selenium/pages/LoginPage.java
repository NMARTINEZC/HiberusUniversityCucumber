package com.hiberus.university.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

    public static final String PAGE_URL="https://www.saucedemo.com/";

    //declaro web elements
    @FindBy(xpath = "//input[@id='user-name']")
    private WebElement usernameInput;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@id='login-button']")
    private WebElement botonLogin;

    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement mensajeError;

     //logOut
    @FindBy(xpath = "//button[@id='react-burger-menu-btn']")
     private WebElement desplegable;

    @FindBy(xpath = "//a[@id='logout_sidebar_link']")
    private WebElement botonlogOut;


    // CONSTRUCTOR
    public LoginPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //acciones de la pagina

    public void enterUserName(String name){
        usernameInput.sendKeys(name);
    }

    public void enterPassword(String password){
        passwordInput.sendKeys(password);
    }

    public void pulsarBotonLogin(){
       botonLogin.click();
    }

    public String getMensajeError(){
        return mensajeError.getText();
    }

    public String getCurrentUrl(){
        return PagesFactory.getInstance().getDriver().getCurrentUrl();}

    //logOut
    public void clickDesplegable(){desplegable.click();}

    public void clickBotonLogout(){botonlogOut.click();}

}
