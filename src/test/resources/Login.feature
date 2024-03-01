Feature: Login

  Background:
    Given que estoy en la página

  Scenario Outline: Login correcto
    When escribo el username "<user>"
    And escribo el password "<password>"
    And pulso en el botón del Login
    Then valido que he accedido correctamente a la página

    Examples:
      | user                    | password     |
      | standard_user           | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |

  Scenario Outline: Login incorrecto
    When escribo el username "<user>"
    And escribo el password "<password>"
    And pulso en el botón del Login
    Then valido que aparece el mensaje de error

    Examples:
      | user         | password     |
      | standard_use | secret_sauce |
      | bad_user     | bad_password |