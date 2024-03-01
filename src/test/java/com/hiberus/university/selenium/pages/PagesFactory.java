package com.hiberus.university.selenium.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;

@Getter
public class PagesFactory {
  private static PagesFactory pagesFactories;
  private final WebDriver driver;
  private final LoginPage loginPage;
  private final InventarioPage inventarioPage;


  private PagesFactory(WebDriver driver) {
    this.driver = driver;
    loginPage = new LoginPage(driver);
    inventarioPage = new InventarioPage(driver);
  }

  public static void start(WebDriver driver) {
    pagesFactories = new PagesFactory(driver);
  }

  public static PagesFactory getInstance() {
    return pagesFactories;
  }

  public WebDriver getDriver() {
    return driver;
  }
}
