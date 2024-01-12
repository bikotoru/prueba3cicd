Feature: Iniciar sesión en localhost:8081

  Scenario: Iniciar sesión con usuario y contraseña
    Given I am on the login page
    When I enter the username "carlosdiaz" and password "carlos123"
    And I click the login button
    Then I should see "Carlos" on the page
