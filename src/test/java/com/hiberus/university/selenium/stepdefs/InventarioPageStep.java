package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.InventarioPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;

import java.util.Random;

public class InventarioPageStep {

    InventarioPage inventarioPage = PagesFactory.getInstance().getInventarioPage();
    Random random = new Random();
    @Then("valido que el numero de productos mostrados es igual a {long}")
    public void valido_que_el_numero_de_productos_mostrados_es_igual_a(long tamañoListaEsperado) {
        Assert.assertEquals("El tamaño de la lista es diferente al esperado: "+tamañoListaEsperado, tamañoListaEsperado, inventarioPage.getListaInventario6().size() );
    }

    @Then("valido que el producto {string} aparece en el inventario")
    public void valido_que_el_producto_aparece_en_el_inventario(String productoEnviadoPorParametro) {
        //validar que el producto aparece en el inventario
        Assert.assertEquals("El nombre del producto no aparece en el inventario", productoEnviadoPorParametro, inventarioPage.getProductoSauceLab().getText());
    }

    @When("agrego al carrito el producto {string}")
    public void agrego_al_carrito_el_producto(String string) {
        inventarioPage.clickBotonAñadirSauceLabCarrito();
    }
    @Then("valido que en el icono del carrito se ha agregado {int} producto")
    public void valido_que_en_el_icono_del_carrito_se_ha_agregado_producto(Integer int1) {

        //crear boleano isdisplayed
        boolean isDisplayed = true;

        //validar que el producto este en el carrito
        try{
            //comprobar visibilidad del artículo
            inventarioPage.isDisplayedVisibilidadDelCarrito();
        }catch (NoSuchElementException e){
            isDisplayed = false;
        }

        Assert.assertTrue("no se ha encontrado el elemento Sauce Lab en el carrito",isDisplayed);

    }

    @When("elimino el producto {string} del carrito")
    public void elimino_el_producto_del_carrito(String string) {
        inventarioPage.clickBotonEliminarSauceLabdelCarrito();
    }
    @Then("valido que en el icono del carrito se ha eliminado el producto")
    public void valido_que_en_el_icono_del_carrito_se_ha_eliminado_el_producto() {

        boolean isDisplayed = true;
        //validar que en el icono del carrito se ha eliminado el producto

        try {
            //comprobar visibilidad del carrito si se ha quitado el producto añadido
            inventarioPage.isDisplayedVisibilidadDelCarrito();
        }
        catch (NoSuchElementException e){
            isDisplayed = false;
        }
        Assert.assertFalse("el icono del carrito sigue siendo visible", isDisplayed);
    }

    @When("agrego al carrito los {int} productos elegidos al azar")
    public void agrego_al_carrito_los_productos_elegidos_al_azar(Integer numeroDeProductosPorParametro) {
        //Hago un bucle para añadir al carrito tres productos al azar
        for (int i = 0; i < numeroDeProductosPorParametro; i++) {
            inventarioPage.getListaInventarioAddToCart().get(random.nextInt(inventarioPage.getListaInventarioAddToCart().size())).click();
        }
    }

    @Then("valido que en el icono del carrito se han agregado los {string} productos")
    public void valido_que_en_el_icono_del_carrito_se_han_agregado_los_productos(String numeroSpan) {
        Assert.assertEquals("el numero obtenido no es el esperado", numeroSpan,inventarioPage.getTextSpanCarrito());
    }

    @When("selecciono el filtro {string}")
    public void selecciono_el_filtro(String filtro) {
        inventarioPage.clickBotonMenuFiltro(filtro);
    }
    @Then("valido que el filtro seleccionado, ordena por el orden alfabético de la Z a la A")
    public void valido_que_el_filtro_seleccionado_ordena_por_el_orden_alfabético_de_la_z_a_la_a() {

    }

    @Then("valido que el filtro seleccionado, ordena por el orden de precio de menor a mayor")
    public void valido_que_el_filtro_seleccionado_ordena_por_el_orden_de_precio_de_menor_a_mayor() {

    }


}
