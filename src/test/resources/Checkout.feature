Feature: Checkout

  Background:
    Given que estoy en la página
    When escribo el username "standard_user"
    And escribo el password "secret_sauce"
    And pulso en el botón del Login

  Scenario: Comprobar el precio final del Checkout de varios productos
    And agrego al carrito los 3 productos elegidos al azar
    And voy al carrito
    And realizo el Checkout del producto
    And relleno los datos del checkout y continuo
    And finalizo Checkout
    Then valido que el precio total del pedido es la suma del importe de los productos seleccionados en el inventario

  Scenario: Realizar un pedido
    And agrego al carrito los 1 productos elegidos al azar
    And voy al carrito
    And realizo el Checkout del producto
    And relleno los datos del checkout y continuo
    And finalizo Checkout
    Then valido que el pedido ha finalizado correctamente mostrando el mensaje "Your order has been dispatched, and will arrive just as fast as the pony can get there!"
