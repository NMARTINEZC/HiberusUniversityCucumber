package com.hiberus.university.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class InventarioPage extends BasePage{

    public static final String INVENTORY_URL="https://www.saucedemo.com/inventory.html";

    @FindBy(xpath = "//div[@class='inventory_list']/child::div")
    private List<WebElement> listaInventario6;

    @FindBy(xpath = "//div[@class='inventory_list']/descendant::button[@class='btn btn_primary btn_small btn_inventory ']")
    private List<WebElement> listaAddToCart;

    @FindBy(xpath = "//div[@class='inventory_list']/descendant::div[@class='inventory_item_name ' and text() = 'Sauce Labs Bolt T-Shirt']")
    private WebElement productoSauceLab;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")
    private WebElement botonAñadirSauceLabCarrito;

    @FindBy(xpath = "//button[@id='remove-sauce-labs-bolt-t-shirt']")
    private WebElement botonEliminarSauceLabdelCarrito;

    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    private WebElement visibilidadDelCarrito;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElement botonCarrito;

    @FindBy(xpath = "//select[@class='product_sort_container']")
    private  WebElement botonMenuFiltro;

    @FindBy(xpath = "//div[@class='inventory_list']/descendant::div[@class='inventory_item_name ' and text()]")
    private List<WebElement> ListadoZtoA;

    @FindBy(xpath = "//div[@class='inventory_list']/descendant::div[@class='inventory_item_price' and text()]")
    private List<WebElement> ListadoDePrecios;


    // CONSTRUCTOR
    public InventarioPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // acciones de la página

    public void clickBotonCarrito(){botonCarrito.click();}

    public void clickBotonAñadirSauceLabCarrito(){botonAñadirSauceLabCarrito.click();}

    public void clickBotonEliminarSauceLabdelCarrito(){botonEliminarSauceLabdelCarrito.click();}

    public void clickBotonMenuFiltro(String nombreFiltro){
        Select select = new Select(botonMenuFiltro);
        select.selectByVisibleText(nombreFiltro);
    }

    public List<WebElement>ListadoZtoA(){return ListadoZtoA;}

    public List<WebElement> ListadoDePrecios(){return ListadoDePrecios;}

    public List<WebElement> getListaInventario6(){return listaInventario6;}

    public List<WebElement> getListaInventarioAddToCart(){return listaAddToCart;}

    public WebElement getProductoSauceLab(){return productoSauceLab;}

    public boolean isDisplayedVisibilidadDelCarrito(){return visibilidadDelCarrito.isDisplayed();}

    public String getTextSpanCarrito(){return visibilidadDelCarrito.getText();}


}



