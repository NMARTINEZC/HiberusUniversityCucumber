package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.InventarioPage;
import com.hiberus.university.selenium.pages.LoginPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginPageSteps {

    LoginPage loginPage = PagesFactory.getInstance().getLoginPage();
    @Given("que estoy en la página")
    public void que_estoy_en_la_página() {
        loginPage.navigateTo(LoginPage.PAGE_URL);
    }
    @When("escribo el username {string}")
    public void escriboElUsernameUser(String name) {
        loginPage.enterUserName(name);
    }
    @And("escribo el password {string}")
    public void escriboElPasswordPassword(String password) {
        loginPage.enterPassword(password);
    }
    @When("pulso en el botón del Login")
    public void pulso_en_el_botón_del_login() {
        loginPage.pulsarBotonLogin();
    }
    @Then("valido que he accedido correctamente a la página")
    public void valido_que_he_accedido_correctamente_a_la_página() {
        Assert.assertEquals("La url no es la esperada", loginPage.getCurrentUrl(), InventarioPage.INVENTORY_URL);
    }
    @Then("valido que aparece el mensaje de error")
    public void valido_que_aparece_el_mensaje_de_error() {
        Assert.assertEquals("El mensaje de error no es el esperado", loginPage.getMensajeError(), "Epic sadface: Username and password do not match any user in this service");
    }
    //logout

    //acciones
    @When("realizo el Logout")
    public void realizo_el_logout() {
        loginPage.clickDesplegable();
        loginPage.clickBotonLogout();
    }
    @Then("valido que el logout se ha realizado llevándome a la página del Login")
    public void valido_que_el_logout_se_ha_realizado_llevándome_a_la_página_del_login() {
        Assert.assertEquals("logOut incorrecto", loginPage.PAGE_URL, loginPage.getCurrentUrl());
    }
}

