Feature: Inventario

  Background:
    Given que estoy en la página
    When escribo el username "standard_user"
    And escribo el password "secret_sauce"
    And pulso en el botón del Login

  Scenario: Validar que el numero de resultados es 6
    Then valido que el numero de productos mostrados es igual a 6

  Scenario: Validar que existe el producto Sauce Labs Bolt T-Shirt en el inventario
    Then valido que el producto "Sauce Labs Bolt T-Shirt" aparece en el inventario

  Scenario: Añadir el producto Sauce Labs Bolt T-Shirt al carrito
    And agrego al carrito el producto "Sauce Labs Bolt T-Shirt"
    Then valido que en el icono del carrito se ha agregado 1 producto

  Scenario: Eliminar producto del carrito desde el inventario
    And agrego al carrito el producto "Sauce Labs Bolt T-Shirt"
    And elimino el producto "Sauce Labs Bolt T-Shirt" del carrito
    Then valido que en el icono del carrito se ha eliminado el producto

  Scenario: Agregar al carrito 3 productos al azar
    And agrego al carrito los 3 productos elegidos al azar
    Then valido que en el icono del carrito se han agregado los "3" productos

  Scenario: Ordenar el inventario por orden alfabético (Z a la A)
    And selecciono el filtro "NAME (Z TO A)"
    Then valido que el filtro seleccionado, ordena por el orden alfabético de la Z a la A

  Scenario: Ordenar el inventario por precio de Menor a Mayor
    And selecciono el filtro "PRICE (low to high)"
    Then valido que el filtro seleccionado, ordena por el orden de precio de menor a mayor