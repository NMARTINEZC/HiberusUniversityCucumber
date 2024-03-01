Feature: LogOut

  Scenario: Comprobar el Logout
    Given que estoy en la página
    When escribo el username "standard_user"
    And escribo el password "secret_sauce"
    And pulso en el botón del Login
    And realizo el Logout
    Then valido que el logout se ha realizado llevándome a la página del Login