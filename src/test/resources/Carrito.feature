Feature: Carrito

  Scenario: Eliminar producto desde el carrito
    Given que estoy en la página
    When escribo el username "standard_user"
    And escribo el password "secret_sauce"
    And pulso en el botón del Login
    And agrego al carrito 2 productos elegidos al azar
    And voy al carrito
    And elimino uno de los productos
    Then valido que el producto eliminado no aparece en el carrito